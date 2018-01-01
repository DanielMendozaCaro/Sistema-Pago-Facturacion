<%-- 
    Document   : pagos
    Created on : 13-11-2016, 05:59:05 PM
    Author     : Daniel Mendoza 
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form method="post" commandName="depo">
    <table>
        <tr>
            <td colspan="2"><h1>Formulario de deposito</h1></td>
        </tr>
    
        <tr>
            <td>Nombre titular:</td>
            <td><form:input path="nombreTitular" class="textbox"/></td>
            <td><form:errors path="nombreTitular" /></td>
        </tr>

        <tr>
            <td>Numero cuenta:</td>
           <td><form:input path="numeroCuentaOrigen" class="textbox"/></td>
           <td><form:errors path="numeroCuentaOrigen" /></td>
        </tr>

        <tr>
            <td>Tipo deposito:</td>
            <td><form:select path="tipoDeposito">
                    <form:option value="Documento mismo banco">Documento mismo banco</form:option>
                    <form:option value="Documento mismo banco">Documento otro banco</form:option>
                    <form:option value="Vale vista">Vale vista</form:option>
                </form:select></td>
            <td><form:errors path="tipoDeposito" /></td>
        </tr>
        
        <tr>
            <td>Entidad bancaria:</td>
            <td><form:input path="entidadBancaria" class="textbox"/></td>
            <td><form:errors path="entidadBancaria" /></td>
        </tr>

        <tr>
            <td colspan="2"><center><input type="submit" value="Enviar" class="boton"/></center></td>
        </tr>
    </table>
</form:form>
</center>
</div>
        
<div id="Pie">Secoper LTDA.</div>
</div>

</body>
</html>