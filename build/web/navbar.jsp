<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>QuizMaster</title>
        <style>
            /* Định dạng chữ gạch chân màu xanh */
            .underline-green {
                color: green;
            }
            /* Định dạng cách chữ "login" */
            .login-text {
                margin-left: 10px; /* Khoảng cách giữa chữ và nút */
            }
            /* Phần header */
            .header {
                background-color: #FFFFFF;
                height: 4rem;
                padding: 0 20px; /* Khoảng cách từ lề trái và lề phải */
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid #ccc; /* Đường viền dưới */
            }
            .logo {
                width: 250px; /* Kích thước logo */
                height: auto; /* Đảm bảo tỷ lệ khung hình được giữ nguyên */
                clip-path: inset(0 0 40% 0); /* Cắt phần dưới của logo */
            }
            .error-message {
                color: red;
                margin-left: 10px; /* Khoảng cách giữa chữ và logo */
            }
            /* Phần nút đăng nhập và chào mừng */
            .login-button-container {
                display: flex;
                align-items: center;
            }
            .welcome-message {
                margin-right: 10px; /* Khoảng cách giữa chữ và nút */
            }
        </style>
    </head>
    <body>
        <div class="header">
            <!-- Logo -->
            <div>
                <a href="#">
                    <img src="https://i.pinimg.com/564x/70/38/ea/7038ea85ace998bbfa317527b3a97d6e.jpg" alt="Logo" class="logo">
                </a>
            </div>
            <div class="login-button-container">
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <a href="login.jsp" class="btn btn-success login-text">Log in</a>
                    </c:when>
                    <c:otherwise>
                        <span class="welcome-message">Welcome 
                            <a href="myProfile.jsp" class="underline-green">${sessionScope.user.username}</a>
                        </span>
                        <a href="logout" class="btn btn-success login-text">Log out</a>
                    </c:otherwise>

                </c:choose>
            </div>
        </div>
    </body>
</html>
