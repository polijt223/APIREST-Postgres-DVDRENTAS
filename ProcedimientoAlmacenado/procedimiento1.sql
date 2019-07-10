--Funcion o Procedimiento Almacenado


create or replace function getCantidadUsuariosPorPais (paisVar varchar) returns bigint 
as
$$
select count(cus.active) as "Cantidad Clientes"
from  
customer cus 
join address adr
	on(cus.address_id = adr.address_id)
join city ci
	on(adr.city_id=ci.city_id)
join country co
	on(ci.country_id = co.country_id)
group by co.country 
having co.country=paisVar;
$$
Language SQL

select getCantidadUsuariosPorPais('Argentina');






