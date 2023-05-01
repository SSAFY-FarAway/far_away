window.onload = () => {
    // login 관련 이벤트 리스너
    document.getElementById("login-button").addEventListener("click", login);
}

// 로그인
const login = () => {
    let loginId = document.getElementById("loginId").value;
    let loginPwd = document.getElementById("loginPw").value;

    if (!loginId) {
        alert("아이디를 입력해주세요.");
        loginId.focus();
        return;
    }

    if (!loginPwd) {
        alert("비밀번호를 입력해주세요.");
        loginPwd.focus();
        return;
    }

    let form = document.getElementById("login-form");
    let url = root + "/member/auth";
    // form.setAttribute("action",url);
    // form.submit();

    console.log(loginId, loginPwd)
    fetch(url, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
                loginId: loginId, loginPwd: loginPwd
            }
        )
    }).then(res => handleLoginResponse(res));
}

// 로그인 response 처리
const handleLoginResponse = (res) => {
    console.log(res);
    switch(res.status) {
        case 200 :
            console.log("로그인 성공");
            location.href = root;
            break;
        case 401 :
            console.log("로그인 에러");
            break;
        default : break;

    }
}
