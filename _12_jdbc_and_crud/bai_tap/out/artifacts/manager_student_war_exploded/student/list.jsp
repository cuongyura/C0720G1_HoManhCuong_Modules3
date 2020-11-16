<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/9/2020
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student - List</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Students List: </h1>
<p>
    <a href="/students?action=create" class="btn btn-success">Create new Student</a>
    <input type="text" style="margin-left: 550px; width: 400px; height: 36px; border-radius: 5px 5px 5px 5px;">
    <input
            type="submit" value="Search"  style="margin-left: 3px; height: 36px; width: 90px;border-radius: 5px 5px 5px 5px; background: blue;">
</p>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">DayOfBirth</th>
        <th scope="col">Address</th>
        <th scope="col">Email</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.dayOfBirth}"/></td>
            <td><c:out value="${student.address}"/></td>
            <td><c:out value="${student.email}"/></td>
            <td>
                <a href="/students?action=edit&id=${student.getId()}" class="btn btn-warning">edit</a>
                 <a href="/students?action=delete&id=${student.getId()}" class="btn btn-danger">delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>

</html>
