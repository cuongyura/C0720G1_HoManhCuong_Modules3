<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/12/2020
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/employee">
    <div class="form-group">
        <label>ID:</label>
        <input type="text" class="form-control" readonly value="${employee.employee_id}" name="id">
    </div>
    <div class="form-group">
        <label>Name:</label>
        <input type="text" class="form-control" value="${employee.employeeName}" name="name">
    </div>
    <div class="form-group">
        <label>Date of birth:</label>
        <input type="text" class="form-control" value="${employee.dateOfBirth}" name="dateOfBirth">
    </div>
    <div class="form-group">
        <label>ID card: </label>
        <input type="text" class="form-control" value="${employee.idCard}" name="idCard">
    </div>
    <div class="form-group">
        <label>Phone number:</label>
        <input type="text" class="form-control" value="${employee.employeePhoneNumb}" name="phoneNumb">
    </div>
    <div class="form-group">
        <label>Salary:</label>
        <input type="text" class="form-control" value="${employee.salary}" name="salary">
    </div>
    <div class="form-group">
        <label>Email:</label>
        <input type="text" class="form-control" value="${employee.employeeEmail}" name="email">
    </div>
    <div class="form-group">1
        <label>Address:</label>
        <input type="text" class="form-control" value="${employee.employeeAddress}" name="address">
    </div>
    <div class="form-group">
        <label>Position:</label>
        <input type="text" class="form-control" value="${employee.position_id}" name="position">
    </div>
    <div class="form-group">
        <label>Education:</label>
        <input type="text" class="form-control" value="${employee.education_id}" name="education">
    </div>
    <div class="form-group">
        <label>Division:</label>
        <input type="text" class="form-control" value="${employee.division_id}" name="division">
    </div>
    <div class="form-group">
        <label>User Name:</label>
        <input type="text" class="form-control" value="${employee.userName}" name="userName">
    </div>
    <button type="submit" class="btn btn-primary" name="action" value="edit">Edit</button>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
