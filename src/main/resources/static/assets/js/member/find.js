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
    const id = document.getElementById("find-pwd-id");
    const email = document.getElementById("find-pwd-email");
    const birth = document.getElementById("find-pwd-birth");
    const url = `${root}/member/login-pwd/`

    fetch(url).then(res => console.log(res));
}