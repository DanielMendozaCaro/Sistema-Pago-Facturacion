<%-- 
    Document   : home
    Created on : 19-11-2016, 09:50:48 PM
    Author     : Daniel Mendoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Inicio</title>
        <link href="<c:url value="/css/secoper.css" />" rel="stylesheet">
              
        
    </head>
    <body>
        <div id="principal">

            <div id="Banner"></div>
                <div id="Menu">
                <ul>
                <li><a href="home.htm">Home</a>
                <li><a href="entrada.htm">Pagos Clientes</a>

                </ul>
                </div>
            <div id="Cuerpo">
            <center>
            <h1>BIENVENIDOS A SECOPER</h1>
         <%--       <h2>Ingresar al formulario de factura</h2>    

                              <td><button type="button" onclick="location='capa_local.jsp'">Ingresar</button></td>
              		
			--%>
            </center>
            </div>
        <div id="Pie">Secoper LTDA.</div>
        </div>
</body>
</html>