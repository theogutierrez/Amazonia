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
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>
        <script src="https://kit.fontawesome.com/47131369cd.js" crossorigin="anonymous"></script>
        <script>
            $(document).ready(// Exécuté à la fin du chargement de la page
                function () {
                    // On montre la liste des codes
                    affProduit("tous");
                }           
            );
            function affProduit(cat) {
            // On fait un appel AJAX pour chercher les codes
               
                $.ajax({
                    url:  '../affProduit',
                    dataType: "json",
                    type : 'GET',
                    xhrFields: { withCredentials:true }, 
                    contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    data:"categorie="+cat+"&recherche="+$("#search").val(),
                    error: showError,
                    success: // La fonction qui traite les résultats
                        function (result) {
                            var template = $('#codesTemplate').html();
                            // On combine le template avec le résultat de la requête
                            var processedTemplate = Mustache.to_html(template, result);
                            // On affiche la liste des options dans le select
                            $('#codes').html(processedTemplate);  
                        }
                });                                                           
            }
            
            function supprProduit(nom) {
                $.ajax({
                    url:  "admin",              
                    dataType: "json",               
                    type : 'GET',
                    xhrFields: { withCredentials:true }, 
                    contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    data:"page=modifier&action=supprimer&nom="+nom,
                    error: showError,
                    success: // La fonction qui traite les résultats
                        function (result) {
                            affProduit("tous");
                            console.log(result); 
                        }
                });
                return false;
            }
            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert(xhr.responseText);
            }
        </script>    
    </head>
        <body>      
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand"><img src ="../images/logo_amazonia.png" alt= width="120" height="75"></a>
            </div>
            <div class="mx-auto order-0">
                <form class="form-inline navbar-brand mx-auto" >
                  <input class="form-control input-group-btn" id="search" type="text" placeholder="Rechercher">
                  <button class="btn btn-success" id="recherche" onclick="affProduit('search')" type="button">Rechercher</button>
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
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                <li class="nav-item">
                    <a class="nav-link"  onclick="affProduit('Boissons')" href="#">Boissons</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Condiments')" href="#">Condiments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Desserts')" href="#">Desserts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Produit laitiers')" href="#">Produits Laitiers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Pâtes et céréales')" href="#" >Pâtes et céréales</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Viandes')" href="#">Viandes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Produit secs')" href="#">Produits secs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" onclick="affProduit('Poissons et fruits de mer')" href="#">Poissons et fruits de mer</a>
                </li>
            </ul>
        </nav> 
        <div class="container">        
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Référence</th>
                        <th>Nom</th>
                        <th>Catégorie</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody id="codes">
                  
                </tbody>
            </table>    
        </div>  
        <script id="codesTemplate" type="text/template">
            <TABLE>
            
            {{! Pour chaque enregistrement }}
            {{#records}}
                {{! Une ligne dans la table }}
                <tr>
                    <td id="produit_id{{produit_id}}">{{produit_id}}</td>
                    <td id="nom{{produit_id}}">{{name}}</td>
                    <td id="libel{{produit_id}}">{{label}}</td>
                    <td id="prix{{produit_id}}">{{prix_unitaire}}€</td>
                    <td ><button  type="button" id={{produit_id}} class="btn btn-info">Modifier</button>
                    <button  type="button" id={{produit_id}} onclick="supprProduit('{{name}}')" class="btn btn-danger">Supprimer</button></td> 
          
                </tr>
            {{/records}}
            </TABLE>
        </script>
    </body>
</html>
