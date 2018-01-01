<%-- 
    Document   : entrada
    Created on : 26-11-2016, 08:19:02 PM
    Author     : Daniel
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>Depositos</title>
    <link href="css/secoper.css" rel="stylesheet" type="text/css">
</head>

<body>
    <div id="principal">
        <div id="Banner"><h1>&nbsp;</h1></div>
            <div id="Menu">
            <ul>
            <li><a href="home.htm">Home</a>
            <li><a href="entrada.htm">Pagos Clientes</a>
            </ul>
        </div>
        
    <div id="Cuerpo">
    <center>
    <form:form method="post" commandName="fact">
        Numero factura:
        <form:input path="cod_factura" class="textbox" placeholder="Omite los 0 dentro de tu factura"/>
        <input type="submit" value="enviar"/>
    </form:form>
</center>
</div>
        
<div id="Pie">Secoper LTDA.</div>
</div>

</body>
</html>