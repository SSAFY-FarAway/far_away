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
}

function makeView(data) {
    document.getElementById("title").value = data['title'];
    document.getElementById("content").value = data['content'];
    document.getElementById("zipcode").value = data['zipcode'];
    document.getElementById("main-address").value = data['mainAddress'];
    document.getElementById("sub-address").value = data['subAddress'];
    document.getElementById("rating").value = data['rating'];
    document.getElementById("btn-modify").addEventListener("click", btnModifyOnClick);
}

const btnModifyOnClick = () =>{
    if (confirm("수정하시겠습니까?")) {
        let saveInfo = {
            id : hotPlaceId,
            memberId: document.getElementById("user").getAttribute("login-member"),
            title: document.getElementById("title").value,
            content: document.getElementById("content").value,
            zipcode: document.getElementById("zipcode").value,
            mainAddress: document.getElementById("main-address").value,
            subAddress: document.getElementById("sub-address").value,
            rating: document.getElementById("rating").value,
        }
        let config = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(saveInfo),
        };
        fetch(root + "/hotplace", config)
            .then((response) => {
                if(response.status == 200) {
                    location.href = root + `/hotplace-view?id=${hotPlaceId}`;
                }
            });
    }
}

