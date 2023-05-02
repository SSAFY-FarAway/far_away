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

<section class="page-section p-3 mt-3" id="hotplace-list">
    <div class="text-center fw-bold" role="alert">
        <h2 class="section-heading text-uppercase">Hot Place</h2>
        <h3 class="section-subheading text-muted">
            여행지의 핫플레이스를 공유해보세요.
        </h3>
        <div class="container" id="article-list-section">
            <div class="row align-self-center mb-2">
                <div class="col-md-2 text-start">
                    <button type="button" id="btn-mv-save" class="btn btn-outline-primary btn shadow-sm">
                        글쓰기
                    </button>
                </div>
                <div class="col-md-7 offset-3">
                    <form class="d-flex" id="search-form">
                        <input type="hidden" id="key-attribute" value="${key}">
                        <input type="hidden" id="word-attribute" value="${word}">
                        <select id="key"
                                class="font-weight-bold shadow-sm form-select form-select-sm ms-5 me-1 w-50"
                                aria-label="검색조건">
                            <option selected>검색조건</option>
                            <option value="p.title"}>제목</option>
                            <option value="m.login_id">작성자</option>
                        </select>
                        <div class="input-group shadow-sm">
                            <input type="text" name="word" id="word" class="form-control" value="${word}" placeholder="검색어..." />
                            <button class="btn btn-primary" id="btn-search"type="button">Search</button>
                        </div>
                    </form>
                </div>
            </div>
            <table class="table table-hover shadow rounded" id="hotplace-table">
                <thead>
                <tr class="text-center table-warning">
                    <th scope="col">핫플 번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">조회수</th>
                    <th scope="col">평점</th>
                    <th scope="col">작성일</th>
                </tr>
                </thead>
            </table>
            <nav aria-label="Page navigation" class="row" id="navigation">
                <div style="display:none" id="currentPage">${page}</div>
            </nav>
        </div>
        <form id="form-param" method="get" action="">
            <input type="hidden" id="p-action" name="action" value="">
            <input type="hidden" id="p-pgno" name="pgno" value="">
            <input type="hidden" id="p-key" name="key" value="">
            <input type="hidden" id="p-word" name="word" value="">
        </form>
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
<script src="resources/static/assets/js/hotplace/list.js"></script>

<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<!-- kakao api JS -->
<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65e66ed3a412cb73e32b300c2f3a1803&libraries=services,clusterer,drawing"></script>
</body>

</html>