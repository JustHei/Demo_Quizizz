<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
        <link rel="stylesheet" href="assets/css/themify-icons.css" />
        <link href="assets/css/home.css" rel="stylesheet" type="text/css"/>
        <link
            rel="stylesheet"
            href="https://unicons.iconscout.com/release/v4.0.8/css/line.css"
            />
        <style>
            .custom-center {
                min-height: 100vh;
            }
            .img-fluid {
                height: auto;
                max-width: 100%;
            }
            html, body {
                height: 100%;
                margin: 0;
                display: flex;
                align-items: center;
                justify-content: center;
            }
            .indicator {
                height: 10px;
                display: flex;
                align-items: center;
                justify-content: space-between;
                margin: 10px 0;
                display: none;
            }
            .indicator span {
                width: 100%;
                height: 100%;
                background: lightgray;
                border-radius: 5px;
                position: relative;
            }
            .indicator span.medium {
                margin: 0 3px;
            }
            .indicator span::before {
                content: "";
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                border-radius: 5px;
            }
            .indicator span.active.weak::before {
                background-color: #ff4757;
            }
            .indicator span.active.medium::before {
                background-color: orange;
            }
            .indicator span.active.strong::before {
                background-color: #23ad5c;
            }/*
            */
            .text {
                font-size: 14px;
                font-weight: 500;
                margin-bottom: -10px;
                display: none;
            }
            .text.weak {
                color: #ff4757;
            }
            .text.medium {
                color: orange;
            }
            .text.strong {
                color: #23ad5c;
            }
            .showBtn {
                position: absolute;
                right: 15px;
                top: 50%;
                transform: translateY(-50%);
                cursor: pointer;
                font-size: 15px;
                font-weight: 500;
                display: block;
            }
            <!--
            .form-floating {
                position: relative;
            }
            .form-floating .showBtn {
                right: 10px;
            }
        </style>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <section class=" p-5 p-md-3 p-xl-3">
            <div class="container">
                <div class="mb-3">
                    <a class="btn btn-secondary" href="myProfile.jsp">Back</a>
                </div>
                <div class="row justify-content-center">
                    <div class="col-12 col-xxl-11">
                        <div class="card border-light-subtle shadow-sm">
                            <div class="row g-0">
                                <div class="col-12 col-md-6">
                                    <img src="https://i.pinimg.com/564x/10/17/2c/10172cfcfddf6787f93a156f0be3a834.jpg" alt="Image" style="max-width: 80%; margin-right: 50px;">
                                </div>
                                <div class="col-12 col-md-6 d-flex align-items-center justify-content-center">
                                    <div class="col-12 col-lg-11 col-xl-10">
                                        <div class="card-body p-3 p-md-4 p-xl-5">
                                            <div class="row">
                                                <div class="col-12">
                                                    <div class="mb-5">
                                                        <h2 class="h4 text-center">Change Password</h2>
                                                        <h3 class="fs-6 fw-normal text-secondary text-center m-0">
                                                            Please enter a new password. 
                                                            Ensure that your new password is different from the previous one for better security.</h3>
                                                    </div>
                                                </div>
                                            </div>
                                            <form action="changepassword" method="POST">
                                                <div class="row gy-3 overflow-hidden">
                                                    <div class="col-12">
                                                        <div class="form-floating mb-3">
                                                            <input type="password" class="form-control" name="oldPassword" id="oldPassword" placeholder="Old Password" required> 
                                                            <label for="oldPassword" class="form-label">Old Password</label>
                                                            <input type="hidden" name="email" value="${sessionScope.account.email}">
                                                        </div>
                                                    </div>
                                                    <div class="col-12">
                                                        <div class="form-floating mb-3 position-relative">
                                                            <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="New Password" required onkeyup="trigger()">
                                                            <label for="newPassword" class="form-label">New Password</label>
                                                            <span class="showBtn" onclick="togglePassword('newPassword')"><ion-icon id="eyeIconNew" name="eye-off-outline"></ion-icon></span>
                                                        </div>
                                                    </div>
                                                    <div class="indicator">
                                                        <span class="weak"></span>
                                                        <span class="medium"></span>
                                                        <span class="strong"></span>
                                                    </div>
                                                    <div class="text" style="padding-bottom: 11px;"></div>
                                                    <div class="col-12">
                                                        <div class="form-floating mb-3">
                                                            <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required>
                                                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                                                            <span class="showBtn" onclick="togglePassword('confirmPassword')"><ion-icon id="eyeIconConfirm" name="eye-off-outline"></ion-icon></span>                               
                                                        </div>
                                                        <c:if test="${not empty errorMessage}">
                                                            <p style="color:red" class="text-center mt-3">${errorMessage}</p>
                                                        </c:if>
                                                    </div>
                                                </div>

                                                <div class="col-12">
                                                    <div class="d-grid">
                                                        <button class="btn btn-dark btn-lg" type="submit">Reset Password</button>
                                                    </div>
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
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
        <script>
                                                                const indicator = document.querySelector(".indicator");
                                                                const input = document.querySelector("#newPassword");
                                                                const weak = document.querySelector(".weak");
                                                                const medium = document.querySelector(".medium");
                                                                const strong = document.querySelector(".strong");
                                                                const text = document.querySelector(".text");
                                                                const eyeIconNew = document.getElementById('eyeIconNew');
                                                                const eyeIconConfirm = document.getElementById('eyeIconConfirm');
                                                                let regExpWeak = /[a-z]/;
                                                                let regExpUpper = /[A-Z]/;
                                                                let regExpMedium = /\d+/;
                                                                let regExpStrong = /.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/;

                                                                function trigger() {
                                                                    let no = 0;
                                                                    if (input.value !== "") {
                                                                        indicator.style.display = "flex";

                                                                        if (input.value.length <= 3 && (input.value.match(regExpWeak) || input.value.match(regExpMedium) || input.value.match(regExpStrong)))
                                                                            no = 1;
                                                                        if (input.value.length >= 6 && ((input.value.match(regExpWeak) && input.value.match(regExpMedium)) || (input.value.match(regExpMedium) && input.value.match(regExpStrong)) || (input.value.match(regExpWeak) && input.value.match(regExpStrong))))
                                                                            no = 2;
                                                                        if (input.value.length >= 6 && input.value.match(regExpWeak) && input.value.match(regExpMedium) && input.value.match(regExpStrong) && input.value.match(regExpUpper) || (input.value.length >= 6 && input.value.match(regExpMedium) && input.value.match(regExpStrong) && input.value.match(regExpUpper)))
                                                                            no = 3;

                                                                        if (no === 1) {
                                                                            weak.classList.add("active");
                                                                            medium.classList.remove("active");
                                                                            strong.classList.remove("active");
                                                                            text.style.display = "block";
                                                                            text.textContent = "Your password is too weak";
                                                                            text.classList.add("weak");
                                                                            text.classList.remove("medium", "strong");
                                                                        }
                                                                        if (no === 2) {
                                                                            weak.classList.add("active");
                                                                            medium.classList.add("active");
                                                                            strong.classList.remove("active");
                                                                            text.style.display = "block";
                                                                            text.textContent = "Your password is medium";
                                                                            text.classList.add("medium");
                                                                            text.classList.remove("weak", "strong");
                                                                        }
                                                                        if (no === 3) {
                                                                            weak.classList.add("active");
                                                                            medium.classList.add("active");
                                                                            strong.classList.add("active");
                                                                            text.style.display = "block";
                                                                            text.textContent = "Your password is strong";
                                                                            text.classList.add("strong");
                                                                            text.classList.remove("weak", "medium");
                                                                        }
                                                                    } else {
                                                                        indicator.style.display = "none";
                                                                        text.style.display = "none";
                                                                    }
                                                                }

                                                                function togglePassword(id) {
                                                                    const input = document.getElementById(id);
                                                                    const eyeIcon = id === 'newPassword' ? eyeIconNew : eyeIconConfirm;
                                                                    if (input.type === "password") {
                                                                        input.type = "text";
                                                                        eyeIcon.setAttribute("name", "eye-outline");
                                                                    } else {
                                                                        input.type = "password";
                                                                        eyeIcon.setAttribute("name", "eye-off-outline");
                                                                    }
                                                                }
        </script>
        <%@include file="footer.jsp" %>

        <script src="assets/js/vendor/modernizr-3.5.0.min.js"></script>
        <script src="assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/scrollIt.js"></script>
        <script src="assets/js/jquery.slicknav.min.js"></script>
        <script src="assets/js/jquery.ajaxchimp.min.js" type="text/javascript"></script>
        <script src="assets/js/isotope.pkgd.min.js" type="text/javascript"></script>
        <script src="assets/js/main.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>