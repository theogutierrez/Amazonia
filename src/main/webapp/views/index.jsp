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
        <title>Accueil</title>
        <link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
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
                    url: "affProduit",
                    dataType: "json",
                    type : 'GET',
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
                    
            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert(xhr.responseText);
            }
        </script>
        
    </head>
    <body>  
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand" onclick="affProduit('tous')"><img src ="images/logo_amazonia.png" alt= width="120" height="75"></a>
            </div>
            <div class="mx-auto order-0">
                <form class="form-inline navbar-brand mx-auto" >
                  <input class="form-control input-group-btn" id="search" type="text" placeholder="Rechercher">
                  <button class="btn btn-success"  id="recherche" onclick="affProduit('search')" type="button">Rechercher</button>
                </form>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                      <a class="nav-link" href="<c:url value='/protected/panier'/>"><h4>Panier <i class="fas fa-shopping-cart"></i></h4></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<c:url value='/connexion'/>"><h4>Connexion <i class="fas fa-sign-in-alt"></i></h4></a>
                  </li>
                </ul>
            </div>
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
                        <th>Nom</th>
                        <th>Catégorie</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="codes">
               
                        
                        
                        
                    
                
                
               
                   
                 
                </tbody>
            </table>
        </div>  
        <footer class="page-footer font-small light">
            <div class="container text-center">
                <small>Copyright Amazonia</small>
            </div>
        </footer>
      <script id="codesTemplate" type="text/template">
            <TABLE>
            
            {{! Pour chaque enregistrement }}
            {{#records}}
                {{! Une ligne dans la table }}
                <tr>
                    <td> {{name}}</td>
                    <td> {{label}}</td>
                     {{#indisponible}}
                        <td> {{prix_unitaire}}</td>
                    <td>
                        <select class="form-control" id="sell">
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                         <option>8</option>
                          <option>10</option>

                        </select>
                    </td>
                        
                     {{/indisponible}}
                    
                    {{^indisponible }}
                        
                        <td> Indisponible </td>
                        <td>
                        <select class="form-control" id="sell">
                        
                        

                        </select>
                    </td>
                    {{/indisponible}}
                    
                    <td><button type="button" class="btn btn-info">Ajouter Panier </button></td>
                </tr>
            {{/records}}
            </TABLE>
        </script>
    </body>

</html>
