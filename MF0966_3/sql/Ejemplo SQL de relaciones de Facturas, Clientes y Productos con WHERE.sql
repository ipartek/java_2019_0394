SELECT c.nif, c.nombre 'nombre cliente', f.numero 'numero factura', f.fecha 'fecha factura', p.nombre 'nombre producto', p.precio 'precio producto'
FROM clientes c, facturas f, facturas_has_productos fp, productos p
WHERE 
	c.id = f.clientes_id AND
	f.id = fp.facturas_id AND
	fp.productos_id = p.id AND

	c.nombre LIKE 'Javier%';
