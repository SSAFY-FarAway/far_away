window.onload = () => {
    getLoginMemberInfo();
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
    let loginId = document.getElementById("login-id");
    let lastName = document.getElementById("last-name");
    let firstName = document.getElementById("first-name");
    let mileage = document.getElementById("mileage");
    let role = document.getElementById("role");
    let birth = document.getElementById("birth");
    let email = document.getElementById("email");
    let zipcode = document.getElementById("zipcode");
    let mainAddress = document.getElementById("main-address");
    let subAddress = document.getElementById("sub-address");

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