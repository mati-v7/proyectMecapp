<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : visit_registration
    Created on : 04/09/2019, 04:31:14 PM
    Author     : Windows10
--%>
<sql:query var="servicio" dataSource="jdbc/mecapp">
    SELECT tipoServicio FROM tiposervicio
</sql:query>

<body>
    <header>
        <div class="container">
            <h1><img src="img/registro/logo1.png" height="50" 
      alt="mdb logo"></h1>
        </div>
    </header>

    <div class="container-fluid">
        <div class="card"
        <form action="confirmation" method="GET">
            <h2>Agendamiento</h2>
            <div class="row">
                <div class="col-xs-12 col-md-6">

                    <h4>�Que necesitas que hagamos por tu vehiculo?</h4>
                    <div class="form-group">
                        <label for="inputServ" class="sr-only">Servicio</label>
                        <select class="form-control custom-select" id="inputServ" aria-describedby="servHelp">
                            <c:forEach var="serv" items="${servicio.rows}">
                                <option value="">${serv.tipoServicio}</option>
                            </c:forEach>
                            <option value="">Ambos</option>
                        </select>
                        <small id="servHelp" class="form-text text-muted">
                            Seleccione el tipo de servicio que necesita
                        </small>
                    </div>

                    <div class="form-group">
                        <label for="inputComent">Comentarios</label>
                        <textarea class="form-control" id="inputComent" placeholder="Escriba su comentario aqui"></textarea>
                    </div>
                </div>



                <div class="col-xs-12 col-md-6">
                    <h4>Indicanos una fecha para la visita</h4>
                    <div class="form-group">
                        <label for="inputDate" class="sr-only">Fecha:</label>
                        <input type="date" id="inputDate" class="form-control" name="" aria-describedby="dateHelp"/>
                        <small id="dateHelp" class="form-text text-muted">
                            Seleccione la fecha entre los rangos establecidos
                        </small>

                    </div>

                    <div class="form-group">
                        <label for="inputTime" class="sr-only">Hora:</label>
                        <input type="time" id="inputTime" class="form-control" name="" aria-describedby="timeHelp"/>
                        <small id="timeHelp" class="form-text text-muted">
                            Seleccione la hora de la fecha establecida anteriormente
                        </small>
                    </div>

                    <div class="form-group">
                        <div class="col-md-2">
                            <button name="" type="submit" class="btn btn-primary">Siguiente</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    </div>

