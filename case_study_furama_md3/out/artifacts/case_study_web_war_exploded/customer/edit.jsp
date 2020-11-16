<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/12/2020
  Time: 1:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Edit Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/customer">
    <div class="form-group">
        <label>ID:</label>
        <input type="text" class="form-control" readonly value="${customer.idCustomer}" name="customer_id">
    </div>
    <div class="form-group">
        <label>Name:</label>
        <input type="text" class="form-control" value="${customer.customerName}" name="customer_name">
    </div>
    <div class="form-group">
        <label>Date of birth:</label>
        <input type="text" class="form-control" value="${customer.dateOfBirth}" name="customer_birthday">
    </div>
    <div class="form-group">
        <label>Gender: </label>
        <input type="text" class="form-control" value="${customer.gender}" name="customer_gender">
    </div>
    <div class="form-group">
        <label>ID card:</label>
        <input type="text" class="form-control" value="${customer.customerIdCard}" name="customer_id_card">
    </div>
    <div class="form-group">
        <label>Phone number:</label>
        <input type="text" class="form-control" value="${customer.customerPhoneNumb}" name="customer_phone">
    </div>
    <div class="form-group">
        <label>Email:</label>
        <input type="text" class="form-control" value="${customer.customerEmail}" name="customer_email">
    </div>
    <div class="form-group">
        <label>Address:</label>
        <input type="text" class="form-control" value="${customer.customerAddress}" name="customer_address">
    </div>
    <div class="form-group">
        <label>Type customer:</label>
        <%--            <label>Customer Type</label>--%>
        <%--            <select class="form-control" name="customer_type_id">--%>
        <%--                <option value="1">Diamond</option>--%>
        <%--                <option value="2">Platinum</option>--%>
        <%--                <option value="3">Gold</option>--%>
        <%--                <option value="4">Silver</option>--%>
        <%--                <option value="5">Member</option>--%>
        <%--            </select>--%>
        <input type="text" class="form-control" value="${customer.typeCustomer}"  name="customer_type_id">
    </div>
    <button type="submit" class="btn btn-primary" name="action" value="edit">Edit</button>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
