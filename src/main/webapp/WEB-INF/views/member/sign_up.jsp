<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
<jsp:include page="../fragment/head.jsp"/>

<body id="page-top">
<!-- Navigation -->
<jsp:include page="../fragment/nav.jsp"/>

<!-- Masthead-->
<header class="masthead">
    <div class="container">
        <div class="masthead-subheading">Wherever You Go</div>
    </div>
</header>

<!-- signup section -->
<section id="signup-section">
    <div class="container">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black shadow" style="border-radius: 25px">
                    <div class="card-body p-md-5 sh">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                                    Sign up
                                </p>

                                <form class="mx-1 mx-md-4" id="form-join" method="POST" action="">
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-file-signature fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0 me-3">
                                            <input type="text" id="login-id" name="loginId" class="form-control" />
                                            <label class="form-label" for="login-id">ID</label>
                                        </div>
                                        <!-- 아이디 중복 버튼  -->
                                        <div class="col-2">
                                            <button id="id-check-btn" class="btn btn-outline-success shadow" type="button">
                                                check
                                            </button>
                                        </div>
                                        <div>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row mb-4">
                                        <i class=" mt-2 fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="login-pwd" name="loginPwd" class="form-control" />
                                            <label class="form-label" for="login-pwd">Password</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row  mb-4">
                                        <i class="mt-2 fas fa-key fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="password" id="login-pwd-confirm" class="form-control" />
                                            <label class="form-label" for="login-pwd-confirm">Repeat your password</label> </br>
                                            <span id="loginPwdConfirmMsg"> </span>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="last-name" name='lastName' class="form-control" />
                                            <label class="form-label" for="last-name">Last Name</label>
                                            <input type="text" id="first-name" name='firstName' class="form-control" />
                                            <label class="form-label" for="first-name">First Name</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-birthday-cake fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="birth" name="birth" class="form-control" />
                                            <label class="form-label" for="birth">Your Birth (ex. 990101)</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="email" id="email" name="email" class="form-control" />
                                            <label class="form-label" for="email">Your Email</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-home fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="zipcode" name="zipcode" class="form-control" />
                                            <label class="form-label" for="zipcode">Your Zipcode (ex. 90000)</label>
                                            <input type="text" id="main-address" name="mainAddress" class="form-control" />
                                            <label class="form-label" for="main-address">Your Main Address</label>
                                            <input type="text" id="sub-address" name="subAddress" class="form-control" />
                                            <label class="form-label" for="sub-address">Your Sub Address</label>
                                        </div>

                                    </div>

                                    <%-- 전화번호 폼--%>
<%--                                    <div class="d-flex flex-row mb-4">--%>
<%--                                        <i class="mt-2 fas fa-phone  fa-lg me-3 fa-fw"></i>--%>
<%--                                        <div class="form-outline flex-fill mb-0">--%>
<%--                                            <input type="tel" id="phone" name="phone" class="form-control"--%>
<%--                                                   pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required>--%>
<%--                                            <label class="form-label" for="phone">Your Phone</label> </br>--%>
<%--                                            <small>Format: 010-1234-7890</small>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="button" class="btn btn-primary btn-lg shadow" id="register-button">
                                            Register
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="${root}/resources/static/assets/img/member/login-section.jpg" class="img-fluid" alt="Sample image"/>                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../fragment/footer.jsp"/>

<!-- JS Imports -->
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- JS files-->
<script src="${root}/resources/static/assets/js/script.js"></script>
<script src='${root}/resources/static/assets/js/member/sign_up.js'></script>

</body>

</html>