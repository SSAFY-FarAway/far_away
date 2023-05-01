<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib
        prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">


<jsp:include page="./frament/head.jsp"/>
<body id="page-top">
<jsp:include page="./frament/nav.jsp"/>
<!-- Masthead-->
<header class="masthead">
    <div class="container">

        <div class="masthead-subheading">Wherever You Go</div>
        <div class="masthead-heading text-uppercase">FAR AWAY</div>
        <a
                class="btn btn-primary btn-xl text-uppercase"
                href="${root}/attraction?action=mvsearch#search-place"
        >Search Place</a
        >
    </div>
</header>

<!-- Services-->
<section class="page-section" id="services">
    <div class="container">
        <div class="text-center">
            <h2 class="section-heading text-uppercase">Customize Your Travel</h2>
            <h3 class="section-subheading text-muted">
                <p>You can make your own Plan By our Website And Share your Gorgeous Plan!</p>
            </h3>
        </div>
        <div class="row text-center">
            <div class="col-md-4">
            <span class="fa-stack fa-4x">
              <i class="fas fa-circle fa-stack-2x text-primary"></i>
              <i class="fas fa-user-friends fa-stack-1x fa-inverse"></i>
            </span>
                <h4 class="my-3">Travel With Your Friends</h4>
                <p class="text-muted">친구와 떠나는 신나는 여행에 어떤 경로를 이용할까요?</p>
            </div>
            <div class="col-md-4">
            <span class="fa-stack fa-4x">
              <i class="fas fa-circle fa-stack-2x text-primary"></i>
              <i class="fas fa-bus fa-stack-1x fa-inverse"></i>
            </span>
                <h4 class="my-3">Where To Go??</h4>
                <p class="text-muted">어디로 여행을 갈 지 추천을 받고 싶어요!</p>
            </div>
            <div class="col-md-4">
            <span class="fa-stack fa-4x">
              <i class="fas fa-circle fa-stack-2x text-primary"></i>
              <i class="far fa-tired fa-stack-1x fa-inverse"></i>
            </span>

                <h4 class="my-3">You get Tired?</h4>
                <p class="text-muted">피곤에 찌든 자여 여행을 떠나라~</p>
            </div>
        </div>
    </div>
</section>

<!-- Footer-->
<footer class="footer py-4">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 text-lg-start">Copyright &copy; Your Website 2022</div>
            <div class="col-lg-4 my-3 my-lg-0">
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"
                ><i class="fab fa-twitter"></i
                ></a>
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook"
                ><i class="fab fa-facebook-f"></i
                ></a>
                <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn"
                ><i class="fab fa-linkedin-in"></i
                ></a>
            </div>
            <div class="col-lg-4 text-lg-end">
                <a class="link-dark text-decoration-none me-3" href="#!">Privacy Policy</a>
                <a class="link-dark text-decoration-none" href="#!">Terms of Use</a>
            </div>
        </div>
    </div>
</footer>
<!-- Portfolio Modals-->
<!-- Portfolio item 1 modal popup-->
<div
        class="portfolio-modal modal fade"
        id="portfolioModal1"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">
                <img src="${root}/resources/static/assets/img/close-icon.svg" alt="Close modal"/>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <!-- Project details-->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img
                                    class="img-fluid d-block mx-auto"
                                    src="resources/static/assets/img/portfolio/1.jpg"
                                    alt="..."
                            />
                            <p>
                                Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos
                                deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores
                                repudiandae, nostrum, reiciendis facere nemo!
                            </p>
                            <ul class="list-inline">
                                <li>
                                    <strong>Client:</strong>
                                    Threads
                                </li>
                                <li>
                                    <strong>Category:</strong>
                                    Illustration
                                </li>
                            </ul>
                            <button
                                    class="btn btn-primary btn-xl text-uppercase"
                                    data-bs-dismiss="modal"
                                    type="button"
                            >
                                <i class="fas fa-xmark me-1"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Portfolio item 2 modal popup-->
<div
        class="portfolio-modal modal fade"
        id="portfolioModal2"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">
                <img src="resources/static/assets/img/close-icon.svg" alt="Close modal"/>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <!-- Project details-->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img
                                    class="img-fluid d-block mx-auto"
                                    src="resources/static/assets/img/portfolio/2.jpg"
                                    alt="..."
                            />
                            <p>
                                Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos
                                deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores
                                repudiandae, nostrum, reiciendis facere nemo!
                            </p>
                            <ul class="list-inline">
                                <li>
                                    <strong>Client:</strong>
                                    Explore
                                </li>
                                <li>
                                    <strong>Category:</strong>
                                    Graphic Design
                                </li>
                            </ul>
                            <button
                                    class="btn btn-primary btn-xl text-uppercase"
                                    data-bs-dismiss="modal"
                                    type="button"
                            >
                                <i class="fas fa-xmark me-1"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Portfolio item 3 modal popup-->
<div
        class="portfolio-modal modal fade"
        id="portfolioModal3"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">
                <img src="resources/static/assets/img/close-icon.svg" alt="Close modal"/>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <!-- Project details-->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img
                                    class="img-fluid d-block mx-auto"
                                    src="resources/static/assets/img/portfolio/3.jpg"
                                    alt="..."
                            />
                            <p>
                                Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos
                                deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores
                                repudiandae, nostrum, reiciendis facere nemo!
                            </p>
                            <ul class="list-inline">
                                <li>
                                    <strong>Client:</strong>
                                    Finish
                                </li>
                                <li>
                                    <strong>Category:</strong>
                                    Identity
                                </li>
                            </ul>
                            <button
                                    class="btn btn-primary btn-xl text-uppercase"
                                    data-bs-dismiss="modal"
                                    type="button"
                            >
                                <i class="fas fa-xmark me-1"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Portfolio item 4 modal popup-->
<div
        class="portfolio-modal modal fade"
        id="portfolioModal4"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">
                <img src="resources/static/assets/img/close-icon.svg" alt="Close modal"/>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <!-- Project details-->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img
                                    class="img-fluid d-block mx-auto"
                                    src="resources/static/assets/img/portfolio/4.jpg"
                                    alt="..."
                            />
                            <p>
                                Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos
                                deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores
                                repudiandae, nostrum, reiciendis facere nemo!
                            </p>
                            <ul class="list-inline">
                                <li>
                                    <strong>Client:</strong>
                                    Lines
                                </li>
                                <li>
                                    <strong>Category:</strong>
                                    Branding
                                </li>
                            </ul>
                            <button
                                    class="btn btn-primary btn-xl text-uppercase"
                                    data-bs-dismiss="modal"
                                    type="button"
                            >
                                <i class="fas fa-xmark me-1"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Portfolio item 5 modal popup-->
<div
        class="portfolio-modal modal fade"
        id="portfolioModal5"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">
                <img src="resources/static/assets/img/close-icon.svg" alt="Close modal"/>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <!-- Project details-->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img
                                    class="img-fluid d-block mx-auto"
                                    src="resources/static/assets/img/portfolio/5.jpg"
                                    alt="..."
                            />
                            <p>
                                Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos
                                deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores
                                repudiandae, nostrum, reiciendis facere nemo!
                            </p>
                            <ul class="list-inline">
                                <li>
                                    <strong>Client:</strong>
                                    Southwest
                                </li>
                                <li>
                                    <strong>Category:</strong>
                                    Website Design
                                </li>
                            </ul>
                            <button
                                    class="btn btn-primary btn-xl text-uppercase"
                                    data-bs-dismiss="modal"
                                    type="button"
                            >
                                <i class="fas fa-xmark me-1"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Portfolio item 6 modal popup-->
<div
        class="portfolio-modal modal fade"
        id="portfolioModal6"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
>
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="close-modal" data-bs-dismiss="modal">
                <img src="resources/static/assets/img/close-icon.svg" alt="Close modal"/>
            </div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="modal-body">
                            <!-- Project details-->
                            <h2 class="text-uppercase">Project Name</h2>
                            <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                            <img
                                    class="img-fluid d-block mx-auto"
                                    src="resources/static/assets/img/portfolio/6.jpg"
                                    alt="..."
                            />
                            <p>
                                Use this area to describe your project. Lorem ipsum dolor sit amet, consectetur
                                adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos
                                deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores
                                repudiandae, nostrum, reiciendis facere nemo!
                            </p>
                            <ul class="list-inline">
                                <li>
                                    <strong>Client:</strong>
                                    Window
                                </li>
                                <li>
                                    <strong>Category:</strong>
                                    Photography
                                </li>
                            </ul>
                            <button
                                    class="btn btn-primary btn-xl text-uppercase"
                                    data-bs-dismiss="modal"
                                    type="button"
                            >
                                <i class="fas fa-xmark me-1"></i>
                                Close Project
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<!-- Core theme JS-->
<script src="resources/static/assets/js/script.js"></script>
</body>
</html>