window.onload = function () {
    initView();
}

const urlParams = new URLSearchParams(location.search);
const hotPlaceId = urlParams.get("id");

function initView() {
    fetch(root + "/hotplace/" + hotPlaceId)
        .then((response) => {
            response.json().then((data) => {
                makeView(data)
            });
        });

    fetch(root + "/hotplace/" + hotPlaceId + "/file")
        .then((response) => {
            response.json().then((data) => {
                makeFileView(data)
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

    let rating = document.getElementById("rating");
    rating.innerText = "평점: " + data['rating'] + " / 5";

    let zipcode = document.getElementById("zipcode");
    zipcode.innerText = "우편번호 [" + data['zipcode'] + "]";

    let address = document.getElementById("address");
    address.innerText = "상세 주소: " + data['mainAddress'] + " " + data['subAddress'];

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
        btnModify.addEventListener("click", ()=>btnMoveOnClick(`/hotplace-modify/${hotPlaceId}`));
        btnArea.appendChild(btnModify);

        let btnDelete = document.createElement("button");
        btnDelete.id = "btn-delete";
        btnDelete.className = "btn btn-outline-danger shadow-sm mb-3 ms-1";
        btnDelete.type = "button";
        btnDelete.innerText = "글 삭제";
        btnDelete.addEventListener("click", btnDeleteOnClick);
        btnArea.appendChild(btnDelete);
    }
    document.getElementById("btn-list").addEventListener("click", ()=>btnMoveOnClick("/hotplace-list"));
}

function makeFileView (data) {
    let fileInfos = document.getElementById("fileInfos");
    data.list.forEach(fileInfo => {
        let li = document.createElement("li");
        li.innerText = fileInfo['originalFile'];

        let a = document.createElement("a");
        a.className = "btn btn-outline-primary";
        a.href = root + "/file/download/" + fileInfo['saveFolder'] + "/" + fileInfo['originalFile'] + "/" + fileInfo['saveFile'];
        a.innerText = "[다운로드]";
        li.appendChild(a);
        fileInfos.appendChild(li);
    })
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
            fetch(root + "/hotplace", config)
                .then((response) => {
                    if(response.status == 200) {
                        location.href = root + "/hotplace-list#hotplace-list";
                    }
                });
    }
}
