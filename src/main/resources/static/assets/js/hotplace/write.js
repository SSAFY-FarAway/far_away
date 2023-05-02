document.getElementById("btn-save").addEventListener("click", function () {
    if (!document.getElementById("title").value) {
        alert("제목을 입력해주세요.");
        return;
    } else if (!document.getElementById("content").value) {
        alert("내용을 입력해주세요.");
        return;
    } else if (!document.getElementById("zipcode").value) {
        alert("우편번호를 입력해주세요.");
        return;
    } else if (!document.getElementById("main-address").value) {
        alert("주소를 입력해주세요.");
        return;
    } else if (!document.getElementById("sub-address").value) {
        alert("상세주소를 입력해주세요.");
        return;
    } else if (!document.getElementById("rating").value) {
        alert("평점을 입력해주세요.");
        return;
    } else {
        document.getElementById("form-register").addEventListener("click", function (){
            let hotPlaceInfo = {
                memberId : document.getElementById("user").getAttribute("login-member"),
                title : document.getElementById("title").value,
                content : document.getElementById("content").value,
                zipcode : document.getElementById("zipcode").value,
                mainAddress : document.getElementById("main-address").value,
                subAddress : document.getElementById("sub-address").value,
                rating : document.getElementById("rating").value,
            }
            console.log(hotPlaceInfo);
            let config = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(hotPlaceInfo),
            };
            fetch(root + "/hotplace/", config)
                .then((response) => response.json());
            // location.href = root + "/post-list";
        })


    }
});