<%-- 
    Document   : login
    Created on : 04/09/2019, 04:20:43 PM
    Author     : Windows10
--%>


<body class="">

    <header>
        <div class="container">
            <h1>Hello World!</h1>
        </div>
    </header>

    <!--Formulario Login-->
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form action="iniciarSesion" method="post" class="form-singin">

                    <h2 class="h2 mb-3">Iniciar Sesi�n</h2>

                    <div class="form-group">
                        <label for="inputEmail" class="sr-only">Direcci�n de correo electr�nico</label>
                        <input type="email" id="inputEmail" class="form-control" placeholder="Correo electr�nico" required autofocus/>
                    </div>

                    <div class="form-group">
                        <label for="inputPassword" class="sr-only">Contrase�a</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Contrase�a" required/>
                    </div>


                    <div class="form-group">
                        <a href="find_car" class="btn btn-primary" role="button">Iniciar Sesion</a>
                    </div>
                </form>
            </div>
            <div class="col-xs-12 col-md-6">

                <form action="customer_record" method="get" class="">
                    <h2>�A�n no esta Registrado?</h2>
                    <p>
                        �Registrese de forma facil con pocos pasos!
                    </p>
                    <div class="form-group">
                        <a href="customer_record" class="btn btn-secondary" role="button">Registrarse</a>
                    </div>
                </form> 
            </div>
        </div>
    </div>






