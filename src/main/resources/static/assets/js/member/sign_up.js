window.onload = () => {
    // signUp 관련 이벤트 리스너
    document.getElementById("id-check-btn").addEventListener("click", idCheck);
    document.getElementById("login-pwd-confirm").addEventListener("keyup", pwdCheck);
    document.getElementById("register-button").addEventListener("click", signUp);
};

let loginPwdInput = document.getElementById("login-pwd");
let loginPwdConfirmInput = document.getElementById("login-pwd-confirm");
let loginPwdConfirmMsg = document.getElementById("loginPwdConfirmMsg");
let isPwdConfirmValid = false;
let isIdValid = false;


// 아이디 확인
const idCheck = () => {
    let loginId = document.getElementById("loginId");
    let url = root + "/member/idCheck";

    fetch(url)
        .then(response => response.text())
        .then(data => {
            console.log(data);
            if (data != 0) {
                // 아이디 중복
                alert(loginId.value + "는 사용할 수 없습니다.");
                loginId.value = "";
                loginId.focus();
                isIdValid = false;

            } else {
                alert(loginId.value + "는 사용할 수 있습니다.")
                loginId.readOnly = true;
                isIdValid = true;
            }
        });
}

// 비밀번호 확인
const pwdCheck = () => {
    // TODO: 조인 버튼이 눌리는 경우 => idCheck가 false 이면 아이디 중복 검사하라는 알림 띄우기
    // TODO: 비밀번호 일치하지 않는 경우 span으로 비번 일치하지 않는다. 띄우기
    if (loginPwdInput.value == loginPwdConfirmInput.value) {
        loginPwdConfirmMsg.innerText = "비밀번호가 일치합니다.";
        loginPwdConfirmMsg.className = "text-primary";
        isPwdConfirmValid = true;
    } else {
        loginPwdConfirmMsg.innerText = "비밀번호가 일치하지 않습니다.";
        loginPwdConfirmMsg.className = "text-danger";
        isPwdConfirmValid = false;
    }
}

// 회원 가입
let signUp = () => {
    if (!idCheck) {
        // 아이디 중복 체크 하지 않음
        alert("아이디 중복 확인을 해주세요.");
        loginId.focus();
        return;
    }

    if (!isPwdConfirmValid) {
        // 비밀번호가 일치하지 않음
        alert("비밀번호가 일치하지 않습니다.");
        loginPwdConfirmInput.focus();
        return;
    }

    let loginId = document.getElementById("login-id").value;
    let loginPwd = document.getElementById("login-pwd").value;
    let lastName = document.getElementById("last-name").value;
    let firstName = document.getElementById("first-name").value;
    let birth = document.getElementById("birth").value;
    let email = document.getElementById("email").value;
    let zipcode = document.getElementById("zipcode").value;
    let mainAddress = document.getElementById("main-address").value;
    let subAddress = document.getElementById("sub-address").value;

    if (!(loginId && loginPwd && lastName && firstName && birth && email && zipcode && mainAddress && subAddress)) {
        alert("모든 정보를 입력해주세요.");
        return;
    }

    const url = root + "/member/sign-up";
    fetch(url, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
                loginId,
                loginPwd,
                lastName,
                firstName,
                birth,
                email,
                zipcode,
                mainAddress,
                subAddress,
                salt: "salt" // TODO: 나중에 없앨 것.
            }
        )
    }).then(res => handleSignUpResponse(res));
}

const handleSignUpResponse = (res) => {
    // TODO : 이메일 중복확인 로직 추가해줘야 함.
    // TODO : 회원가입 실패 시, 무엇 때문에 실패했는지 RESPONSE (상태코드 + 에러메시지)로 남겨줘야 함.
    console.log(res);
    switch (res.status) {
        case 200 : {
            console.log("회원가입 성공! 로그인 페이지로 이동.");
            alert("회원가입 성공 !");
            location.href = root + "/login";
            break;
        }
        case 500 : {
            console.log("회원가입 실패!");
            alert("회원가입 실패 !");
            break;
        }
        default:
            break;
    }
}



