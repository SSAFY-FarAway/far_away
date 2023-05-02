window.onload = function () {
    initView();
    addOnClickEventListeners();
}

const urlParams = new URLSearchParams(location.search);
const postId = urlParams.get("id");

function initView() {
    fetch(root + "/post/" + postId)
        .then((response) => {
            response.json().then((data) => {
                makeView(data)
            });
        });
}

function makeView(data) {

    let title = document.getElementById("title");
    title.innerText = data['id'] + "." + data['title'];

    let memberId = document.getElementById("member-id");
    memberId.innerText = data['loginId'];

    let createdDate = document.getElementById("created-date");
    createdDate.innerText = data['createdDate'].substring(0, 10);

    let hit = document.getElementById("hit");
    hit.innerText = "조회수: " + data['hit'];


    let category = document.getElementById("category");
    category.innerText = " [" + data['category'] + "]";

    let content = document.getElementById("content");
    content.innerText = data['content'];

    let btnArea = document.getElementById("btn-area");
    let loginMemberId = document.getElementById("user").getAttribute("login-member");

    if (data['memberId'].toString() === loginMemberId) {
        let btnModify = document.createElement("button");
        btnModify.id = "btn-mv-modify";
        btnModify.className = "btn btn-outline-success shadow-sm mb-3 ms-1";
        btnModify.type = "button";
        btnModify.innerText = "글수정";
        btnModify.addEventListener("click", ()=>btnMoveOnClick(`/mvPostModify?id=${postId}`));
        btnArea.appendChild(btnModify);

        let btnDelete = document.createElement("button");
        btnDelete.id = "btn-delete";
        btnDelete.className = "btn btn-outline-danger shadow-sm mb-3 ms-1";
        btnDelete.type = "button";
        btnDelete.innerText = "글 삭제";
        btnDelete.addEventListener("click", btnDeleteOnClick);
        btnArea.appendChild(btnDelete);
    }
    document.getElementById("btn-list").addEventListener("click", ()=>btnMoveOnClick("/post-list"));

}

const btnMoveOnClick = (url) => {
    location.href = root + url;
}


const btnDeleteOnClick = () =>{
    if (confirm("삭제하시겠습니까?")) {
        let config = {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        };
        fetch(root + "/post/" + postId, config)
            .then((response) => response.json());
        location.href = root + "/post-list";
    }
}

