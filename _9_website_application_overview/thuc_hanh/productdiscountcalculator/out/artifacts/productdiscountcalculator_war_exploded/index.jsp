<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/3/2020
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="/caculator">
    <label>Product Description:</label> <input type="text" name="productDescription"></br></br>
  <label>List Price:</label> <input type="text" name="listPrice" style="margin-left: 65px;"></br></br>
  <label>Discount Percent:</label> <input type="text" name="discountPercent" style="margin-left: 18px;"></br></br>
  <input type="submit" value="Calculate Discount" name="submit">
   </form>

  </body>
</html>
