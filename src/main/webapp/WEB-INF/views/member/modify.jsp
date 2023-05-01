<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<!-- Head -->
<jsp:include page="../fragment/head.jsp"/>

<body id="page-top">
<!-- Navigation-->
<jsp:include page="../fragment/nav.jsp"/>

<!-- Masthead-->
<header class="masthead">
    <div class="container">
        <div class="masthead-subheading">Wherever You Go</div>
    </div>
</header>

<!-- signup section -->
<section id="modify-section">
    <div class="container">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black shadow" style="border-radius: 25px">
                    <div class="card-body p-md-5 sh">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                                    Modify MyInfo
                                </p>
                                <form class="mx-1 mx-md-4" id="form-modify" method="POST" action="">
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-file-signature fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="login-id" name="loginId" class="form-control" readonly
                                            />
                                            <label class="form-label" for="login-id">ID</label>
                                        </div>

                                    </div>
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="last-name" name='lastName' class="form-control"
                                            />
                                            <label class="form-label" for="last-name">Last Name</label>
                                            <input type="text" id="first-name" name='firstName' class="form-control"
                                            />
                                            <label class="form-label" for="first-name">First Name</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="mileage" name='mileage' class="form-control"  readonly
                                            />
                                            <label class="form-label" for="mileage">Mileage</label>
                                            <input type="text" id="role" name='role' class="form-control"  readonly/>
                                            <label class="form-label" for="role">Role</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-birthday-cake fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="birth" name="birth" class="form-control"/>
                                            <label class="form-label" for="birth">Your Birth (ex. 990101)</label>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-envelope fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="email" id="email" name="email" class="form-control"  readonly/>
                                            <label class="form-label" for="email">Your Email</label>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row mb-4">
                                        <i class="mt-2 fas fa-home fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="text" id="zipcode" name="zipcode" class="form-control"
                                            />
                                            <label class="form-label" for="zipcode">Your Zipcode (ex. 90000)</label>
                                            <input type="text" id="main-address" name="mainAddress"
                                                   class="form-control"/>
                                            <label class="form-label" for="main-address" >Your Main
                                                Address</label>
                                            <input type="text" id="sub-address" name="subAddress" class="form-control"/>
                                            <label class="form-label" for="sub-address" >Your Sub
                                                Address</label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="button"
                                           class="btn btn-primary btn-lg shadow" id="modify-button">
                                            Modify
                                        </button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="${root}/resources/static/assets/img/member/login-section.jpg"
                                     class="img-fluid" alt="Sample image"/></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<jsp:include page="../fragment/footer.jsp"/>

<%-- 메시지 출력 --%>
<c:if test="${not empty msg}">
    <script>
        alert("${msg}");
    </script>
</c:if>

<!-- JS Imports -->
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- JS files-->
<script src="${root}/resources/static/assets/js/script.js"></script>
<script src='${root}/resources/static/assets/js/member/modify.js'></script>

</body>

</html>

