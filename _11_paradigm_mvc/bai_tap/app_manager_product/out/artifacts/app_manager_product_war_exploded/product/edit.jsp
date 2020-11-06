<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/5/2020
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edirt Product</title>
</head>
<body>
<form>
    <input type="text" value="<c:out value="${product.id}"/>">
    <label>Name: </label>
    <input type="text" value="<c:out value="${product.name}"/>">
    <label>Price: </label>
    <input type="text" value="<c:out value="${product.price}"/>">
    <label>Description: </label>
    <input type="text" value="<c:out value="${product.description}"/>">
    <label>Producer: </label>
    <input type="text" value="<c:out value="${product.producer}"/>">
</form>
</body>
</html>
