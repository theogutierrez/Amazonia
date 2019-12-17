<%-- 
    Document   : index
    Created on : 19 nov. 2019, 13:54:33
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404</title>
        <link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/47131369cd.js" crossorigin="anonymous"></script>
    </head>
    <body>  
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
            </div>
        </nav> 
        <div class="col-lg-12">
            <h1 class="text-center">Hay... vous avez tout cassé <i class="far fa-dizzy" style="font-size:30px"></i></h1>
        </div>
        <div class="row">
            <div class ="col-lg-12 text-center text">
                <p>La page que vous avez recherché est introuvable</p>
                <p>Cliquez ici: <a href="<c:url value='/'/>">pour retourner sur la page d'accueil</a></p>
            </div>    
        </div>
        
        <footer class="page-footer font-small light">
            <div class="container text-center">
                <small>Copyright Amazonia</small>
            </div>
        </footer>
    </body>

</html>
