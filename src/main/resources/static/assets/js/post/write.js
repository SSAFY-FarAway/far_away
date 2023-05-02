document.querySelector("#btn-register").addEventListener("click", function () {
    if (!document.querySelector("#subject").value) {
        alert("제목 입력!!");
        return;
    } else if (!document.querySelector("#content").value) {
        alert("내용 입력!!");
        return;
    } else {
        document.querySelector("#form-register").addEventListener("click", function (){
            let writeInfo = {
                memberId : document.querySelector("#member-id").getAttribute("memberId"),
                category : "추후논의",
                title : document.querySelector("#subject").value,
                content : document.querySelector("#content").value,
            }
            console.log(writeInfo);
            let config = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(writeInfo),
            };
            fetch(root + "/post/", config)
                .then((response) => response.json());
                location.href = root + "/post-list";
        })


    }
});