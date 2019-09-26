<%-- 
    Document   : car_record
    Created on : 04/09/2019, 04:27:04 PM
    Author     : Windows10
--%>


<body>
    <header>
        <div class="container">
            <h1>Hello World!</h1>
        </div>
    </header>

    <div class="container">
        <form action="registrarVehiculo" method="post">
            <div class="form-row">
                <div class="col-xs-12 col-md-6">
                    <h2>Datos del Vehiculo</h2>

                    <div class="form-group">
                        <label for="inputChasis" class="sr-only">Chasis</label>
                        <input type="text" name="" id="inputChasis" class="form-control" placeholder="Chasis"/>
                    </div>

                    <div class="form-group">
                        <label for="inputChapa" class="sr-only">Chapa</label>
                        <input type="text" name="" id="inputChapa" class="form-control" placeholder="Chapa"/>
                    </div>

                    <div class="form-group">
                        <label for="inputModel">Modelo</label>
                        <select class="form-control custom-select" id="inputModel">
                            <option selected>Seleccione un modelo</option>
                            <option value="">Modelo1</option>
                            <option value="">Modelo2</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="inputAnho" class="sr-only">Año</label>
                        <input type="text" name="" id="inputAnho" class="form-control" placeholder="Año"/>
                    </div>

                    <div class="form-group">
                        <label for="inputKm" class="sr-only">Kilometraje</label>
                        <input type="text" name="" id="inputKm" class="form-control" placeholder="Kilometraje"/>
                    </div>
                    
                    <div class="form-group">
                        <label for="inputColor" class="sr-only">Color</label>
                        <input type="text" name="" id="inputColor" class="form-control" placeholder="Color"/>
                    </div>
                </div>

                <div class="col-xs-12 col-md-6">
                    <h3>Selecciona la marca</h3>
                    <div class="form-group">
                        <img src="" class="img-thumbnail"/>
                        <label for="radio1" class="radio-inline">
                            <input type="radio" name="rdContacto" value="" id="radio1"/>[Marca1]
                        </label>
                        

                        <img src="" class="img-thumbnail"/>
                         <label for="radio2" class="radio-inline">
                            <input type="radio" name="rdContacto" value="" id="radio2"/>[Marca2]
                        </label>

                        <img src="" class="img-thumbnail"/>
                         <label for="radio3" class="radio-inline">
                            <input type="radio" name="rdContacto" value="" id="radio3"/>[Marca3]
                        </label>
                    </div>
                   
                </div>
            </div>

        </form>
    </div>
