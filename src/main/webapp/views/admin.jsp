<%-- 
    Document   : Admin
    Created on : 4 déc. 2019, 15:51:23
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/47131369cd.js" crossorigin="anonymous"></script>
    </head>
        <body>      
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand" href="index.jsp"><img src ="../images/logo_amazonia.png" alt= width="120" height="75"></a>
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
                      <a class="nav-link" href="panier.jsp"><h4>Panier <i class="fas fa-shopping-cart"></i></h4></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="connexion.jsp"><h4>Connexion <i class="fas fa-sign-in-alt"></i></h4></a>
                  </li>
                </ul>
            </div>
        </nav> 
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <ul class="navbar-nav navbar-brand mx-auto">
                    <a><h2>Administration</h2></a>
            </ul>
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
                        <th>Référence</th>
                        <th>Nom</th>
                        <th>Catégorie</th>
                        <th>Prix</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input id="new"></td>
                        <td><input id="new" ></td>
                        <td><input id="new" ></td>
                        <td><input id="new" ></td>
                       
                        <td><button type="button" class="btn btn-info">Ajouter</button></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input id="coca" placeholder=""></td>
                        <td><input id="coca" value="coca"></td>
                        <td><input id="coca" placeholder="Boisson"></td>
                        <td><input id="coca" placeholder="25€"></td>
                        
                        <td><button type="button" class="btn btn-info">Modifier</button></td>
                        <td><button type="button" class="btn btn-info">Supprimer</button></td>
                    </tr>
                    <tr>
                        <td><input id="coca" placeholder=""></td>
                        <td><input id="coca" placeholder="coca"></td>
                        <td><input id="coca" placeholder="Boisson"></td>
                        <td><input id="coca" placeholder="25€"></td>
                        
                        <td><button type="button" class="btn btn-info">Modifier</button></td>
                        <td><button type="button" class="btn btn-info">Supprimer</button></td>
                    </tr>
                    <tr>
                        <td><input id="coca" placeholder=""></td>
                        <td><input id="coca" placeholder="coca"></td>
                        <td><input id="coca" placeholder="Boisson"></td>
                        <td><input id="coca" placeholder="25€"></td>
                        
                        <td><button type="button" class="btn btn-info">Modifier</button></td>
                        <td><button type="button" class="btn btn-info">Supprimer</button></td>
                    </tr>
                </tbody>
            </table>
        </div>       
    </body>
</html>
