<%-- 
    Document   : Index
    Created on : 14 ago 2023, 18:19:12
    Author     : jc997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <h1>Productos</h1>

        <p><a href="TareasController?accion=Nuevo">Nuevo Registro</a></p>

        <table border="1" width="80%">
            <thead>
            <th>Código</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Existencia</th>
            <th></th>
            <th></th>
        </thead>

        <tbody>
            <c:forEach var="tarea" items="${lista}">
                <tr>
                    <td><c:out value="${tarea.titulo}" /></td>
                    <td><c:out value="${tarea.descripcion}" /></td>
                    <td><c:out value="${tarea.hora}" /></td>
                    <td><a href="TareasController?accion=Modificar&id=<c:out value="${tarea.id}" />">Modificar</a></td>
                    <td><a href="TareasController?accion=Eliminar&id=<c:out value="${tarea.id}" />">Eliminar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
