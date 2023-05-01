window.onload = () => {
    document.getElementById("login-button").addEventListener("click", loginSubmit);
}

const loginSubmit = () => {
    let loginId = document.getElementById("loginId");
    let loginPw = document.getElementById("loginPw");

    if (!loginId.value) {
        alert("아이디를 입력해주세요.");
        loginId.focus();
        return;
    }

    if (!loginPw.value) {
        alert("비밀번호를 입력해주세요.");
        loginPw.focus();
        return;
    }

    let form = document.getElementById("login-form");
    let url = root + "/member/auth";
    // form.setAttribute("action",url);
    // form.submit();

    fetch(url, {
        method: "post",
        body: JSON.stringify({
                loginId: loginId, loginPwd: loginPw
            }
        )
    }).then(res => console.log(res));
}