<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autores</title><meta charset="utf-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <%@include file="Navbar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <blockquote>
                        <h4>Ingresar Autores</h4>
                    </blockquote>                            
                </div>     
                <form class="col s8 push-s2">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="nombre">Nombre del( la) autora</label>
                            <input id="nombre" type="text" class="validate" name="nombre">
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="fechanacimiento">Fecha de Nacimiento del( la) autor(a)</label>
                            <input id="fechanacimiento" type="text" class="datepicker" name="fechanacimiento">
                        </div>
                    </div>  
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="fechadefuncion">Fecha de Defuncion del( la) autor(a)</label>               
                            <input id="fechadefuncion" type="text" class="datepicker" name="fechadefuncion">
                        </div><h6 class="red-text text-lighten-3">* Si ha fallecido</h6>
                    </div>
                    <div class="row">
                        <button class="btn waves-effect waves-light col s12" type="submit" name="action">
                            Aceptar<i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <%@include  file="Footer.jsp"%>
    </body>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript">
        $('.datepicker').pickadate({
            selectMonths: true, // Creates a dropdown to control month
            selectYears: 15, // Creates a dropdown of 15 years to control year,
            today: 'Today',
            clear: 'Clear',
            close: 'Ok',
            closeOnSelect: false // Close upon selecting a date,
        });
        </script>
        <script type="text/javascript">
        $(document).ready(function(){
    $('.sidenav').sidenav();
  });
    </script>
</html>