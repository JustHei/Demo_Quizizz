<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>QuizMaster</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/sharp-solid.css">
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/sharp-regular.css">
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/sharp-light.css">
        <style>
            /* Định dạng toàn bộ trang */
            body {
                background-color: #f0f0f0;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            /* Header */
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

                /* Container */
                .container {
                    max-width: 1000px;
                    margin: 0 auto;
                    padding: 20px;
                    background-color: #FFFFFF;
                    border: 2px solid #af94fc;
                }

                /* Question group */
                .question-group {
                    margin-bottom: 20px;
                }

                .question-group label {
                    font-weight: bold;
                    font-size: 18px;
                    margin-bottom: 10px;
                }

                .question-group .question-content {
                    font-size: 16px;
                    margin-bottom: 10px;
                }

                .question-group input[type="radio"] {
                    margin-right: 10px;
                }

                /* Submit button */
                /*        .submit-button {
                            background-color: #af94fc;
                            color: white;
                            border: none;
                            padding: 10px 20px;
                            cursor: pointer;
                            font-size: 18px;
                            margin-top: 20px;
                        }*/
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
                <form action="doquiz" method="get">
                    <c:forEach items="${listQues}" var="q" varStatus="count">
                        <div class="question-group">
                            <input name="qs${count.index}Id" type="hidden" value="${q.questionId}"
                                   <label for="qs${count.index}">Question ${count.count}</label>
                            <p class="question-content">${q.questionContent}</p>
                            <input required="" type="radio" name="qs${count.index}key" value="true" id="qs${count.index}key-true"> True
                            <input required="" type="radio" name="qs${count.index}key" value="false" id="qs${count.index}key-false"> False
                        </div>
                        <br>
                    </c:forEach>
                    <input type="submit" value="Submit" class="btn btn-danger">
                </form>

            </div>



            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
            <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/js/bootstrap-select.min.js"></script>
        </body>
    </html>
