<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/10/2020
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<a href="/customers?action=create" class="btn btn-success">Create Customer</a>
<a href="/customers">Home</a>
<form method="post" action="/customers">
    <div style="text-align: right">
        <input type="text" name="name">
        <button type="submit" name="action" value="search">SEARCH</button>

    </div>
</form>

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Date Of Birth</th>
        <th scope="col">Gender</th>
        <th scope="col">ID Card</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Customer Type</th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td><c:out value="${customer.idCustomer}"/></td>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.dateOfBirth}"/></td>
            <td><c:out value="${customer.gender}"/></td>
            <td><c:out value="${customer.customerIdCard}"/></td>
            <td><c:out value="${customer.customerPhoneNumb}"/></td>
            <td><c:out value="${customer.customerEmail}"/></td>
            <td><c:out value="${customer.customerAddress}"/></td>
            <td><c:out value="${customer.typeCustomer}"/></td>
            <td>
                <a href="/customers?action=edit&idCustomer=${customer.idCustomer}" class="btn btn-success">Edit</a>
                <a href="/customers?action=delete&idCustomer=${customer.idCustomer}" class="btn btn-warning">Delete</a>
            </td>

    </c:forEach>
    </tbody>
</table>
</body>

</html>
