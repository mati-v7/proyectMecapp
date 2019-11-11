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
            <h1><img src="img/registro/logo1.png" height="50" 
      alt="mdb logo"></h1>
        </div>
    </header>

    <!-- Vista principal-->
    <main role="main">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Bienvenidos a Mecapp!!!</h1>
                 <!--Carousel Wrapper-->
    <div id="carousel-example-1z" class="carousel slide carousel-fade z-depth-1-half" data-ride="carousel">
      <!--Indicators-->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-1z" data-slide-to="1"></li>
        <li data-target="#carousel-example-1z" data-slide-to="2"></li>
      </ol>
      <!--/.Indicators-->
      <!--Slides-->
      <div class="carousel-inner" role="listbox">
        <!--First slide-->
        <div class="carousel-item active">
          <img class="d-block w-100" src="https://image.freepik.com/foto-gratis/servicio-automatico-angulo-cambiar-ruedas_23-2148327511.jpg" alt="First slide">
        </div>
        <!--/First slide-->
        <!--Second slide-->
        <div class="carousel-item">
          <img class="d-block w-100" src="https://image.freepik.com/foto-gratis/mecanico-hombre-reparacion-coche_1150-6496.jpg" alt="Second slide">
        </div>
        <!--/Second slide-->
        <!--Third slide-->
        <div class="carousel-item">
          <img class="d-block w-100" src="https://image.freepik.com/foto-gratis/reparador-automoviles-uniforme-blanco-pie-sosteniendo-llave-que-es-herramienta-esencial-mecanico_1150-16582.jpg" alt="Third slide">
        </div>
        <!--/Third slide-->
      </div>
      <!--/.Slides-->
      <!--Controls-->
      <a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
      <!--/.Controls-->
    </div>
    <!--/.Carousel Wrapper-->

    <h2 class="my-5 h2">Servicios</h2>

    <!--Carousel Wrapper-->
    <div id="carousel-example-2" class="carousel slide carousel-fade z-depth-1-half" data-ride="carousel">
      <!--Indicators-->
      <ol class="carousel-indicators">
        <li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-2" data-slide-to="1"></li>
        <li data-target="#carousel-example-2" data-slide-to="2"></li>
      </ol>
      <!--/.Indicators-->
      <!--Slides-->
      <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
          <div class="view">
            <img class="d-block w-100" src="https://image.freepik.com/foto-gratis/tecnico-que-comprueba-motor-coche_23-2147897986.jpg" alt="First slide">
            <div class="mask rgba-black-light"></div>
          </div>
          <div class="carousel-caption">
            <h3 class="h3-responsive">Diagnostico</h3>
            <p>Antes de cada servicio ofrecemos un diagnostico vehicular</p>
          </div>
        </div>
        <div class="carousel-item">
          <!--Mask color-->
          <div class="view">
            <img class="d-block w-100" src="https://image.freepik.com/foto-gratis/cierre-mecanico-automoviles-vertiendo-mano-reemplazando-aceite-fresco-motor-automovil-taller-reparacion-automoviles-mantenimiento-automoviles-concepto-industria_1150-16580.jpg" alt="Second slide">
            <div class="mask rgba-black-strong"></div>
          </div>
          <div class="carousel-caption">
            <h3 class="h3-responsive">Mantenimiento Express</h3>
            <p>Para aquellos que disponen de poco tiempo, ofrecemos un servicio express</p>
          </div>
        </div>
        <div class="carousel-item">
          <!--Mask color-->
          <div class="view">
            <img class="d-block w-100" src="https://image.freepik.com/foto-gratis/mecanico-servicios-coche_1170-1689.jpg" alt="Third slide">
            <div class="mask rgba-black-slight"></div>
          </div>
          <div class="carousel-caption">
            <h3 class="h3-responsive">Mecanica General</h3>
            <p>Ofrecemos nuestros servicios tecnicos para mantener los vehiculos funcionando en forma segura y confiable</p>
          </div>
        </div>
      </div>
      <!--/.Slides-->
      <!--Controls-->
      <a class="carousel-control-prev" href="#carousel-example-2" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carousel-example-2" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
      <!--/.Controls-->
    </div>
    <!--/.Carousel Wrapper-->

  </div>
                
                
                
                <hr class="my-4">
                
               <h2 class="my-5 h2">Marcas</h2>
                 <img src="https://i.pinimg.com/originals/80/08/6a/80086afa0556180210f4d1d0fc69b590.png" alt="First slide">
                 <img src="https://cdn0.iconfinder.com/data/icons/car-brands/550/Nissan_logo-128.png" alt="First slide">
                  <img src="https://i.pinimg.com/originals/4b/68/f9/4b68f92a526bd7e2af370a85bd6fab99.png" alt="First slide">
                 
                
                
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h2><font>Nosotros</font></h2>
                    <c:forEach var="model" items="${modelos}">
                    <p>${model.idmodeloVehiculo}  ${model.modeloVehiculo}</p>
                    
                    </c:forEach>
                    <p>${tipos.idtipoUsuario}  ${tipos.tipoUsuario}</p>
                    <p>Esta es una pagina para reservas en cuanto a servicio tecnico para talleres meanicos </p>
                    
                </div>

                <div class="col-md-4">
                    <h2><font>Servicios</font></h2>
                    <c:forEach var="model" items="${modelos}">
                    <p>${model.idmodeloVehiculo}  ${model.modeloVehiculo}</p>
                    
                    </c:forEach>
                    <p>${tipos.idtipoUsuario}  ${tipos.tipoUsuario}</p>
                    <p>Servicios mecanico y mantenimiento vehicular, estado de su vehiculo antes, durante y despues de la reparacion. </p>
                    
                </div>
                
                <div class="col-md-4">
                    <h2><font>Agendamiento</font></h2>
                     <p>Te ofrecemos una amplia gama en cuanto a servicio de taller de reparaciones mecanicas, electricas, chaperia y pintura.
                    </p>
                    <p><a href="login" class="btn btn-primary btn-lg" role="button">Agendamiento</a></p>
                </div>
            </div>
            <hr>
        </div>
    </main>


