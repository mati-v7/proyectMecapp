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
                    <p>${tipos.idtipoUsuario}  ${tipos.tipoUsuario}</p>
                    <p>Descripcion...
                    Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. 
                    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, 
                    cuando un impresor (N. del T. persona que se dedica a la imprenta) 
                    desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. 
                    No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, 
                    quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas "Letraset", 
                    las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, 
                    el cual incluye versiones de Lorem Ipsum.</p>
                    <p><a href="#" class="btn btn-primary btn-lg" role="button">Ver detalles...</a></p>
                </div>

                <div class="col-md-4">
                    <h2><font>Marcas</font></h2>
                    <c:forEach var="marc" items="${marcas}">
                    <p>${marc.idmarcaVehiculo}  ${marc.marcaVehiculo}</p>
                    </c:forEach>
                     <p>Descripcion...
                    Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. 
                    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, 
                    cuando un impresor (N. del T. persona que se dedica a la imprenta) 
                    desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. 
                    No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, 
                    quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas "Letraset", 
                    las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, 
                    el cual incluye versiones de Lorem Ipsum.</p>
                    <p><a href="#" class="btn btn-primary btn-lg" role="button">Ver detalles...</a></p>
                </div>
                
                <div class="col-md-4">
                    <h2><font>Logearse</font></h2>
                     <p>Descripcion...
                    Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. 
                    Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, 
                    cuando un impresor (N. del T. persona que se dedica a la imprenta) 
                    desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. 
                    No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, 
                    quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas "Letraset", 
                    las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, 
                    el cual incluye versiones de Lorem Ipsum.</p>
                    <p><a href="login" class="btn btn-primary btn-lg" role="button">Ver detalles...</a></p>
                </div>
            </div>
            <hr>
        </div>
    </main>


