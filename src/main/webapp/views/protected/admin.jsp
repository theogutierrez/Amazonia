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
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/0.8.1/mustache.min.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script>
            $(document).ready(// Exécuté à la fin du chargement de la page
                function () {
                    // On montre la liste des codes
                    searchAll("categorie","1994-08-04","1996-06-05");
                }
            );
            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert(xhr.responseText);
            }
        </script>
        <script type="text/javascript">
            google.charts.load("current", {packages:["corechart"]});
            google.charts.setOnLoadCallback(searchAll("categorie",'1994-08-04','1996-06-05'));
            function drawChart(dataTab) {
                var data = google.visualization.arrayToDataTable(dataTab);

                var options = {
                    title: 'Chiffre d\'affaire par catégorie',
                    is3D: true
                };

                var chart = new google.visualization.PieChart(document.getElementById('grapheCategorie'));
                chart.draw(data, options);
            }
            
            function searchAll(dateDeb,dateFin) {
                $.ajax({
                    url: "../statAdmin",
                    dataType: "json",
                    type : 'GET',
                    contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                    data:"categorie=categorie&datedeb=1994-08-04&datefin=1996-06-05",
                    success: 
                            function (result) {
                                var data = [];
                                data.push(["Catégorie", "CA"]);
                                for(var id in result.records) {
                                    data.push([id, result.records[id]]);
                                }
                                drawChart(data);
                            },
                    error: showError
                });                
            }
          
        </script>   
    </head>
        <body>  
        <!-- La zone où les résultats vont s'afficher -->
        <div id="cercle-categorie"></div>
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand"><img src ="../images/logo_amazonia.png" alt= width="120" height="75"></a>
            </div>
            <div class="mx-auto order-0">
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
        <div class="container">
            <div class="row">          
                <div class="lg-12"> 
                    <div id="grapheCategorie" class ="text-center"style="width: 900px; height: 500px;"></div>
                </div>
            </div>
            <form id ="formCategorie">
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" id="datedeb" value="1994-08-04">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" id="datefin" value="1996-06-05">
                    </div>
                </div>
            </form>
            <br/>
            <div class="row">
                <div class="col text-center">
                    <button type="button" class="btn btn-success btn-lg" form="formCategorie"  onclick="searchAll('datedeb','datefin')">Valider</button>              
                </div> 
            </div>    
        </div>
    </body>
</html>
