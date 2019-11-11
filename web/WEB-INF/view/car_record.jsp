<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : car_record
    Created on : 04/09/2019, 04:27:04 PM
    Author     : Windows10
--%>


<body>
    <header>
        <div class="container">
            <h1><img src="img/registro/logo1.png" height="50" 
      alt="mdb logo"></h1>
        </div>
    </header>
   
    <div class="container">
        <form action="registrarVehiculo" method="post">
            <div class="form-row">
                <div class="col-xs-12 col-md-6">
                    <h2>Datos del Vehiculo</h2>

                    <div class="form-group">
                        <label for="inputChasis" class="sr-only">Chasis</label>
                        <input type="text" name="txtChasis" id="inputChasis" class="form-control" placeholder="Chasis"/>
                    </div>

                    <div class="form-group">
                        <label for="inputChapa" class="sr-only">Chapa</label>
                        <input type="text" name="txtChapa" id="inputChapa" class="form-control" placeholder="Chapa"/>
                    </div>

                    <div class="form-group">
                        <label for="inputModel">Modelo</label>
                        <select class="form-control custom-select" id="inputModel" name="model">
                            <option selected>Seleccione una marca para ver modelos</option>
                            
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputAnho" class="sr-only">Año</label>
                        <input type="text" name="txtAnho" id="inputAnho" class="form-control" placeholder="Año"/>
                    </div>

                    <div class="form-group">
                        <label for="inputKm" class="sr-only">Kilometraje</label>
                        <input type="text" name="txtKm" id="inputKm" class="form-control" placeholder="Kilometraje"/>
                    </div>

                    <div class="form-group">
                        <label for="inputColor" class="sr-only">Color</label>
                        <input type="text" name="txtColor" id="inputColor" class="form-control" placeholder="Color"/>
                    </div>
                    <div class="form-group">
                        <button name="" type="submit" class="btn btn-primary">Registrar Vehiculo</button>
                    </div>
                </div>

                <div class="col-xs-12 col-md-6">
                    <h3>Selecciona la marca</h3>
                    <div class="form-group">
                        <c:forEach var="marca" items="${marcas}">
                            <img src="" class="img-thumbnail"/>
                            <label for="radio1" class="radio-inline">
                                <input type="radio" name="rdMarca" value="${marca.idmarcaVehiculo}" id="radio" onchange="loadModel(this.value)">${marca.marcaVehiculo}
                            </label>
                        </c:forEach>
                            <p id="demo"></p>
                    </div>

                </div>
            </div>

        </form>
    </div>
