 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.*" %>

<div class="d-flex flex-column text-white bg-dark position-fixed" style="width: 200px; height: 100vh;">
    <ul class="list-unstyled">
        <li class="mb-1">
            <a href='home' class="btn btn-dark w-100 " style="color: white;">
                <div class="row align-items-center">
                    <div class="col-2">
                        <i class="fa-solid fa-house"></i>
                    </div>
                    <div class="col-3">
                        <span class='text-start fs-5'>Home</span>
                    </div>
                </div>
            </a>
        </li>
        <li class="mb-1">
            <button class="btn btn-toggle btn-dark w-100" data-bs-toggle="collapse"
                    data-bs-target="#dashboard-collapse" style="color: white;">
                <div class="row align-items-center">
                    <div class="col-2">
                        <i class="fa-solid fa-book"></i>
                    </div>
                    <div class="col-3">
                        <span class='text-start fs-5'>QuizTopic</span>
                    </div>

                </div>
            </button>
            <div class="collapse show" id="dashboard-collapse">
                <ul class="list-unstyled overflow-y-auto" style="color: white; max-height: 60vh;">
                    <c:forEach var="t" items="${listT}">
                        <li>
                            <a href="home?topicId=${t.topicId}"
                               class="btn btn-dark align-items-center w-100 ${t.topicId== param.classId ? 'active' : ''}"
                               style="font-size: medium; color: white; text-align: left;">
                                <div class="row align-items-center ms-1">
                                    <div class="col-2">
                                        <i class="fa-solid fa-graduation-cap"></i>
                                    </div>
                                    <div class="col-10">
                                        <span class='text-start'>${t.topicName}</span>
                                    </div>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </li>
        <li class="mb-1">
            <a href='statistics' class="btn btn-dark w-100 " style="color: white;">
                <div class="row align-items-center">
                    <div class="col-2">
                        <i class="fa-solid fa-house"></i>
                    </div>
                    <div class="col-3">
                        <span class='text-start fs-5'>Statistics</span>
                    </div>
                </div>
            </a>
        </li>
    </ul>
</div>