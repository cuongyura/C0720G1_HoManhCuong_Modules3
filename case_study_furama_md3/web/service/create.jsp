<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/12/2020
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/service?action=create">
    <div class="form-group">
        <label>ID:</label>
        <input type="text" class="form-control" placeholder="Input ID" name="id">
    </div>
    <div class="form-group">
        <label>Name:</label>
        <input type="text" class="form-control" placeholder="Input name" name="name">
    </div>
    <div class="form-group">
        <label>Service Area:</label>
        <input type="text" class="form-control" placeholder="Input area" name="serviceArea">
    </div>
    <div class="form-group">
        <label>Service Cost: </label>
        <input type="text" class="form-control" placeholder="Input cost" name="serviceCost">
    </div>
    <div class="form-group">
        <label>Max People:</label>
        <input type="text" class="form-control" placeholder="Input quantity" name="maxPeople">
    </div>
    <div class="form-group">
        <label>Standard Room:</label>
        <input type="text" class="form-control" placeholder="Input standard room" name="standardRoom">
    </div>
    <div class="form-group">
        <label>Description:</label>
        <input type="text" class="form-control" placeholder="Input description" name="description">
    </div>
    <div class="form-group">
        <label>Pool Area:</label>
        <input type="text" class="form-control" placeholder="Input pool are" name="poolArea">
    </div>
    <div class="form-group">
        <label>Number Of Floor</label>
        <input type="text" class="form-control" placeholder="Input number of floor" name="numbFloor">
    </div>
    <div class="form-group">
        <label>Service Type:</label>
        <input type="text" class="form-control" placeholder="Input service type" name="svType">
    </div>
    <div class="form-group">
        <label>Rent Type:</label>
        <input type="text" class="form-control" placeholder="Input rent type" name="rentType">
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
