window.onload = () => {
    document.getElementById("find-id-button").addEventListener("click",findId);
    document.getElementById("find-pwd-button").addEventListener("click",findPwd);
}

const findId = () => {
    const email = document.getElementById("find-id-email");
    const birth = document.getElementById("find-id-birth");
    const url = `${root}/member/login-id/`

    fetch(url).then(res => console.log(res));
}

const findPwd = () => {
    const id = document.getElementById("find-pwd-id");
    const email = document.getElementById("find-pwd-email");
    const birth = document.getElementById("find-pwd-birth");
    const url = `${root}/member/login-pwd/`

    fetch(url).then(res => console.log(res));
}