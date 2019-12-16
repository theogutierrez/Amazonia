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
        <title>JSP Page</title>
        <link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="../CSS/main.css">
        <script src="https://kit.fontawesome.com/47131369cd.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
          google.charts.load("current", {packages:["corechart"]});
          google.charts.setOnLoadCallback(drawChartCategorie);
          function drawChartCategorie() {
            var data = google.visualization.arrayToDataTable([
              ['Categorie', 'Chiffre d\'affaire'],
              ['Work',     11],
              ['Eat',      2],
              ['Commute',  2],
              ['Watch TV', 2],
              ['Sleep',    7]
            ]);

            var options = {
              title: 'Chiffre d\'affaire par catégorie',
              is3D: true,
            };

            var chart = new google.visualization.PieChart(document.getElementById('grapheCategorie'));
            chart.draw(data, options);
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
                      <a class="nav-link" href=""><h4>Panier <i class="fas fa-shopping-cart"></i></h4></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href=""><h4>Connexion <i class="fas fa-sign-in-alt"></i></h4></a>
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
            <div class="row">
                <form>
                    <div class="col">
                        <input type="text" class="form-control" value="1900-00-00">
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" value="2100-00-00">
                    </div>
                </form>
            </div>
            <br/>
            <div class="row">
                <div class="col text-center">
                    <button type="submit" class="btn btn-success btn-lg" form="formCategorie"  name="action" value="Valider">Ajouter</button>              
                </div> 
            </div>    
        </div>        
    </body>
</html>
