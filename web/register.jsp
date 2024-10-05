<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QuizMaster</title>
        <jsp:include page="header.jsp" />
    </head>

    <body
        style="background: url('https://png.pngtree.com/background/20210712/original/pngtree-purple-hand-drawn-learning-tools-book-education-background-picture-image_1183719.jpg') 
        no-repeat center center fixed; background-size: cover; overflow-y: hidden;">
        <div class="d-flex flex-column justify-content-center align-items-center vh-100 mt-5">
            <div id="logDiv" class="alert alert-danger" style="display: none; width: 23rem;">
                <div class="row">
                    <div class="col-10">
                        ${log}
                    </div>
                    <div class="col-2 text-end">
                        <button type="button" class="btn-close" aria-label="Close" onclick="closeErrorMessage()"></button>
                    </div>
                </div>
            </div>
            <div class="p-3 border rounded border-3"
                 style="background-color:#e9e6e6;width: 23rem; border-color: rgb(177, 109, 255) !important;">
                <c:if test="${sessionScope.userGoogleDTO == null}">
                    <form action="register" method="post">
                        <h2 class="text-center mb-3">Register Account</h2>
                        <p style="color: red">${mess}</p>
                        <hr>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="username" id="emailInput"
                                   placeholder="yourUsername">
                            <label for="emailInput" class="form-label">Username</label>
                        </div>
                        <div class="form-floating mb-1">
                            <input type="password" class="form-control" name="password" id="passwordInput"
                                   placeholder="password">
                            <label for="passwordInput" class="form-label">Password</label>
                        </div>
                        <div class="form-floating mb-1">
                            <input type="password" class="form-control" name="repassword" id="passwordInput"
                                   placeholder="repassword">
                            <label for="passwordInput" class="form-label">Confirm password</label>
                        </div>
                        <div>
                            <button class="btn btn-outline-primary w-100">Register</button>
                            <a href="login.jsp" class="btn btn-outline-primary w-100 mt-2">Back to Login</a>

                        </div>
                    </form>
                </c:if>
            </div>
        </div>
        <script>
            if ("${log}") {
                document.getElementById("logDiv").style.display = "block";
            }
            function closeErrorMessage() {
                logDiv.style.display = "none";
            }
        </script>
        <jsp:include page="footer.jsp" />
    </body>

</html>