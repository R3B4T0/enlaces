<%-- 
    Document   : listar
    Created on : 21-mar-2021, 12:43:26
    Author     : David Rebato
--%>

<%@page import="modelo.Enlaces"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
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
        <div id="lista">
            <h1>Listado de enlaces</h1>
            <% 
                List<Enlaces> misEnlaces = (List<Enlaces>) request.getAttribute("misEnlaces");
                int num_paginas = (int) request.getAttribute("num_paginas");
                int pagina = (int) request.getAttribute("pagina");
            %>
            <p>Mostran página: ${pagina} de <%= num_paginas %></p>
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Link</th>
                    <th>Tipo</th>
                    <th>Borrar</th>
                    <th>Actualizar</th>
                </tr>
                <% 
                    for( Enlaces e: misEnlaces) { 
                        String cadenaBorrar = "<a onclick='return Confirmation()' href='servletEnlaces?op=borrar&id="+e.getId()+"'><i class='far fa-trash-alt'></i></a>";
                        String cadenaActualizar = "<a href='servletEnlaces?op=update1&id="+e.getId()+"'><i class='far fa-edit'></i></a>";
                %>
                        <tr>
                            <td><%= e.getId() %></td>
                            <td><%= e.getNombre() %></td>
                            <td><a href="<%= e.getLink() %>" target="_blank"><%= e.getLink() %></a></td>
                            <td><%= e.getTipo() %></td>
                            <td><%= cadenaBorrar %></td>
                            <td><%= cadenaActualizar %></td>
                        </tr>
                <%
                    }
                %>
                <%
                    for (int i = 1; i <= num_paginas; i++){
                        if (pagina == i) {
                %>
                            <%= i %>
                <%      
                        } else {
                %>
                            <a href="servletEnlaces?op=listar&pagina=<%= i %>"><%= i %></a>
                <%
                        }
                    } 
                %>
            </table>
        </div>
        <script>
            function Confirmation(){
                if ( confirm("Está seguro?")==true) {
                    alert("Procedo a borrar");
                    return true;
                }else {
                    alert("Operación cancelada");
                    return false;
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
