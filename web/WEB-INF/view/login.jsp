<%-- 
    Document   : login
    Created on : 04/09/2019, 04:20:43 PM
    Author     : Windows10
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimun-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="icon" href="img/registro/logo.png" />
        <link rel="stylesheet" type="text/css" href="css/loginstyles.css">
        <title>Mecapp</title>
    </head>

    <body class="text-center">
        
            <script type="text/javascript">
            $(document).ready(function () {
                $("#loginForm").validate({
                    rules: {
                        inputEmail: {
                            required: true,
                            email: true
                        },
                        inputPassword: {
                            required: true,
                            password: true
                        }
                    }
                });
            });
        
            </script>
           
        <!--Formulario Login-->
        <div class="card">
            <form action="iniciarSesion" method="post" id="loginForm" class="form-signin">
                <img class="mb-4" src="img/registro/logo1.png" alt="" height="72"/>
                <h2 class="h2 mb-3"><fmt:message key="tituloLogin"/></h2>

                <div class="form-group">
                    <label for="inputEmail" class="sr-only"><fmt:message key="inputEmail"/></label>
                    <input type="email" name="txtEmail" id="inputEmail" class="form-control" placeholder="<fmt:message key="inputEmail"/>" />
                </div>

                <div class="form-group">
                    <label for="inputPassword" class="sr-only"><fmt:message key="inputPassword"/></label>
                    <input type="password" name="txtPass" id="inputPassword" class="form-control" placeholder="<fmt:message key="inputPassword"/>" />
                </div>


                <div class="form-group">
                    <button name="" type="submit" class="btn btn-primary"><fmt:message key="btnLogin"/></button>
                    <a href="customer_record" class="btn btn-secondary" role="button"><fmt:message key="btnRegistrarse"/></a>
                </div>
                    <p class="mt-5 mb-3 text-muted"><fmt:message key="copyright"/></p>
            </form>
        </form>

    </div>
</body>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html> 






