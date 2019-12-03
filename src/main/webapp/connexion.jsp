<%-- 
    Document   : connexion
    Created on : 3 déc. 2019, 13:41:24
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
    </head>
        <body>      
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand" href="index.jsp"><img src ="images/logo_amazonia.jpg" alt= width="120" height="75"></a>
            </div>
            <div class="mx-auto order-0">
                <form class="form-inline navbar-brand mx-auto" action="/action_page.php">
                  <input class="form-control input-group-btn" type="text" placeholder="Rechercher">
                  <button class="btn btn-success" type="submit">Rechercher</button>
                </form>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                      <a class="nav-link" href="#"><h4>Panier</h4></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="#"><h4>Connexion</h4></a>
                  </li>
                </ul>
            </div>
        </nav> 
            
            
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                    <a><h2>Connexion</h2></a>
            </ul>
        </nav>
            
        <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-3">
        <ul class="nav justify-content-center">
            <div class="mx-auto order-0">
                <form class="form-inline navbar-brand mx-auto" action="/action_page.php">
                  <text>Login :</text>
                </form>
            </div>
        </ul>
        <ul class="nav justify-content-center">
            <div class="mx-auto order-0 ">
                <form class="form-inline navbar-brand mx-auto" action="/action_page.php">
                  <text>Mot de passe :</text>
                </form>
            </div>
        </ul>
        </div>
        <div class="col-sm-3"><input class="form-control input-group-btn" type="text" placeholder="Login">
        <input class="form-control input-group-btn" type="text" placeholder="MDP"></div>
        </div> 
            
        
        
        <ul class="nav justify-content-center">
            <button class="btn btn-success" type="submit"><h4>Connexion</h4></button>
        </ul>
</html>
