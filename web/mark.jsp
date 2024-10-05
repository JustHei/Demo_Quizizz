<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QuizMaster</title>
        <jsp:include page="header.jsp" />
        <title>Create Quiz</title>
        <style>
            /* Định dạng toàn bộ trang */
            body {
                overflow-x: hidden;
                background-color: #f0f0f0;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            /* Container */
            .container {
                max-width: 1000px;
                margin: 0 auto;
                padding: 20px;
                background-color: #FFFFFF;
                border: 2px solid #af94fc;
            }

            /* Style cho điểm và nút OK */
            /* Style cho chữ "Your mark" */
            /* Style cho chữ "Your mark" */
            .mark-text {
                font-size: 36px;
                color: green;
                text-align: center;
                margin: 0;
                padding: 20px 0 10px; /* Thay đổi khoảng cách giữa chữ "Your mark" và "Ok" */
            }

            /* Style cho nút "Ok" */
            .ok-button {
                display: inline-block;
                padding: 10px 20px;
                margin-left: 450px;
                background-color: green;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                font-size: 18px;
                text-align: center;
            }


            .ok-button:hover {
                background-color: red; /* Màu nền khi di chuột vào nút */
            }

            .header {
                background-color: #FFFFFF;
                border-bottom: 2px solid #af94fc;
                height: 4rem;
                display: flex;
                align-items: center;
                justify-content: space-between;
            }

            .logo {
                width: 250px; /* Kích thước logo */
                height: auto; /* Đảm bảo tỷ lệ khung hình được giữ nguyên */
                clip-path: inset(0 0 40% 0); /* Cắt phần dưới của logo */
            </style>
        </head>

        <body>
            <div class="header">
                <div class="header-logo">
                    <a href="#">
                        <img src="https://i.pinimg.com/564x/70/38/ea/7038ea85ace998bbfa317527b3a97d6e.jpg" alt="Your Logo" class="logo">
                    </a>
                </div>
            </div>

            <div class="container">
                <p class="mark-text">Your mark : ${mark} %</p>
                <a href="home" class="ok-button">Ok</a>
        </body>

    </html>
