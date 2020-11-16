<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/9/2020
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit - Student</title>
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
<div class="row">
    <div class="col-sm-6">
<form class="form" action="/students?action=edit" method="post">
    <div class="form-group">
        <label for="exampleInputEmail1">Id:</label>
        <input type="text" class="form-control"  id="exampleInputEmail1" value="<c:out value="${student.id}"/>" name="id">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Name:</label>
        <input type="text" class="form-control" id="exampleInputEmail2" value="<c:out value="${student.name}"/>" name="name">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Birth Day:</label>
        <input type="text" class="form-control" id="exampleInputEmail3" value="<c:out value="${student.dayOfBirth}"/>" name="dayOfBirth">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Address:</label>
        <input type="text" class="form-control" id="exampleInputEmail4" value="<c:out value="${student.address}"/>" name="address">
    </div>

    <div class="form-group">
        <label for="exampleInputEmail1">Email:</label>
        <input type="text" class="form-control" id="exampleInputEmail5" value="<c:out value="${student.email}"/>" name="email">
    </div>


    <button type="submit" class="btn btn-primary">Edit</button>
</form>
</div>
</div>
</body>
</html>
