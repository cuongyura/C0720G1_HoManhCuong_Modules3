<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/12/2020
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>List Employees</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div style="text-align: center; margin-bottom: 10px">
    <h2>List Employees</h2>
    <a href="/employee/create.jsp" class="btn btn-success">Add new employee</a>
    <form action="/employee" method="get">
        <input type="text" placeholder="Input name" name="name" class="form-control" style="width: 150px; float: right; margin: 0 150px 0 10px">
        <button class="btn btn-primary" type="submit" style="float: right" name="action" value="search">
            Search
            <span class="glyphicon glyphicon-search"></span>
        </button>
    </form>
</div>
<table border="1" align="center" class="table table-hover" style="text-align: center">
    <thead class="thead-dark">
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Date Of Birth</th>
        <th scope="col">ID Card</th>
        <th scope="col">Phone Number</th>
        <th scope="col">Salary</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Position</th>
        <th scope="col">Education</th>
        <th scope="col">Division</th>
        <th scope="col">User Name</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody class="thead-dark">
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td><c:out value="${employee.employee_id}"/></td>
            <td><c:out value="${employee.employeeName}"/></td>
            <td><c:out value="${employee.dateOfBirth}"/></td>
            <td><c:out value="${employee.idCard}"/></td>
            <td><c:out value="${employee.employeePhoneNumb}"/></td>
            <td><c:out value="${employee.salary}"/></td>
            <td><c:out value="${employee.employeeEmail}"/></td>
            <td><c:out value="${employee.employeeAddress}"/></td>
            <td><c:out value="${employee.position_id}"/></td>
            <td><c:out value="${employee.education_id}"/></td>
            <td><c:out value="${employee.division_id}"/></td>
            <td><c:out value="${employee.userName}"/></td>
            <td>
                    <%--                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#modalEdit"--%>
                    <%--                        onclick="onEdit('${student.id}','${student.name}','${student.birthday}','${student.address}')">Edit</button>--%>
                    <%--                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#modalDelete"--%>
                    <%--                        onclick="onDel(${student.id})">Delete</button>--%>

                <a href="/employee?action=edit&id=${employee.employee_id}" class="btn btn-secondary">Edit</a>
                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#modalDelete" onclick="onDel(${employee.employee_id})">Delete</button>
            </td>
        </tr>
    </c:forEach>
    <!-- Button trigger modal -->

    <!-- Modal -->
    <div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirm delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form method="get">
                    <input type="hidden" name="id" id="modalIdDel">
                    <div class="modal-body">
                        Are you sure want to delete this employee?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary" name="action" value="delete">Yes</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
    </tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script>
    function onDel(employee_id) {
        document.getElementById("modalIdDel").value = employee_id;
    }
</script>
</body>
</html>
