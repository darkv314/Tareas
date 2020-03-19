use bookstore;
-- Primer ejercicio Curso 4
select usuario.usuario, empleado.nombre from usuario inner join empleado on usuario.idempleado=empleado.idempleado; 
-- Segundo ejercicio Curso 4
select email from empleado where idempleado in(select idempleado from usuario where activo=1);
-- Tercer ejercicio Curso 4
select count(autor) from publicacion where publicacion.autor = 'Eric G. Coronel Castillo';
-- Cuarto ejercicio Curso 4
select sum(precio) from venta where idempleado in( select idempleado from empleado where nombre="EMILIO");