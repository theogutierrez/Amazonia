<%-- 
    Document   : index
    Created on : 19 nov. 2019, 13:54:33
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
    </head>
    <body>      
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-header">
              <a class="navbar-brand" href="#"><img src ="images/amazon_logo.jpg" alt= width="80" height="50"></a>
            </div>
            <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="nav-link" href="#">Active</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
              </li>
            </ul>
            <ul class="navbar-nav navbar-right">
              <li class="nav-item">
                  <a class="nav-link" href="#">Panier</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="#">Connexion</a>
              </li>
            </ul>
        </nav>    
        <button class="btn btn-primary">Acheter</button>
    </body>
</html>
