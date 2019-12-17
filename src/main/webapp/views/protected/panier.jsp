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
        <title>Panier</title>
        <link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>
        <script src="https://kit.fontawesome.com/47131369cd.js" crossorigin="anonymous"></script>
        <script>
            $(document).ready(// Exécuté à la fin du chargement de la page
                    function () {
                        // On montre la liste des codes
                        affProduit("panier");
                    }
            );
            
            function affProduit(cat) {
                // On fait un appel AJAX pour chercher les codes
               
                $.ajax({
                    url: "../affProduit",
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
            
             function AddOrdelete(cat,id) {
                // On fait un appel AJAX pour chercher les codes
                
                $.ajax({
                    url: "../AddDelete",
                    dataType: "json",
                    data:"AddOrDel="+cat+"&prodname="+$("#nom"+id).html()+"&libel="+$("#libel"+id).html()+"&quant="+$("#quantite"+id+" option:selected").val()+"&prix="+$("#prix"+id).html(),
                    error: showError,
                    success: // La fonction qui traite les résultats
                            function (result) {
                                    affProduit("panier");
    
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
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                <li class="nav-item">
                    <a><h2>Panier</h2></a>
                </li>
            </ul>
        </nav> 
        <div class="container">        
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th></th>
                        <th>Nom</th>
                        <th>Catégorie</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                        
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
                    <td id="nom{{produit_id}}">{{name}}</td>
                    <td id="libel{{produit_id}}">{{libel}}</td>
                     
                    <td id="prix{{produit_id}}">{{prix}}</td>
                    <td>{{quant}}</td>
                    <td ><button  type="button" id={{produit_id}} onclick="AddOrdelete('Del',{{produit_id}})" class="btn btn-info">Supprimer</button></td>
                
                   
                </tr>
            {{/records}}
            </TABLE>
        </script>
    </body>
</html>
