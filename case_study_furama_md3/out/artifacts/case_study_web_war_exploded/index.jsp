<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/11/2020
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Welcom to Four Seasons Resort</title>
    <link rel="stylesheet" type="text/css" href="index.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
  </head>
  <body>
    <div class="container-fluid">
      <div class="header">
        <div class="logo">
          <img src="images/kisspng-four-seasons-hotels-and-resorts-four-seasons-hotel-5af85e1b18d3d0.4943647415262264591017.png">
        </div>
        <div class="header-right">
          <div class="dropdown show">
            <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="glyphicon glyphicon-search"></span>
              Account
            </a>

            <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
              <a class="dropdown-item" href="#">Sign in</a>
              <a class="dropdown-item" href="#">Log in</a>
              <a class="dropdown-item" href="#">Setting</a>
            </div>
          </div>
        </div>
      </div>
      <div class="navigation">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="#"></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/employee">Employee</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/customer">Customer</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/service">Service</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Contract</a>
              </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
              <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
          </div>
        </nav>
      </div>
      <div id="content" style="background-color: antiquewhite">
        <div class="row">
          <div class="col-lg-3">
            <div class="d-flex" id="wrapper">

              <!-- Sidebar -->
              <div class="bg-light border-right col-12" id="sidebar-wrapper">
                <div class="list-group list-group-flush">
                  <a href="#" class="list-group-item list-group-item-action bg-light">Dashboard</a>
                  <a href="#" class="list-group-item list-group-item-action bg-light">Shortcuts</a>
                  <a href="#" class="list-group-item list-group-item-action bg-light">Overview</a>
                  <a href="#" class="list-group-item list-group-item-action bg-light">Events</a>
                  <a href="#" class="list-group-item list-group-item-action bg-light">Profile</a>
                  <a href="#" class="list-group-item list-group-item-action bg-light">Status</a>
                </div>
              </div>
          </div>
        </div>
          <div class="col-lg-9">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <img class="d-block w-100" src="images/slide3.jpg" alt="First slide">
                </div>
                <div class="carousel-item">
                  <img class="d-block w-100" src="images/slide2.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                  <img class="d-block w-100" src="images/slide4.jpg" alt="Third slide">
                </div>
                <div class="carousel-item">
                  <img class="d-block w-100" src="images/slide1.jpg" alt="Four slide">
                </div>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
          </div>
      </div>
    </div>

  </body>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</html>
