<%-- 
    Author     : Daniel Mendoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>Deposito</title>
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
        <h1>Detalle de la factura</h1>
        <table id='rounded-corner'>
            <tr>
            <th>Campo</th>
            <th>Valor</th>
            </tr>
            <tr>
                <td>Numero factura</td>
                <td><c:out value="${datos.cod_factura}"/></td>
            </tr>
            <tr>
                <td>Rut cliente</td>
                <td><c:out value="${datos.rutcliente}"/></td>
            </tr>
            <tr>
                <td>Fecha emision</td>
                <td><c:out value="${datos.fechaemision}"/></td>
            </tr>
            <tr>
                <td>Monto</td>
                <td><c:out value="${datos.monto}"/></td>
            </tr>
        </table>
        <br>
            <h3>¿Es esta tu factura?</h3>
            
                    <button type="button" onclick="location='pago.htm'">Si</button>
                     
                    <button type="button" onclick="location='entrada.htm'">No</button>
                
</center>
</div>
        
<div id="Pie">Secoper LTDA.</div>
</div>

</body>
</html>