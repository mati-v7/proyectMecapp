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
                <h2>Encontrar mi Vehiculo</h2>
                <form action="encontrarVehiculo" method="post">
                    <div class="form-group">
                        <label for="inputChasis" class="sr-only">Numero de Chasis</label>
                        <input type="text" name="" id="inputChasis" class="form-control" placeholder="Chasis" aria-describedby="chasisHelp"/>
                        <small id="chasisHelp" class="form-text text-muted">
                            Ingrese los 17 dígitos de su número de CHASIS que se encuentra en la Cédula de Identificación del Vehículo.
                        </small>
                    </div>

                    <div class="form-group">
                        <div class="col-md-6">
                            <button name="" type="submit" class="btn btn-primary">Encontrar vehiculo</button>
                        </div>
                    </div>
                    <p>${info}</p>
                </form>
            </div>
            <div class="col-xs-12 col-md-6">
                <h2>¿Aún no registró su vehiculo?</h2>
                <p>
                    ¡Registrelo de forma facil con pocos pasos!
                </p>
                <div class="form-group">
                    <a href="car_record" class="btn btn-secondary" role="button">Registrar</a>
                </div>
            </div>
        </div>
    </div>



