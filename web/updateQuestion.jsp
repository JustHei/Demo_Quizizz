<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edit Questions</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta3/dist/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="https://site-assets.fontawesome.com/releases/v6.4.2/css/all.css">
        <style>
            body {
                background-color: #f0f0f0;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
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
                width: 250px;
                height: auto;
                clip-path: inset(0 0 40% 0);
            }

            .container {
                max-width: 1000px;
                margin: 0 auto;
                padding: 20px;
                background-color: #FFFFFF;
                border: 2px solid #af94fc;
            }

            .question-group {
                margin-bottom: 20px;
            }

            .question-group label {
                font-weight: bold;
                font-size: 18px;
                margin-bottom: 10px;
            }

            .question-group input[type="text"] {
                font-size: 16px;
                width: 100%;
            }

            .question-group .form-check-label {
                font-size: 16px;
            }

            .btn-primary {
                margin-top: 20px;
            }
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
            <h2>Edit Questions</h2>
            <form action="updateQuestion" method="post">
                <c:forEach items="${listQues}" var="q" varStatus="status">
                    <div class="question-group">
                        <label for="qs${status.count}">Question ${status.count}</label>
                        <input type="hidden" name="qs${status.count}id" value="${q.questionId}">
                        <input required type="text" name="qs${status.count}" id="qs${status.count}" value="${q.questionContent}">

                        <div>
                            <label>
                                <input required type="radio" name="qs${status.count}key" value="true" id="qs${status.count}key-true" ${q.questionKey ? 'checked' : ''}>
                                True
                            </label>
                            <label>
                                <input required type="radio" name="qs${status.count}key" value="false" id="qs${status.count}key-false" ${!q.questionKey ? 'checked' : ''}>
                                False
                            </label>
                        </div>
                    </div>
                    <br>
                </c:forEach>
                <!-- Hidden input để gửi số lượng câu hỏi -->
                <input type="hidden" name="questionCount" value="${listQues.size()}">
                <!-- Hiển thị thông báo nếu có -->
                <c:if test="${not empty param.message}">
                    <div style="color: green;">
                        ${param.message}
                    </div>
                </c:if>

                <button type="submit" class="btn btn-primary">Update</button>
                <a class="btn btn-secondary" href="javascript:history.back()">Back</a>
                <a class="btn btn-info" href="home">Home</a>
            </form>
        </div>
    </body>
</html>
