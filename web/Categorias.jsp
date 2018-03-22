<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title><meta charset="utf-8">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <blockquote>
                        <h4>Ingresar Categorias</h4>
                    </blockquote>                            
                </div>     
                <form class="col s8 push-s2">
            <div class="row">
                <div class="input-field col  s12">
                    <input id="nombre" type="text" class="validate">
                    <label for="nombre" >Nombre de la Categoria</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <textarea id="descripcion" class="materialize-textarea"></textarea>
                    <label for="descripcion">Descripcion de la Categoria</label>
                </div>
            </div>  
            <div class="row">
                    <button class="btn waves-effect waves-light col s12" type="submit" name="action">
                        Aceptar<i class="material-icons right">send</i>
                    </button>
            </div>        
        </form>
    </body>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    <script type="text/javascript">
    $('#textarea1').val('New Text');
    $('#textarea1').trigger('autoresize');
    </script>
</html>