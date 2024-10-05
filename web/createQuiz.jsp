<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>QuizMaster</title>
    <jsp:include page="header.jsp" />
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

        /* Question group */
        .question-group {
            margin-bottom: 20px;
            position: relative; /* Để biểu tượng x có thể được đặt tuyệt đối */
        }

        .question-group label {
            font-weight: bold;
            font-size: 18px;
            margin-bottom: 10px;
            display: block;
        }

        .question-group input[type="text"],
        .question-group input[type="radio"],
        .question-group select {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #af94fc;
            border-radius: 5px;
        }

        /* Submit button */
        /*input[type="submit"] {
            background-color: #af94fc;
            color: white;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 18px;
            margin-top: 20px;
            display: inline-block;
        }*/

        /* Back button */
        .back-button {
            width: 122.38px;
            height: 44px;
            background-color: #af94fc;
            text-align: center;
            line-height: 44px;
            text-decoration: none;
            color: white;
            display: inline-block;
            margin-top: 20px;
            border-radius: 5px;
        }

        .question-group label input[type="radio"] {
            margin-right: 5px;
        }

        .question-group label {
            display: inline-flex;
            align-items: center;
            margin-right: 20px; /* Điều chỉnh khoảng cách giữa nút radio và chữ True/False */
            font-size: 16px;
        }

        .header {
            background-color: #FFFFFF;
            border-bottom: 2px solid #af94fc;
            height: 4rem;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .header-logo {
            padding-left: 1rem;
        }

        .hint-text {
            font-size: 14px; /* Đặt kích thước chữ là 14px (hoặc thay đổi theo ý muốn của bạn) */
            color: #888; /* Màu nhạt (hoặc thay đổi mã màu theo ý muốn của bạn) */
        }

        .logo {
            width: 250px; /* Kích thước logo */
            height: auto; /* Đảm bảo tỷ lệ khung hình được giữ nguyên */
            clip-path: inset(0 0 40% 0); /* Cắt phần dưới của logo */
        }

        /* Biểu tượng xóa */
        .remove-question {
            position: absolute;
            top: 10px;
            right: 10px;
            font-size: 16px;
            color: #af94fc;
            cursor: pointer;
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

    <div class="col-6">
        <h id="mess" style="color: red">${mess}</h3>
    </div>

    <script>
        // Ẩn thông báo sau 2.5 giây
        setTimeout(function () {
            var messElement = document.getElementById('mess');
            messElement.style.display = 'none';
        }, 2500);
    </script>

    <div class="container">
        <form id="quizForm" action="createquiz" method="post">
            <div class="question-group">
                <label for="topic">Quiz Topic</label>
                <select name="topic">
                    <c:forEach items="${listTopic}" var="t">
                        <option value="${t.topicId}" ${param.topic == t.topicId ? 'selected' : ''}>${t.topicName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="question-group">
                <label for="quizname">Quiz Name</label>
                <input required="" type="text" name="quizname" id="quizname" value="${!empty param.quizname ? param.quizname : ''}">
            </div>

            <div class="question-group">
                <label style="margin-right: 0" for="enrollkey">Enroll Key</label>
                <span class="hint-text">(leave empty for public quiz)</span>
                <input type="text" name="enrollkey" id="enrollkey" value="${!empty param.enrollkey ? param.enrollkey : ''}">
            </div>

            <div id="questionsContainer">
                <!-- Existing Questions -->
                <div class="question-group">
                    <label for="qs1">Question 1</label>
                    <input required="" type="text" name="qs1" id="qs1" value="${!empty param.qs1 ? param.qs1 : ''}">
                    <label>
                        <input required="" type="radio" name="qs1key" value="true" id="qs1key-true" ${param.qs1key == 'true' ? 'checked' : ''}>
                        True
                    </label>
                    <label>
                        <input required="" type="radio" name="qs1key" value="false" id="qs1key-false" ${param.qs1key == 'false' ? 'checked' : ''}>
                        False
                    </label>
                </div>

                <div class="question-group">
                    <label for="qs2">Question 2</label>
                    <input required="" type="text" name="qs2" id="qs2" value="${!empty param.qs2 ? param.qs2 : ''}">
                    <label>
                        <input required="" type="radio" name="qs2key" value="true" id="qs2key-true" ${param.qs2key == 'true' ? 'checked' : ''}>
                        True
                    </label>
                    <label>
                        <input required="" type="radio" name="qs2key" value="false" id="qs2key-false" ${param.qs2key == 'false' ? 'checked' : ''}>
                        False
                    </label>
                </div>

                <div class="question-group">
                    <label for="qs3">Question 3</label>
                    <input required="" type="text" name="qs3" id="qs3" value="${!empty param.qs3 ? param.qs3 : ''}">
                    <label>
                        <input required="" type="radio" name="qs3key" value="true" id="qs3key-true" ${param.qs3key == 'true' ? 'checked' : ''}>
                        True
                    </label>
                    <label>
                        <input required="" type="radio" name="qs3key" value="false" id="qs3key-false" ${param.qs3key == 'false' ? 'checked' : ''}>
                        False
                    </label>
                </div>

                <div class="question-group">
                    <label for="qs4">Question 4</label>
                    <input required="" type="text" name="qs4" id="qs4" value="${!empty param.qs4 ? param.qs4 : ''}">
                    <label>
                        <input required="" type="radio" name="qs4key" value="true" id="qs4key-true" ${param.qs4key == 'true' ? 'checked' : ''}>
                        True
                    </label>
                    <label>
                        <input required="" type="radio" name="qs4key" value="false" id="qs4key-false" ${param.qs4key == 'false' ? 'checked' : ''}>
                        False
                    </label>
                </div>
            </div>

           <button class="btn btn-success" type="button" id="addQuestionBtn">Add Question</button>

                <a class="btn btn-primary" href="home">Back</a>
                <input class="btn btn-danger" type="submit" value="Create Quiz">
        </form>
    </div>

    <script>
        const addQuestionBtn = document.getElementById('addQuestionBtn');
        const questionsContainer = document.getElementById('questionsContainer');
        let questionCount = 4; // Initialize with existing question count

        addQuestionBtn.addEventListener('click', function() {
            questionCount++;

            // Tạo phần HTML mới cho câu hỏi
            const newQuestionHTML = `
                <div class="question-group">
                    <label for="qs${questionCount}">Question ${questionCount}</label>
                    <input required="" type="text" name="qs${questionCount}" id="qs${questionCount}" value="">
                    <label>
                        <input required="" type="radio" name="qs${questionCount}key" value="true" id="qs${questionCount}key-true">
                        True
                    </label>
                    <label>
                        <input required="" type="radio" name="qs${questionCount}key" value="false" id="qs${questionCount}key-false">
                        False
                    </label>
                    <span class="remove-question" onclick="removeQuestion(this)">&#10006;</span> <!-- Dấu X -->
                </div>
            `;

            questionsContainer.insertAdjacentHTML('beforeend', newQuestionHTML);
        });

        function removeQuestion(element) {
            element.parentElement.remove();
        }
    </script>
</body>
</html>

