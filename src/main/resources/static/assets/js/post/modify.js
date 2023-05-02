window.onload = function () {
    initView();
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

    document.getElementById("subject").value = data['title'];
    // title.innerText = data['id'] + "." + data['title'];

    // let memberId = document.getElementById("member-id");
    // memberId.innerText = data['loginId'];
    //
    // let createdDate = document.getElementById("created-date");
    // createdDate.innerText = data['createdDate'].substring(0, 10);
    //
    // let hit = document.getElementById("hit");
    // hit.innerText = "조회수: " + data['hit'];
    //
    //
    // let category = document.getElementById("category");
    // category.innerText = " [" + data['category'] + "]";

   document.getElementById("content").value = data['content']
    // content.innerText = data['content'];

    let btnArea = document.getElementById("btn-area");
    let loginMemberId = document.getElementById("user").getAttribute("login-member");

    if (data['memberId'].toString() === loginMemberId) {
        let btnSave = document.createElement("button");
        btnSave.id = "btn-mv-modify";
        btnSave.className = "btn btn-outline-success shadow-sm mb-3 ms-1";
        btnSave.type = "button";
        btnSave.innerText = "수정";
        btnSave.addEventListener("click", ()=>btnSaveOnClick(data));
        btnArea.appendChild(btnSave);

        let btnCancel = document.createElement("button");
        btnCancel.id = "btn-delete";
        btnCancel.className = "btn btn-outline-danger shadow-sm mb-3 ms-1";
        btnCancel.type = "button";
        btnCancel.innerText = "취소";
        btnCancel.addEventListener("click", ()=>btnMoveOnClick("/mvPost?id=" + postId));
        btnArea.appendChild(btnCancel);
    }
    document.getElementById("btn-list").addEventListener("click", ()=>btnMoveOnClick("post-list"));

}

const btnMoveOnClick = (url) => {
    location.href = root + url;
}


const btnSaveOnClick = (data) =>{
    if (confirm("수정하시겠습니까?")) {
        let saveInfo = {
            id : data['id'],
            category : "추후논의",
            title : document.querySelector("#subject").value,
            content : document.querySelector("#content").value,
        }
        let config = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(saveInfo),
        };
        fetch(root + "/post/", config)
            .then((response) => response.json());
            location.href = root + "/mvPost?id=" + data['id'];

    }
}

