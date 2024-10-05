<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<!DOCTYPE html>
<html>

    <head>
        <title>QuizMaster</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <jsp:include page="header.jsp" />
        <style>
            body {
                background-color: #f0f0f0;
            }

            header {
                background-color: #333;
                color: #fff;
                padding: 20px;
            }

            /* CSS cho bảng thống kê */
            .quiz-statistics-table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
                background-color: #fff;
                border: 2px solid #af94fc;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .quiz-statistics-table th, .quiz-statistics-table td {
                border: 1px solid #af94fc;
                padding: 12px;
                text-align: left;
            }

            .quiz-statistics-table th {
                background-color: #af94fc;
                color: #fff;
            }

            .quiz-statistics-table tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            .quiz-statistics-table tr:nth-child(odd) {
                background-color: #fff;
            }

            /* CSS cho tiêu đề */
            h2 {
                font-size: 24px;
                margin-bottom: 20px;
                color: #333;
            }

            /* CSS cho các phần khác của trang */
            /* Bổ sung thêm CSS tùy chỉnh dựa trên thiết kế của bạn */

        </style>
    </head>

    <body style="overflow-x: hidden;">
        <%@include file="navbar.jsp" %>

        <jsp:include page="sidebar.jsp" />
        <div class="p-3" style="margin-left: 250px;">
            <main>
                <h2>Quiz Statistics</h2>
                <table class="quiz-statistics-table">
                    <thead>
                        <tr>
                            <th>Quiz Name</th>
                            <th>Number of Participants</th>
                            <th>Average Mark</th>
                            <th>Max Mark</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="quizStat">
                            <tr>
                                <td>${quizStat.quizName}</td>
                                <td>${quizStat.numParticipants}</td>
                                <td>${quizStat.averageMark}</td>
                                <td>${quizStat.maxMark}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </main>

        </div>
    </div>


    <jsp:include page="footer.jsp" />
</body>

</html>