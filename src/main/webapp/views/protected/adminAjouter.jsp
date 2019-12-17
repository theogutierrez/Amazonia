<%-- 
    Document   : Admin
    Created on : 4 déc. 2019, 15:51:23
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
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
                       <a class="btn btn-danger" href="<c:url value='../connexion?action=logout'/>">Déconnecter</a>
                  </li>

                </ul>
            </div>
        </nav> 
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                
                <li class="nav-item">
                    <a class="nav-link"href="<c:url value='/protected/admin?page=stat'/>">Statistiques</a>
                </li>                
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/protected/admin?page=ajouter'/>">Ajouter un produit</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/protected/admin?page=modifier'/>">Modifier des produits</a>
                </li>
            </ul>
        </nav> 
        <br/>
        <div class="col-lg-12 text-center font-weight-bold"> ${produitAjouter}</div>
        <div class="container">    
            <form action="<c:url value='/protected/admin?page=ajouter'/>" method="post" id ="formAjouter">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Catégorie</th>
                            <th>Fournisseur</th>
                            <th>Réapprovisionnement</th>
                            <th>Quantité par unité</th>
                        </tr>
                    </thead>
                    <thead>
                         <tr>
                            <td><input name="nom" ></td>
                            <td><input name="categorie" ></td>
                            <td><input name="fournisseur" ></td>
                            <td><input name="reapprovisionnement"></td>
                            <td><input name="quantite" ></td>
                        </tr>
                    </thead>
                    <thead>
                        <tr>

                            <th>Prix Unitaire</th>
                            <th>Unités en stock</th>
                            <th>Unités en Commande</th>
                            <th>Disponible</th>
                        </tr>
                    </thead>
                    <thead>
                        <tr>
                            <td><input name="prixU" ></td>
                            <td><input name="uniteS" ></td>
                            <td><input name="uniteC" ></td>
                            <td><input name="disponible" ></td>
                        </tr>
                    </thead>
                </table>
            </form>
            <div class="nav justify-content-center">
                <button type="submit" class="btn btn-success btn-lg" form="formAjouter"  name="action" value="ajouter">Ajouter</button>
            </div>
        </div>
    </body>
</html>
