<%-- 
    Document   : Modificar
    Created on : 14 ago 2023, 18:20:10
    Author     : jc997
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar producto</title>
    </head>
    <body>
        <h1>Modificar registro</h1>

        <form action="TareasController?accion=Actualizar" method="POST" autocomplete="off">

            <input type="hidden" id="id" name="id" value="<c:out value="${tarea.id}" />" />

            <p>
                Titulo <input type="text" id="titulo" name="titulo" value="<c:out value="${tarea.titulo}" />" required />
            </p>

            <p>
                Descripcion: <input type="text" id="descripcion" name="descripcion" value="<c:out value="${tarea.descripcion}" />" required />
            </p>

            <p>
                Hora: <input type="text" id="hora" name="hora" value="<c:out value="${tarea.hora}" />" required />
            </p>

           

            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>