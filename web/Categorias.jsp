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
        <form class="col s12">
            <div class="row">
                <div class="col s12">
                    <h1>Ingresar Categorias</h1>
                </div>
            </div>
            <div class="row">
                <div class="input-field col  s12">
                    <input id="nombre" type="text" class="validate">
                    <label for="nombre" >Nombre de la Categoria</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <textarea id="descripcion" class="matextareaerialize-textarea"></textarea>
                    <label for="descripcion">Descripcion de la Categoria</label>
                </div>
            </div>  
        </form>
    </body>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
</html>