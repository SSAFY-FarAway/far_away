<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>LTW</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="resources/static/assets/favicon.ico" />
    <!-- service Key -->
    <!-- <script src="./js/key.js"></script> -->
    <!-- bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet"
          type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="resources/static/assets/css/style.css" rel="stylesheet" />
    <link href="resources/static/assets/css/map.css" rel="stylesheet" />
</head>

<jsp:include page="../fragment/head.jsp"/>
<body id="page-top">
<jsp:include page="../fragment/nav.jsp"/>

<header class="masthead">
    <div class="masthead-subheading">Share Wherever Your Plan</div>
</header>

<section>
    <div class="container" id="mypage-section">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black shadow border border-primary" style="border-radius: 25px">
                    <div class="card-body p-md-5 sh" id="bgimg">
                        <div class="row justify-content-center">
                            <div class="container" id="article-list-section">
                                <div class="row justify-content-center">
                                    <div class="col-lg-8 col-md-10 col-sm-12">
                                        <h2 class="border border-warning rounded my-3 py-3 shadow-sm  text-center">
                                            글쓰기
                                        </h2>
                                    </div>
                                    <div class="col-lg-8 col-md-10 col-sm-12">
                                        <form id="form-register" method="POST" action="">
                                            <input type="hidden" name="action" value="write">
                                            <div class="mb-3">
                                                <label for="title" class="form-label fw-bolder">제목 :
                                                </label>
                                                <input type="text" class="form-control" id="title"
                                                       name="title" placeholder="제목..." />
                                            </div>
                                            <div class="mb-3">
                                                <label for="content" class="form-label fw-bolder">내용 :
                                                </label>
                                                <textarea class="form-control" id="content" name="content"
                                                          rows="7"></textarea>
                                            </div>
                                            <div class="mb-3">
                                                <label for="zipcode" class="form-label fw-bolder">우편번호 :
                                                </label>
                                                <input type="text" class="form-control" id="zipcode"
                                                       name="zipcode" placeholder="우편번호..." />
                                            </div>
                                            <div class="mb-3">
                                                <label for="main-address" class="form-label fw-bolder">주소 :
                                                </label>
                                                <input type="text" class="form-control" id="main-address"
                                                       name="main-address" placeholder="주소..." />
                                            </div>
                                            <div class="mb-3">
                                                <label for="sub-address" class="form-label fw-bolder">상세주소 :
                                                </label>
                                                <input type="text" class="form-control" id="sub-address"
                                                       name="sub-address" placeholder="상세주소..." />
                                            </div>
                                            <div class="mb-3">
                                                <label for="rating" class="form-label fw-bolder">평점 :
                                                </label>
                                                <input type="text" class="form-control" id="rating"
                                                       name="rating" placeholder="평점..." />
                                            </div>
                                            <div class="col-auto text-center">
                                                <button type="button" id="btn-save"
                                                        class="btn shadow btn-primary mb-3">
                                                    글작성
                                                </button>
                                                <button type="reset"
                                                        class="btn btn-danger shadow mb-3">초기화</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer start-->
<footer class="footer py-4 mt-5">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 text-lg-start">
                Copyright &copy; Your Website 2022
            </div>
            <div class="col-lg-4 my-3 my-lg-0">
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"><i class="fab fa-twitter"></i></a>
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook"><i
                        class="fab fa-facebook-f"></i></a>
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn"><i
                        class="fab fa-linkedin-in"></i></a>
            </div>
            <div class="col-lg-4 text-lg-end">
                <a class="link-dark text-decoration-none me-3" href="#!">Privacy Policy</a>
                <a class="link-dark text-decoration-none" href="#!">Terms of Use</a>
            </div>
        </div>
    </div>
    <div id="user" style='display: none;' login-member="${loginMember.id}"></div>
</footer>
<!-- Footer end -->

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/static/assets/js/script.js"></script>
<script src="resources/static/assets/js/hotplace/write.js"></script>

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<!-- kakao api JS -->
<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65e66ed3a412cb73e32b300c2f3a1803&libraries=services,clusterer,drawing"></script>
</body>

</html>