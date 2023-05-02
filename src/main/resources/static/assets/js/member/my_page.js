let modifyMode = false;
const loginId = document.getElementById("login-id");
const lastName = document.getElementById("last-name");
const firstName = document.getElementById("first-name");
const mileage = document.getElementById("mileage");
const role = document.getElementById("role");
const birth = document.getElementById("birth");
const email = document.getElementById("email");
const zipcode = document.getElementById("zipcode");
const mainAddress = document.getElementById("main-address");
const subAddress = document.getElementById("sub-address");

const modifyBtn = document.getElementById("modify-button");
const modifySubmitBtn = document.getElementById("modify-submit-button");
const cancelBtn = document.getElementById("modify-cancel-button");
let loginPwd = "";

window.onload = () => {
    getLoginMemberInfo();
    modifyBtn.addEventListener("click", modify);
    modifySubmitBtn.addEventListener("click", modifySubmit);
    cancelBtn.addEventListener("click", cancel);
}
const getLoginMemberInfo = () => {
    // TODO : 자신의 id만 조회할 수 있게 해야하는데, 지금은 url로 접근하면 어떤 id든 접근 가능.
    // TODO : 이렇게 해놓은 이유가, LoginDto에는 마이페이지에 띄울 모든 정보를 가지고 있지 않음.
    const urlParams = new URLSearchParams(location.search);
    const id = urlParams.get("id");
    const url = `${root}/member/${id}`
    console.log(url)
    fetch(url).then(res => res.json()).then(data => displayMemberInfo(data));
}

const displayMemberInfo = (data) => {
    loginId.value = data.loginId;
    lastName.value = data.lastName;
    firstName.value = data.firstName;
    mileage.value = data.mileage;
    role.value = data.role ? "일반회원" : "관리자"
    birth.value = data.birth;
    email.value = data.email;
    zipcode.value = data.zipcode;
    mainAddress.value = data.mainAddress;
    subAddress.value = data.subAddress;
}

const modify = () => {
    const urlParams = new URLSearchParams(location.search);
    const id = urlParams.get("id");
    const url = `${root}/member/check`;

    loginPwd = window.prompt("비밀번호를 입력해주세요.");

    fetch(url, {
        method: "post",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
                id: id,
                loginPwd: loginPwd
            }
        )
    }).then(res => console.log(res));

    const success = () => {
        modifyMode = true;
        changeView();
    }

    const fail = () => {
        alert("비밀번호가 틀렸습니다.");
    }

}

const modifySubmit = () => {
    if (!(loginId.value && loginPwd.value && lastName.value && firstName.value && birth.value && email.value && zipcode.value && mainAddress.value && subAddress.value)) {
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
                loginId : loginId.value,
                loginPwd : loginPwd.value,
                lastName : lastName.value,
                firstName : firstName.value,
                birth : birth.value,
                email : email.value,
                zipcode : zipcode.value,
                mainAddress : mainAddress.value,
                subAddress : subAddress.value,
                salt: "salt" // TODO: 나중에 없앨 것.
            }
        )
    }).then(res => handleSignUpResponse(res));
}

const cancel = () => {
    modifyMode = false;
    changeView();
}

const changeView = () => {
    if (modifyMode) {
        // 수정 모드
        lastName.readOnly = false;
        firstName.readOnly = false;
        birth.readOnly = false;
        zipcode.readOnly = false;
        mainAddress.readOnly = false;
        subAddress.readOnly = false;
    } else {
        // 조회 모드
        lastName.readOnly = true;
        firstName.readOnly = true;
        birth.readOnly = true;
        zipcode.readOnly = true;
        mainAddress.readOnly = true;
        subAddress.readOnly = true;
    }
}