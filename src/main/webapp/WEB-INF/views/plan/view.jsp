<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../fragment/head.jsp"/>
<body id="page-top">
<jsp:include page="../fragment/nav.jsp"/>

<header class="masthead">
    <div class="masthead-subheading">Share Wherever Your Plan</div>
</header>

<section class="page-section p-3 mt-3" id="share-plan-list">
    <div class="text-center fw-bold" role="alert">
        <h2 class="section-heading text-uppercase">Write Travel Plan</h2>
        <h3 class="section-subheading text-muted">
            원하는 여행경로를 공유해보세요.
        </h3>
        <div class="container" id="article-list-section">
            <div class="row align-self-center mb-2">
                <div class="col-4">
                    <%--지도위치--%>
                    <div id="map" class="mt-3 shadow" style="width: 100%; height: 600px"></div>
                </div>
                <div class="col-4">
                    <%--지도위치--%>
                    <div id="shortest-map" class="mt-3 shadow" style="width: 100%; height: 600px"></div>
                </div>
                <div class="col-3 ms-1">
                    <%--글제목,내용 위치--%>
                    <div class="h2 row d-flex justify-content-around mb-2" >
                        Travle Plan
                    </div>
                    <div class="row d-flex justify-content-end mb-2" id = "writerId">
                    <%--작성자 --%>
                    </div>
                    <div class="h5 row d-flex justify-content-start">
                        Title
                    </div>
                    <div class="row mb-2">
                        <div class="p-2 border shadow-sm" id="title">
                            <%--제목--%>
                        </div>
                    </div>
                    <div class="h5 row d-flex justify-content-start">
                        Content
                    </div>
                    <div class="row mb-2">
                        <div class="p-2 border shadow-sm" style="height: 300px;" id="content">
                            <%--내용--%>
                        </div>
                    </div>
                    <div class="ros d-flex justify-content-center">
                        <%--TODO: 작성한 회원 == 로그인 회원 해당 버튼 띄우기--%>
                        <button id="btn-modify" class="btn btn-outline-success shadow" type="button">
                            Modify
                        </button>
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
    <div id="user" style='display: none;'>${userinfo.id}</div>
</footer>
<!-- Footer end -->

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/static/assets/js/script.js"></script>

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<!-- kakao api JS -->
<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65e66ed3a412cb73e32b300c2f3a1803&libraries=services,clusterer,drawing"></script>
<script src="resources/static/assets/js/plan/view.js"></script>

</body>

</html>