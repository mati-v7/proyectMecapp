<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : find_car
    Created on : 04/09/2019, 04:28:19 PM
    Author     : Windows10
--%>

<body>
    <header>
        <div class="container">
            <h1>Hello World!</h1>
        </div>
    </header>

    <div class="container">

        <div class="row">
            <div class="col-xs-12 col-md-6">
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



