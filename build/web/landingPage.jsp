<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QuizMaster</title>
        <jsp:include page="header.jsp"/>
    </head>

    <style>
        .center-content {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: flex-start;
            height: 100vh;
            margin-left: 10%;
        }
        .btn-primary {
            background-color: green;
        }
    </style>

    <body style="background: url('https://png.pngtree.com/background/20210712/original/pngtree-purple-hand-drawn-learning-tools-book-education-background-picture-image_1183719.jpg') 
          no-repeat center center fixed; background-size: cover; overflow-y: hidden;">
        <%@include file="navbar.jsp" %>

        <div class="center-content">
            <div style="display: flex; align-items: center;">
                <img src="https://i.pinimg.com/564x/10/17/2c/10172cfcfddf6787f93a156f0be3a834.jpg" alt="Image" style="max-width: 80%; margin-right: 50px;">
                <div>
                    <h2 class="text-center" id="title"></h2>
                    <h4 class="text-center" id="subtitle"></h4>
                    <p id="content">
                        Welcome to QuizMaster! A platform for interactive quizzes and learning.<br>
                        Explore a wide range of topics and challenge your knowledge.<br>
                        Start learning today!
                    </p>
                    <h5 class="text-center">
                        <a href="#" class="btn btn-primary" id="try-quiz" style="width: 10rem;">Start Quiz</a></h5>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

        <script>
            const title = document.getElementById("title");
            const subtitle = document.getElementById("subtitle");
            const content = document.getElementById("content");
            const tryQuizButton = document.getElementById("try-quiz");

            const titleText = "Quiz Master";
            const subtitleText = "Challenge Your Knowledge";

            function displayText(element, text, index) {
                if (index < text.length) {
                    element.innerHTML += text.charAt(index);
                    index++;
                    setTimeout(function () {
                        displayText(element, text, index);
                    }, 50);
                }
            }

            displayText(title, titleText, 0);
            setTimeout(function () {
                displayText(subtitle, subtitleText, 0);
            }, titleText.length * 50);

            tryQuizButton.addEventListener("click", function (event) {
                event.preventDefault();
                window.location.href = "login.jsp";
            });
        </script>
    </body>
</html>
