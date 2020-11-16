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
    <title>List Service</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div style="text-align: center; margin-bottom: 10px">
    <h2>List Service</h2>
    <a href="/service/create.jsp" class="btn btn-success">Add new Service</a>
</div>
<table border="1" align="center" class="table table-hover" style="text-align: center">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Service Area</th>
        <th scope="col">Service Cost</th>
        <th scope="col">Max People</th>
        <th scope="col">Standard Room</th>
        <th scope="col">Description</th>
        <th scope="col">Pool Area</th>
        <th scope="col">Number Of Floor</th>
        <th scope="col">Service Type</th>
        <th scope="col">Rent Type</th>
    </tr>
    </thead>
    <tbody class="thead-dark">
    <c:forEach var="service" items="${serviceList}">
        <tr>
            <td><c:out value="${service.serviceId}"/></td>
            <td><c:out value="${service.serviceName}"/></td>
            <td><c:out value="${service.serviceArea}"/></td>
            <td><c:out value="${service.serviceCost}"/></td>
            <td><c:out value="${service.serviceMaxPeople}"/></td>
            <td><c:out value="${service.standardRoom}"/></td>
            <td><c:out value="${service.description}"/></td>
            <td><c:out value="${service.poolArea}"/></td>
            <td><c:out value="${service.numbFloor}"/></td>
            <td><c:out value="${service.serviceType}"/></td>
            <td><c:out value="${service.rentType}"/></td>
        </tr>
    </c:forEach>
    <!-- Button trigger modal -->
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>
