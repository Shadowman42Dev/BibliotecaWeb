<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                        <h4>Inicion de Sesion</h4>
                    </blockquote>                            
                </div>     
                <form class="col s8 push-s2">
                    <div class="row">
        <div class="input-field col  s12">
          <input id="us" type="text" class="validate">
          <label for="us" >Usuario</label>
        </div>
      </div>
        <div class="row">
        <div class="input-field col s12">
          <input id="password" type="password" class="validate">
          <label for="password">Password</label>
        </div>
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
            $(document).ready(function () {
                $('select').select();
            });
        </script>
        <script type="text/javascript">
        $(document).ready(function(){
    $('.sidenav').sidenav();
  });
    </script>
</html>