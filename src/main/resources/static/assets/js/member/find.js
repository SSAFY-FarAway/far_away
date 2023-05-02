window.onload = () => {
    document.getElementById("find-id-button").addEventListener("click",findId);
    document.getElementById("find-pwd-button").addEventListener("click",findPwd);
}

const findId = () => {
    const email = document.getElementById("find-id-email").value;
    const birth = document.getElementById("find-id-birth").value;
    const url = `${root}/member/login-id?email=${email}&birth=${birth}`
    fetch(url).then(res => res.json()).then(data => handleFindIdResponse(data));
}

const handleFindIdResponse = (data) => {
    switch(data.success) {
        case 'true' : {
            console.log(`회원님의 아이디는 [ ${data.loginId} ] 입니다.`);
            alert(`회원님의 아이디는 [ ${data.loginId} ] 입니다.`);
            break;
        }
        case 'false' : {
            console.log(`아이디 찾기 실패 ! ${data.errorMsg}`);
            alert(`아이디 찾기 실패 ! ${data.errorMsg}`);
            break;
        }
        default : break;
    }
}
const findPwd = () => {
    const loginId = document.getElementById("find-pwd-login-id").value;
    const email = document.getElementById("find-pwd-email").value;
    const birth = document.getElementById("find-pwd-birth").value;
    const url = `${root}/member/login-pwd?loginId=${loginId}&email=${email}&birth=${birth}`

    fetch(url).then(res => res.json()).then(data => handleFindPwdResponse(data));
}

const handleFindPwdResponse = (data) => {
    switch(data.success) {
        case 'true' : {
            console.log(`임시 비밀번호 [ ${data.loginPwd} ]로 초기화 되었습니다. 비밀번호를 변경 후 이용해주세요.`);
            alert(`임시 비밀번호 [ ${data.loginPwd} ]로 초기화 되었습니다. 비밀번호를 변경 후 이용해주세요.`);
            break;
        }
        case 'false' : {
            console.log(`비밀번호 찾기 실패 ! ${data.errorMsg}`);
            alert(`비밀번호 찾기 실패 ! ${data.errorMsg}`);
            break;
        }
        default : break;
    }
}