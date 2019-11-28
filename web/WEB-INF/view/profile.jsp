<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : 
    Created on : 04/09/2019, 04:28:19 PM
    Author     : Windows10
--%>


<body class="theme-blue">
    <header>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
         <!-- Favicon-->
    <link rel="icon" href="favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Morris Chart Css-->
    <link href="plugins/morrisjs/morris.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="css/style.css" rel="stylesheet">

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link href="css/themes/all-themes.css" rel="stylesheet" />
        <!--Navbar -->

        <nav class=" navbar navbar-expand-lg  navbar-dark danger-color ">
            <a class="navbar-brand" href="#">
                <img src="img/registro/logo1.png" height="50" 
                     alt="mdb logo">
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
                    aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="container-fluid" id="navbarSupportedContent-333">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Datos
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Estado</a>
                    </li>

                </ul>
                <ul class="navbar-nav ml-auto nav-flex-icons">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-default"
                             aria-labelledby="navbarDropdownMenuLink-333">
                            <a class="dropdown-item" href="customer_record">Configuracion</a>
                            <a class="dropdown-item" href="cerrarsesion">Cerrar Sesion</a>

                        </div>
                    </li>
                </ul>
            </div>
        </nav>

        <!--/.Navbar -->
    </header>
    <section class="content">
        <div class="container-fluid">

            <div class="row clearfix">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="panel panel-default panel-default">
                        <div class="header"
                             <h2>Bienvenido/a: <c:out value="${sessionScope.user.nombrePersona}"/></h2>
                        </div>
                        
                             <table class="table table-sm">

                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Chasis</th>
                                        <th scope="col">Chapa</th>
                                        <th scope="col">Km</th>
                                        <th scope="col">Año</th>
                                        <th scope="col">Color</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="vehiculo" items="${vehiculos}">
                                        <tr>
                                            <td>${vehiculo.idvehiculo}</td>
                                            <td>${vehiculo.chasisVehiculo}</td>
                                            <td>${vehiculo.chapaVehiculo}</td>
                                            <td>${vehiculo.kmVehiculo}</td>
                                            <td>${vehiculo.anhoVehiculo}</td>
                                            <td>${vehiculo.colorVehiculo}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                    </div>
                        <div class="card">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="body"
                            <h2>¿Aún no registró su vehiculo?</h2>
                            <p>
                                ¡Registrelo de forma facil con pocos pasos!
                            </p>
                            <div class="form-group">
                                <a href="car_record" class="btn btn-secondary" role="button">Registrar Vehiculo</a>
                            </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
                <section>
        <!-- Left Sidebar -->
        <aside id="leftsidebar" class="sidebar">
            <!-- User Info -->
            <div class="user-info" class="theme-blue">
                
                <div class="info-container" class="theme-blue" >
                    <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><c:out value="${sessionScope.user.nombrePersona}"/></div>
                    <div class="email">john.doe@example.com</div>
                    <div class="btn-group user-helper-dropdown">
                        <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                        <ul class="dropdown-menu pull-right">
                            <li><a href="javascript:void(0);"><i class="material-icons">person</i>Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">group</i>Followers</a></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">shopping_cart</i>Sales</a></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Likes</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="javascript:void(0);"><i class="material-icons">input</i>Sign Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- #User Info -->
            <!-- Menu -->
            <div class="menu">
                <ul class="list">
                    <li class="header">MAIN NAVIGATION</li>
                    <li>
                        <a href="customer_record">
                            <i class="material-icons">home</i>
                            <span>Datos Personales</span>
                        </a>
                    </li>
                    
                    <li>
                        <a href="confirmation">
                            <i class="material-icons">layers</i>
                            <span>Agendamiento</span>
                        </a>
                    </li>
          
                </ul>
            </div>
            <!-- #Menu -->
            <!-- Footer -->
            <div class="legal">
                <div class="copyright">
                    &copy; 2019 <a href="javascript:void(0);">Mecapp</a>.
                </div>
                <div class="version">
                    <b>Version: </b> 1.0
                </div>
            </div>
            <!-- #Footer -->
        </aside>
        <!-- #END# Left Sidebar -->
       
    </section>
</body>
