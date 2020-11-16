<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/10/2020
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create - Student</title>
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
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/studentss">Back to customer list</a>
</p>
<div class="row">
    <div class="col-sm-6">
        <form class="form" action="/students?action=edit" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">Id:</label>
                <input type="text" class="form-control" id="exampleInputEmail1" name="id">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail1">Name:</label>
                <input type="text" class="form-control" id="exampleInputEmail2" name="name">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail1">Birth Day:</label>
                <input type="text" class="form-control" id="exampleInputEmail3" name="dayOfBirth">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail1">Address:</label>
                <input type="text" class="form-control" id="exampleInputEmail4" name="address">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail1">Email:</label>
                <input type="text" class="form-control" id="exampleInputEmail5" name="email">
            </div>


            <button type="submit" class="btn btn-primary">Create Student</button>
        </form>
    </div>
</body>
</html>
