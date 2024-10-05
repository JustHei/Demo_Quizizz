<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <title>Account Statistics</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <jsp:include page="header.jsp" />

    <div class="container">
        <h2>Account Statistics</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.username}</td>
                        <td>${user.roleName}</td>
                        <td>
                            <form action="statistics" method="post" onsubmit="return confirm('Are you sure you want to delete this account?');">
                                <input type="hidden" name="userId" value="${user.userId}" />
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="footer.jsp" />
</body>

</html>
