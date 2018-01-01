-- phpMyAdmin SQL Dump
-- version 3.5.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Versión del servidor: 5.5.28-log
-- Versión de PHP: 5.4.9
-- Autor: Daniel Mendoza Caro

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `modulo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `rutcliente` varchar(10) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `apellido` varchar(30) DEFAULT NULL,
  `razón_soc` varchar(30) DEFAULT NULL,
  `tipo_client` varchar(30) DEFAULT NULL,
  `giro_comercial` varchar(50) DEFAULT NULL,
  `ciudad` varchar(30) DEFAULT NULL,
  `comuna` varchar(30) DEFAULT NULL,
  `domicilio_comercial` varchar(50) DEFAULT NULL,
  `fax` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`rutcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`rutcliente`, `nombre`, `apellido`, `razón_soc`, `tipo_client`, `giro_comercial`, `ciudad`, `comuna`, `domicilio_comercial`, `fax`, `telefono`, `correo`) VALUES
('11318833-2', 'Bastian', 'Gatica', 'Empresa N9', 'Persona natural', 'Juegos virtuales', 'Santiago', 'Padre Hurtado', 'Calle nueve #4489', 2426304, 72973773, 'bastian15@hotmail.com'),
('14123521-1', 'Danilo', 'Larrain', 'Empresa N7', 'Persona natural', 'Aplicaciones', 'Santiago', 'Las condes', 'Calle siete #5678', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('14311245-0', 'Sebastian', 'Mendez', 'Empresa N6', 'Persona natural', 'Teclados', 'Santiago', 'La Reina', 'Calle seis #1566', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('14673346-2', 'Franco', 'Lopez', 'Empresa N3', 'Persona natural', 'Flores', 'Santiago', 'Puente Alto', 'Calle uno #3220', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('15688434-1', 'Bastian', 'Castillo', 'Empresa N2', 'Persona natural', 'Juguetes', 'Santiago', 'Maipu', 'Psj. Argentina #1452', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('16098383-1', 'Mauricio', 'Vazquez', 'Empresa N4', 'Persona natural', 'Comida', 'Santiago', 'Huechuraba', 'Calle tres #2340', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('17895434-2', 'Paul', 'Gonzales', 'Empresa N5', 'Persona natural', 'Muebles', 'Santiago', 'La granja', 'Calle cuatro #5454', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('18882070-0', 'Daniel', 'Mendoza', 'Empresa N1', 'Persona natural', 'Computadores', 'Santiago', 'San Ramon', 'Sgt. Candelaria #1875', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com'),
('19874612-2', 'Eduardo', 'Klagges', 'Empresa N8', 'Persona natural', 'Computadores', 'Santiago', 'La pintana', 'Calle ocho #4889', 2426304, 72973773, 'daniel.mendoza.caro2@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deposito`
--

CREATE TABLE IF NOT EXISTS `deposito` (
  `FECHAPAGO` varchar(10) DEFAULT NULL,
  `COD_FACTURA` int(11) DEFAULT NULL,
  `NOMBRETITULAR` varchar(30) DEFAULT NULL,
  `NUMEROORIGEN` int(11) DEFAULT NULL,
  `NUMERODESTINO` int(11) DEFAULT NULL,
  `MONTO` int(11) DEFAULT NULL,
  `TIPO` varchar(30) DEFAULT NULL,
  `BANCO` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `deposito`
--

INSERT INTO `deposito` (`FECHAPAGO`, `COD_FACTURA`, `NOMBRETITULAR`, `NUMEROORIGEN`, `NUMERODESTINO`, `MONTO`, `TIPO`, `BANCO`) VALUES
('2016/11/27', 1, 'Bastian Castillo', 890890890, 123123123, 23000, 'Vale vista', 'Banco Estado'),
('2016/11/27', 2, 'Franco Lopez', 234234234, 123123123, 24000, 'Vale vista', 'Banco Santander'),
('2016-11-27', 6, 'Sebastian Lopez', 456456456, 123123123, 11900, 'Documento mismo banco', 'Banco De Chile'),
('2016-11-28', 8, 'Stefania Jara', 908908908, 123123123, 289170, 'Vale vista', 'Banco Estado'),
('2016-11-29', 10, 'DANIEL', 567567567, 123123123, 37128, 'Vale vista', 'Banco Santander');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas_emitidas`
--

CREATE TABLE IF NOT EXISTS `facturas_emitidas` (
  `COD_FACTURA` int(11) NOT NULL,
  `RUTCLIENTE` varchar(12) DEFAULT NULL,
  `FECHAEMISION` date DEFAULT NULL,
  `MONTO` float DEFAULT NULL,
  `ESTADO` int(11) DEFAULT NULL,
  PRIMARY KEY (`COD_FACTURA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturas_emitidas`
--

INSERT INTO `facturas_emitidas` (`COD_FACTURA`, `RUTCLIENTE`, `FECHAEMISION`, `MONTO`, `ESTADO`) VALUES
(1, '15688434-1', '2016-11-24', 23000, 1),
(2, '14673346-2', '2016-11-25', 24000, 1),
(3, '16098383-1', '2016-11-25', 25000, 0),
(4, '17895434-2', '2016-11-26', 26000, 2),
(5, '14311245-0', '2016-11-26', 27000, 2),
(6, '14311245-0', '2016-11-27', 11900, 1),
(7, '11318833-2', '2016-11-28', 24990, 0),
(8, '17895434-2', '2016-11-28', 289170, 1),
(9, '14123521-1', '2016-11-28', 385203, 0),
(10, '19874612-2', '2016-11-29', 37128, 1),
(11, '18882070-0', '2016-11-29', 42840, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE IF NOT EXISTS `servicios` (
  `CODIGO` int(11) NOT NULL,
  `DESCRIPCION` varchar(40) DEFAULT NULL,
  `VALOR_HORA` int(11) DEFAULT NULL,
  `TIPO` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`CODIGO`, `DESCRIPCION`, `VALOR_HORA`, `TIPO`) VALUES
(1001, 'Conserje', 1800, 'OFICIO'),
(1002, 'Repartidor / Mensajero', 1040, 'OFICIO'),
(1003, 'Garzon', 1500, 'OFICIO'),
(2001, 'Tec. Gastronomico', 1980, 'TECNICO'),
(2002, 'Tec. en publicidad', 1950, 'TECNICO'),
(2003, 'Diseñador grafico', 2000, 'TECNICO'),
(3001, 'Abogado', 5600, 'PROFESIONAL'),
(3002, 'Arquitecto', 4300, 'PROFESIONAL'),
(3003, 'Ing. electrico', 6500, 'PROFESIONAL');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `USUARIO` varchar(10) DEFAULT NULL,
  `CONTRASEÑA` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`USUARIO`, `CONTRASEÑA`) VALUES
('Daniel', '12345');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
