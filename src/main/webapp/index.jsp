<%-- 
    Document   : index
    Created on : 19 nov. 2019, 13:54:33
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link rel="stylesheet" href="bootstrap-4.3.1/css/bootstrap.min.css">
    </head>
    <body>      
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
              <a class="navbar-brand" href="#"><img src ="images/logo_amazonia.jpg" alt= width="120" height="75"></a>
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
                      <a class="nav-link" href="#"><h4>Panier</h4></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="connexion.jsp"><h4>Connexion</h4></a>
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
                        <th>Fournisseur</th>
                        <th>Catégorie</th>
                        <th>Prix</th>
                        <th>Quantité</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Coca</td>
                        <td>Boisson</td>
                        <td>25€</td>
                        <td>
                            <select class="form-control" id="sel1">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                            </select>
                        </td>
                        <td><button type="button" class="btn btn-info">Ajouter Panier</button></td>
                    </tr>
                    <tr>
                        <td>Coca</td>
                        <td>Boisson</td>
                        <td>25€</td>
                        <td>
                            <select class="form-control" id="sel1">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                            </select>
                        </td>
                        <td><button type="button" class="btn btn-info">Ajouter Panier</button></td>
                    </tr>
                    <tr>
                        <td>Coca</td>
                        <td>Boisson</td>
                        <td>25€</td>
                        <td>
                            <select class="form-control" id="sel1">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                            </select>
                        </td>
                        <td><button type="button" class="btn btn-info">Ajouter Panier</button></td>
                    </tr>
                </tbody>
            </table>
        </div>       
    </body>
    <ul class="nav justify-content-center">
            <a href="Admin.jsp"   <button class="btn btn-success" type="submit"><h4>Admin</h4></button></a>
        </ul>
</html>
