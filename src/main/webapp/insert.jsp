<%-- 
    Document   : insert
    Created on : 21-mar-2021, 13:03:40
    Author     : David Rebato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand" href="index.jsp">BookMarks</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar links -->
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="servletEnlaces?op=listar">Listar enlaces</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="servletEnlaces?op=insert1"">Nuevo enlace</a>
                    </li>
                </ul>
            </div>
        </nav>
    </head>
    <body>
        <h1>Insertar Enlace</h1>
        <form action="servletEnlaces?op=insert2" method="GET">
            <p><label for="nombre">Nombre: <input type="text" id="nombre" name="nombre" class="form-control" required></label></p>
            <p><label for="link">Enlace: <input type="text" id="link" name="link" class="form-control" required></label></p>
            <p>
                <label for="tipo">Tipo: 
                    <select id="tipo" name="tipo" class="form-control" required>
                        <option value="Noticias">Noticias</option>
                        <option value="Deportes">Deportes</option>
                        <option value="Compras">Compras</option>
                        <option value="Musica">Música</option>
                        <option value="Otros">Otros...</option>
                    </select>
                </label>
            </p>
            <input type="hidden" name="op" required value="insert2">
            <input type="submit" value="Insertar página">
        </form>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
