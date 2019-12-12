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
    </head>
    
    <body role="document"> 
        
        
        
        <div class="container-fluid">
          <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-sm bg-light navbar-light">
                    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                      <a class="navbar-brand" href="http://localhost:10080/Amazonia/views/index.jsp"><img src ="../images/logo_amazonia.png" alt= width="120" height="75"></a>
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
                              <a class="nav-link" href="http://localhost:10080/Amazonia/views/panier.jsp"><h4>Panier <i class="fas fa-shopping-cart"></i></h4></a>
                          </li>
                          <li class="nav-item">
                              <a class="nav-link" href="http://localhost:10080/Amazonia/views/connexion.jsp"><h4>Connexion <i class="fas fa-sign-in-alt"></i></h4></a>
                          </li>
                        </ul>
                    </div>
                </nav> 
                <nav class="navbar navbar-expand-sm bg-light navbar-light">
                    <ul class="navbar-nav navbar-brand mx-auto">
                            <a><h2>Administration</h2></a>
                    </ul>
                </nav>
            </div>
          </div>
          <div class="row">
            <div class="col-2">
                <!-- top navbar start -->
                <nav class="navbar navbar-default navbar-fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>   
                    </div>

                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="javascript:void(0);">Home</a></li>
                            <li><a href="javascript:void(0);">Page 1</a></li>
                            <li><a hhref="javascript:void(0);">Page 2</a></li>
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 3
                                <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:void(0);">Page 3-1</a></li>
                                    <li><a href="javascript:void(0);">Page 3-2</a></li>
                                    <li><a href="javascript:void(0);">Page 3-3</a></li>
                                </ul>
                            </li>
                            <li><a href="javascript:void(0);">Page 4</a></li>
                        </ul>
                    </div>
                </div>
                </nav>



                <!-- left navbar start -->
                <nav id="navbar-custom" class="navbar navbar-default bg-light navbar-left">
                    <div class="navbar-header">
                        <!--<a class="navbar-brand" href="#">Brand</a>-->
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" title="Page 1" ><i class="fa fa-cogs" aria-hidden="true"></i> <span class="hidden-xs">Page 1</span> <i class="fa fa-caret-right" aria-hidden="true"></i></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="javascript:void(0);" >Page 1-1</a></li>
                                <li><a href="javascript:void(0);" >Page 1-2</a></li>
                                <li><a href="javascript:void(0);" >Page 1-3</a></li>
                                <li><a href="javascript:void(0);" >Page 1-4</a></li>
                                <li><a href="javascript:void(0);" >Page 1-5</a></li>
                            </ul>
                        </li>
                        <li><a href="javascript:void(0);" title="Page 2" ><i class="fa fa-user-circle-o" aria-hidden="true"></i> <span class="hidden-xs">Page 2</span></a></li>
                        <li><a href="javascript:void(0);" title="Page 3" ><i class="fa fa-tachometer" aria-hidden="true"></i> <span class="hidden-xs">Page 3</span></a></li>
                        <li><a href="javascript:void(0);" title="Page 4" ><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span class="hidden-xs">Page 4</span></a></li>
                        <li><a href="javascript:void(0);" title="Page 5" ><i class="fa fa-history" aria-hidden="true"></i> <span class="hidden-xs">Page 5</span></a></li>


                    </ul>
                </nav>
            </div> 
                <div class="col-10">
                
                <nav class="navbar navbar-expand-sm navbar-light">
                    <ul class="navbar-nav navbar-brand mx-auto">
                        <a><strong>Ajouter un produit :</strong></a>
                    </ul>
                </nav>
                <br/>
                <div class="container">        
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Référence</th>
                                <th>Nom</th>
                                <th>Catégorie</th>
                                <th>Prix</th>
                                <th>Fournisseur</th>
                            </tr>
                        </thead>
                        <thead>
                             <tr>
                                <td><input id="new"></td>
                                <td><input id="new" ></td>
                                <td><input id="new" ></td>
                                <td><input id="new" ></td>
                                <td><input id="new" ></td>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <th>Réapprovisionnement</th>
                                <th>Quantité par unité</th>
                                <th>Prix Unitaire</th>
                                <th>Unités en stock</th>
                                <th>Unités en Commande</th>
                            </tr>
                        </thead>
                        <thead>
                            <tr>
                                <td><input id="new"></td>
                                <td><input id="new" ></td>
                                <td><input id="new" ></td>
                                <td><input id="new" ></td>
                                <td><input id="new" ></td>
                            </tr>
                        </thead>
                    </table>
                </div>
                <ul class="nav justify-content-center">
                    <a href="http://localhost:10080/Amazonia/views/admin.jsp"><button class="btn btn-success btn-lg" type="submit">Ajouter</button></a>
                </ul>
                <br/>
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
                            <tr>
                                <td><input id="coca" placeholder=""></td>
                                <td><input id="coca" value="coca"></td>
                                <td><input id="coca" value="Boisson"></td>
                                <td><input id="coca" value="25€"></td>

                                <td><button type="button" class="btn btn-info">Modifier</button></td>
                                <td><button type="button" class="btn btn-info">Supprimer</button></td>
                            </tr>
                            <tr>
                                <td><input id="coca" placeholder=""></td>
                                <td><input id="coca" value="coca"></td>
                                <td><input id="coca" value="Boisson"></td>
                                <td><input id="coca" value="25€"></td>

                                <td><button type="button" class="btn btn-info">Modifier</button></td>
                                <td><button type="button" class="btn btn-info">Supprimer</button></td>
                            </tr>
                            <tr>
                                <td><input id="coca" placeholder=""></td>
                                <td><input id="coca" value="coca"></td>
                                <td><input id="coca" value="Boisson"></td>
                                <td><input id="coca" value="25€"></td>

                                <td><button type="button" class="btn btn-info">Modifier</button></td>
                                <td><button type="button" class="btn btn-info">Supprimer</button></td>
                            </tr>

                    </table>
                </div> 
            </div>
          </div>
        </div>
        
        
</body>
</html>
