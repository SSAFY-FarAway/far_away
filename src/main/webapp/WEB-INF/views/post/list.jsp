<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
    <!--HEAD-->
    <jsp:include page="../fragment/head.jsp"/>
</head>

<body id="page-top">
<!-- Navigation -->
<jsp:include page="../fragment/nav.jsp"/>

<!-- Masthead-->
<header class="masthead">
    <div class="container">
        <div class="masthead-subheading">Wherever You Go</div>
    </div>
</header>
<!-- login section -->
<section class="page-section p-3 mt-3" id="post-list">
    <div class="text-center fw-bold" role="alert">
        <h2 class="section-heading text-uppercase">COMMUNITY</h2>
        <h3 class="section-subheading text-muted">
            자유 게시판
        </h3>
        <div class="container" id="article-list-section">
            <div class="row align-self-center mb-2">
                <div class="col-md-2 text-start">
                    <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn shadow-sm">
                        글쓰기
                    </button>
                </div>
                <div class="col-md-7 offset-3">
                    <form class="d-flex ">
                        <select id="key"
                                class="font-weight-bold shadow-sm form-select form-select-sm ms-5 me-1 w-50"
                                aria-label="검색조건">
                            <option selected>검색조건</option>
                            <option value="articleno">글번호</option>
                            <option value="subject">제목</option>
                            <option value="userid">작성자</option>
                        </select>
                        <div class="input-group shadow-sm">
                            <input type="text" name="word" id="word" class="form-control" value="${word}" placeholder="검색어..." />
                            <button class="btn btn-primary" type="button">Search</button>
                        </div>
                    </form>
                </div>
            </div>
            <table class="table table-hover shadow rounded" id="post-table">
                <thead>
                <tr class="text-center table-warning">
                    <th scope="col">글번호</th>
                    <th scope="col">제목</th>
                    <th scope="col">분류</th>
                    <th scope="col">작성자</th>
                    <th scope="col">조회수</th>
                    <th scope="col">작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="article" items="${pagingResponse.list}">
                    <tr class="text-center">
                        <th scope="row">${article.id}</th>
                        <td class="text-start">
                            <a href="#" class="article-title link-dark" data-no="${article.id}"
                               style="text-decoration: none">
                                    ${article.id}
                            </a>
                        </td>
                        <td>${article.memberName}</td> <!--분류 -->
                        <td>${article.memberName}</td>
                        <td>${article.hit}</td>
                        <td>${article.createdDate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <nav aria-label="Page navigation" class="row" id="navigation">
                <div style="display:none" id="currentPage">${page}</div>
            </nav>
        </div>
    </div>
    <form id="form-param" method="get" action="">
        <input type="hidden" id="p-action" name="action" value="">
        <input type="hidden" id="p-pgno" name="pgno" value="">
        <input type="hidden" id="p-key" name="key" value="">
        <input type="hidden" id="p-word" name="word" value="">
    </form>
    </div>

</section>
<!-- Footer-->
<footer class="footer py-4">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 text-lg-start">
                Copyright &copy; Your Website 2022
            </div>
            <div class="col-lg-4 my-3 my-lg-0">
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"><i
                        class="fab fa-twitter"></i></a>
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
</footer>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/static/assets/js/script.js"></script>
<script src='resources/static/assets/js/login.js'></script>
<script src="resources/static/assets/js/post/list.js"></script>
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- * *                               SB Forms JS                               * *-->
<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


<script>
    let titles = document.querySelectorAll(".article-title");
    titles.forEach(function (title) {
        title.addEventListener("click", function () {
            console.log(this.getAttribute("data-no"));
            location.href = "${root}/article?action=view&articleId=" + this.getAttribute("data-no");
        });
    });
    document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "${root}/article?action=mvwrite";
    });
    let pages = document.querySelectorAll(".page-link");
    pages.forEach(function (page) {
        page.addEventListener("click", function () {
            console.log(this.parentNode.getAttribute("data-pg"));
            document.querySelector("#p-action").value = "list";
            document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
            document.querySelector("#p-key").value = "${param.key}";
            document.querySelector("#p-word").value = "${param.word}";
            document.querySelector("#form-param").submit();
        });
    });
    document.querySelector("#btn-search").addEventListener("click", function () {
        let form = document.querySelector("#form-search");
        form.setAttribute("action", "${root}/article");
        form.submit();
    });
    // select 요소 가져오기
    var selectElement = document.getElementById("key");
    // option 요소 중 value가 "subject"인 요소의 인덱스를 가져오기
    var optionIndex = Array.from(selectElement.options).findIndex(option => option.value === "${key}");
    // 해당 인덱스를 selectedIndex 속성으로 설정하여 해당 option을 선택하도록 함
    selectElement.selectedIndex = optionIndex;
</script>
</body>


</html>