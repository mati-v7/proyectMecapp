<%-- 
    Document   : registro
    Created on : 04/09/2019, 04:24:35 PM
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
        
        <form action="registrarUsuario" method="post" class="form-horizontal">
            <div class="row clearfix">
                <div class="col-sm-12 col-md-6">
                    <div class="card">
                    <h2>Datos Personales</h2>
                    <div class="form-group">
                        <label for="inputName" class="sr-only">Nombre</label>
                        <input type="text" name="txtNombre" id="inputName" class="form-control" placeholder="Nombre" required autofocus>
                    </div>

                    <div class="form-group">
                        <label for="inputLastName" class="sr-only">Apellido</label>
                        <input type="text" name="txtApellido" id="inputLastName" class="form-control" placeholder="Apellido" required>
                    </div>

                    <div class="form-group">
                        <label for="select" class="sr-only">Elige una opci�n:</label>
                        <div class="input-group">
                            <select id="select" name="combDoc" class="form-control custom-select">
                                <option value="1">Ci</option>
                                <option value="2">RUC</option>
                            </select>
                            <input type="text" name="txtDoc" class="form-control input-group-addon" placeholder="CI o RUC" required>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputPass" class="sr-only">Contrase�a:</label>
                        <input type="password" name="txtPass" class="form-control" placeholder="Contrase�a" required>
                    </div>

                    <div class="form-group">
                        <label for="inputRePass" class="sr-only">Reescriba la contrase�a:</label>
                        <input type="password" name="" class="form-control" placeholder="Reescriba la contrase�a" required>
                    </div>

                

               <div class="col-md-12">
                    <h2>�Como te contactamos?</h2>

                    <div class="form-group">
                        <label for="inputDir" class="sr-only">Direcci�n</label>
                        <input type="text" name="txtDireccion" id="inputDir" class="form-control" placeholder="Direcci�n" required>
                    </div>

                    <div class="form-group">
                        <label for="inputTel" class="sr-only">Telefono</label>
                        <input type="tel" name="txtTelefono" id="inputTel" class="form-control" placeholder="Telefono" required>
                    </div>

                    <div class="form-group">
                        <label for="inputEmail" class="sr-only">Correo electronico</label>
                        <input type="email" name="txtEmail" id="inputEmail" class="form-control" placeholder="Correo electronico" required>
                    </div>    
                </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <button name="" type="submit" class="btn btn-primary">Registrarse</button>
                    </div>
                </div>

        </form>
    </div>
            </div>
        </body>

