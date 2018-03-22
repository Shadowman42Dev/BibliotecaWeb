<%-- 
    Document   : Usuarios
    Created on : 03-21-2018, 08:49:38 PM
    Author     : ivvyl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title><meta charset="utf-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
     <form class="col s12">
     <div class="row">
        <div class="col s12">
            <h1>Ingresar Usuarios</h1>
        </div>
     </div>
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
         
         <div class=" col s12">
         <button class="btn waves-effect waves-light" type="submit" name="action">
             Guardar
    <i class="material-icons right">send</i>
  </button></div>
    </form>
    </body>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</html>
