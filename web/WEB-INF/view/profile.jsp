<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : 
    Created on : 04/09/2019, 04:28:19 PM
    Author     : Windows10
--%>


<body>
    <header>
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
            <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
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

    <div class="container">

        <div class="row">
            <div class="col-xs-12 col-md-6">
                <h2>Bienveido/a: <c:out value="${sessionScope.user.nombrePersona}"/></h2>
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
            <div class="col-xs-12 col-md-6">
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



