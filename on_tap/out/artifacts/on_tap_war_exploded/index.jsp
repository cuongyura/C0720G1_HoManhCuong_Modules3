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
  <a href="/student?action=add">create</a>
  <a href="/student">Home</a>
  <form method="get" action="/student">
    <div style="text-align: right">
      <input type="hidden" name="action" value="search">
      <input type="text" name="name">
      <button type="submit">SEARCH</button>
    </div>
  </form>

  <table class="table table-dark">
    <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Gender</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">Actios</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${getAll}" var="student">
      <tr>
        <td scope="row" aria-readonly="true">${student.getId()}</td>
        <td>${student.getName()}</td>
        <td>${student.getGender()}</td>
        <td>${student.getPhoneNumber()}</td>
        <td><a href="/student?action=edit&studentId=${student.id}">edit</a>
          <button data-toggle="modal" data-target="#modelId" onclick="onDelete(${student.id});">Delete</button>

        </td>
      </tr>

    </c:forEach>
    </tbody>
  </table>


  <!-- Button trigger modal -->
  <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#modelId">
    Launch
  </button>

  <!-- Modal -->
  <div class="modal fade" id="modelId" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Modal title</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <form action="/student">
          <input type="hidden" name="action" value="delete">
          <input type="hidden"  name="studentId" value="" id="studentId">
        <div class="modal-body">
         bạn có muốn xóa hay là không?
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">OK</button>
        </div>
        </form>
      </div>
    </div>
  </div>



  <script>
      function onDelete(id) {
         console.log(id);
         document.getElementById("studentId").value = id;
      }
  </script>
  </body>

</html>
