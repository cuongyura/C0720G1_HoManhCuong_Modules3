<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/12/2020
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<form method="post" action="/student">
    <div class="modal-body">
        <input type="hidden" name="action" value="edit" >
        <label>id</label>
        <input type="text" class="form-control" name="id" value="${student.id}" readonly>
        <label>gender</label>
        <label>Name</label>
        <input type="text" class="form-control" name="name" value="${student.name}">
        <label>gender</label>
        <input type="text" class="form-control" name="gender" value="${student.gender}">
        <label>phone</label>
        <input type="text" class="form-control" name="phone" value="${student.phoneNumber}">

        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save</button>
    </div>
</form>
</body>
</html>
