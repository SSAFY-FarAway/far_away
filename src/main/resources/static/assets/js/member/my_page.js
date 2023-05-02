// 일반모드 <-> 수정모드
let modifyMode = false;

// text-fileds
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

// 수정버튼 부모 div <-> 제출버튼 & 취소버튼 부모 div
const normalModeBtns = document.getElementById("normal-mode-btns");
const modifyModeBtns = document.getElementById("modify-mode-btns");

// 각각의 버튼 요소
const modifyBtn = document.getElementById("modify-button");
const modifySubmitBtn = document.getElementById("modify-submit-button");
const cancelBtn = document.getElementById("modify-cancel-button");

let loginPwd = "";

window.onload = () => {
    changeView();
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

    // TODO : 나중에 쿼리스트링 방식에서 body에서 받도록 해야함. (controller 단에서)
    loginPwd = window.prompt("비밀번호를 입력해주세요.");
    const url = `${root}/member/check?id=${id}&loginPwd=${loginPwd}`;

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
    }).then(res => (res.status === 200) ? success() : fail());

    const success = () => {
        alert("수정을 진행하세요.")
        modifyMode = true;
        changeView();
    }

    const fail = () => {
        alert("비밀번호가 틀렸습니다.");
    }

}

const modifySubmit = () => {
    const urlParams = new URLSearchParams(location.search);
    const id = urlParams.get("id");

    if (!(loginId.value && loginPwd && lastName.value && firstName.value && birth.value && email.value && zipcode.value && mainAddress.value && subAddress.value)) {
        alert("모든 정보를 입력해주세요.");
        return;
    }

    console.log(loginId.value, loginPwd, lastName.value, firstName.value, birth.value, email.value, zipcode.value, mainAddress.value, subAddress.value)
    const url = root + "/member/";
    fetch(url, {
        method: "put",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
                id : id,
                loginId: loginId.value,
                loginPwd: loginPwd,
                lastName: lastName.value,
                firstName: firstName.value,
                birth: birth.value,
                email: email.value,
                zipcode: zipcode.value,
                mainAddress: mainAddress.value,
                subAddress: subAddress.value,
                salt: "salt" // TODO: 나중에 없앨 것.
            }
        )
    }).then(res => handleModifyResponse(res));
}

const handleModifyResponse = (res) => {
    const urlParams = new URLSearchParams(location.search);
    const id = urlParams.get("id");
    console.log(res);
    switch (res.status) {
        case 200 : {
            console.log("회원정보 수정 성공! 마이페이지로 이동.");
            alert("회원정보 수정 성공! ");
            location.href = `${root}/myPage?id=${id}`;
            break;
        }
        case 500 : {
            console.log("회원정보 수정 실패!");
            alert("회원정보 수정 실패 !");
            break;
        }
        default:
            break;
    }
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
        modifyModeBtns.display = "block";
        normalModeBtns.display = "none";
    } else {
        // 조회 모드
        lastName.readOnly = true;
        firstName.readOnly = true;
        birth.readOnly = true;
        zipcode.readOnly = true;
        mainAddress.readOnly = true;
        subAddress.readOnly = true;
        modifyModeBtns.display = "none";
        normalModeBtns.display = "block";
    }
}

