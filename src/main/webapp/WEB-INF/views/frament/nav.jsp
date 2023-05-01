<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!-- Navigation   헤더 -->
<nav class="shadow navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
  <div class="container">
    <a class="navbar-brand fs-4" href="${root}">
      <!-- <img src="resources/static/assets/mg/navbar-logo.svg" alt="..." /> -->
      FAR AWAY
    </a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarResponsive"
      aria-controls="navbarResponsive"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      Menu
      <i class="fas fa-bars ms-1"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="${root}/attraction?action=mvsearch#search-place"
            >Search Place</a
          >
        </li>

        <c:if test="${empty userinfo}">
          <li class="nav-item">
            <a class="nav-link" href="${root}/member/login">login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${root}/member/sign_up.jsp#signup-section">Sign Up</a>
          </li>
        </c:if>
        <c:if test="${not empty userinfo}">
          <li class="nav-item">
            <a class="nav-link" href="${root}/myattraction?action=list">My Travel</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${root}/article?action=list#article-list-section"
              >Community</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${root}/member?action=mypage#mypage-section">My Page</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${root}/member?action=logout">logout</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
