<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 04/09/2019, 04:21:27 PM
    Author     : Windows10
--%>
<body>
    <!-- Barra de Navegacion-->
    <header>
        <div class="container">
            <h1>Hello World!</h1>
        </div>
    </header>

    <!-- Vista principal-->
    <main role="main">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Mecapp!!!</h1>
                
                <p>Esto es un texto de presentacion!!!</p>
                
                <hr class="my-4">
                
                <p>Mas descripcion...</p>
                <a class="btn btn-primary btn-lg" href="#" role="button">Ver mas</a>
                
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h2><font>Titulo</font></h2>
                    <c:forEach var="model" items="${modelos}">
                    <p>${model.idmodeloVehiculo}  ${model.modeloVehiculo}</p>
                    </c:forEach>
                    <p>Descripcion...</p>
                    <p><a href="#" class="btn btn-primary btn-lg" role="button">Ver detalles...</a></p>
                </div>

                <div class="col-md-4">
                    <h2><font>Marcas</font></h2>
                    <c:forEach var="marc" items="${marcas}">
                    <p>${marc.idmarcaVehiculo}  ${marc.marcaVehiculo}</p>
                    </c:forEach>
                    <p>Descripcion...</p>
                    <p><a href="#" class="btn btn-primary btn-lg" role="button">Ver detalles...</a></p>
                </div>
                
                <div class="col-md-4">
                    <h2><font>Logearse</font></h2>
                    <p>Descripcion...</p>
                    <p><a href="login" class="btn btn-primary btn-lg" role="button">Ver detalles...</a></p>
                </div>
            </div>
            <hr>
        </div>
    </main>


