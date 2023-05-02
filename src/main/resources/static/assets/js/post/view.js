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

}

function addOnClickEventListeners() {
    document.getElementById("btn-list").addEventListener("click", function () {
        location.href = root + "/post-list";
    });

    document.getElementById("btn-mv-modify").addEventListener("click", function () {
        location.href = root + "/post-update"
    });
}