<%-- 
    Document   : panierCommande
    Created on : 17 déc. 2019, 01:07:05
    Author     : Benjamin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="../CSS/main.css">
        <script src="https://kit.fontawesome.com/47131369cd.js" crossorigin="anonymous"></script>
    </head>
    <body>      
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand" href="<c:url value='/'/>"><img src ="../images/logo_amazonia.png" alt= width="120" height="75"></a>
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
                      <a class="nav-link" href="<c:url value='/protected/panier'/>"><h4>Panier <i class="fas fa-shopping-cart"></i></h4></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<c:url value='/protected/profil'/>"><h4>Profil <i class="fas fa-user"></i></h4></a>
                  </li>
                </ul>
            </div>
        </nav> 
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                
                <li class="nav-item">
                    <a class="nav-link"href="<c:url value='/protected/panier?page=panier'/>">Panier</a>
                </li>                
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/protected/panier?page=commande'/>">Commande</a>
                </li>
                
            </ul>
        </nav>
        <br/>
        <div class="container">   
            <form action="<c:url value='/protected/panierCommande'/>" method="post" id ="formConnec" accept-charset="UTF-8">
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Numéro</span>
                </div>
                <input type="text" name= "numero" value="${commande.numero}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Client</span>
                </div>
                <input type="text" name="client" value="${nom}"  class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Commande</span>
                </div>
                <input type="text" name="fonction" value="${commande.commande}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Envoyée le</span>
                </div>
                <input type="text" name="adresse" value="${commande.envoyeLe}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Destinataire</span>
                </div>
                <input type="text" name="ville" value="${commande.destinataire}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Adresse Livraison</span>
                </div>
                <input type="text" name="region" value="${commande.adresseLivr}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Quantité</span>
                </div>
                <input type="text" name="cp" value="${commande.quantite}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Prix Unitaire</span>
                </div>
                <input type="text" name="pays" value="${commande.prixUni}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Quantité par unité</span>
                </div>
                <input type="text" name="tel" value="${commande.quantiteUni}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            <br/>
            <div class="input-group lg-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Remise</span>
                </div>
                <input type="text" name="fax" value="${commande.remise}" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"disabled>
            </div>
            </form>
           
        </div>
    </body>
</html>
