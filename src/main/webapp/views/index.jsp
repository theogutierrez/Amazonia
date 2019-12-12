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
                        showCodes();
                    }
            );

            function showCodes() {
                // On fait un appel AJAX pour chercher les codes
                $.ajax({
                    url: "allProduit",
                    dataType: "json",
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
              <a class="navbar-brand" href="index.jsp"><img src ="images/logo_amazonia.png" alt= width="120" height="75"></a>
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
                      <a class="nav-link" href="<c:url value='/connexion'/>"><h4>Connexion <i class="fas fa-sign-in-alt"></i></h4></a>
                  </li>
                </ul>
            </div>
        </nav> 
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                <li class="nav-item">
                    <a class="nav-link" href="#">Boissons</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Condiments</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Desserts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Produits Laitiers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pâtes et céréales</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Viandes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Produits secs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Poissons et fruits de mer</a>
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
                <div id="codes">
               
                        
                        
                        
                    
                
                
               
                   
                 
                </div>
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
                    <td>{{name}}</td>
                    <td>{{label}}</td>
                    <td>{{prix_unitaire}}</td>
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
                    <td><button type="button" class="btn btn-info">Ajouter Panier </button></td>
                </tr>
            {{/records}}
            </TABLE>
        </script>
    </body>

</html>
