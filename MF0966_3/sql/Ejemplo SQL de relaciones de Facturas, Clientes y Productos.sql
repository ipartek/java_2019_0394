SELECT c.nif, c.nombre 'nombre cliente', f.numero 'numero factura', f.fecha 'fecha factura', p.nombre 'nombre producto', p.precio 'precio producto'
FROM clientes c
INNER JOIN facturas f ON c.id = f.clientes_id
INNER JOIN facturas_has_productos fp ON f.id = fp.facturas_id
INNER JOIN productos p ON fp.productos_id = p.id
WHERE c.nombre LIKE 'Javier%';
