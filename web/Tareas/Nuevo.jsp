<%-- 
    Document   : Nuevi
    Created on : 14 ago 2023, 18:19:53
    Author     : jc997
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Registro</title>
    </head>
    <body>
        <h1>Nuevo registro</h1>

        <form action="TareasController?accion=Insertar" method="POST" autocomplete="off">
            <p>
                Titulo: <input type="text" id="titulo" name="titulo" required autofocus="true" />
            </p>

            <p>
                Descripcion: <input type="text" id="descripcion" name="descripcion" required />
            </p>

            <p>
                Hora: <input type="text" id="hora" name="hora" required />
            </p>



            <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
    </body>
</html>