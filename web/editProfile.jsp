<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Edit Profile</title>
    <style>
        body {
            margin-top: 20px;
            color: #1a202c;
            text-align: left;
            background-color: #e2e8f0;
        }
        .main-body {
            padding: 15px;
        }
        .card {
            box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
        }
        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 0 solid rgba(0,0,0,.125);
            border-radius: .25rem;
        }
        .card-body {
            flex: 1 1 auto;
            min-height: 1px;
            padding: 1rem;
        }
        .mb-3, .my-3 {
            margin-bottom: 1rem!important;
        }
        .bg-gray-300 {
            background-color: #e2e8f0;
        }
        .h-100 {
            height: 100%!important;
        }
        .shadow-none {
            box-shadow: none!important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="main-body">
        <div class="row gutters-sm">
            <div class="col-md-12">
                <div class="card mb-3">
                    <div class="card-body">
                        <!-- Hiển thị thông báo thành công hoặc lỗi -->
                        <c:if test="${not empty message}">
                            <div class="alert alert-success" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">
                                ${error}
                            </div>
                        </c:if>
                        
                        <form action="updateProfile" method="post">
                            <div class="row mb-3">
                                <label for="fullName" class="col-sm-3 col-form-label">Full Name</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="fullName" name="fullName" value="${user.fullName}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="email" class="col-sm-3 col-form-label">Email</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" id="email" name="email" value="${user.email}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="phone" class="col-sm-3 col-form-label">Phone</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label for="address" class="col-sm-3 col-form-label">Address</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="address" name="address" value="${user.address}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 text-end">
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                    <a href="profile.jsp" class="btn btn-secondary">Cancel</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Back Button at the bottom -->
    <div class="mb-3">
        <a class="btn btn-secondary" href="home">Back</a>
    </div>
</div>
</body>
</html>
