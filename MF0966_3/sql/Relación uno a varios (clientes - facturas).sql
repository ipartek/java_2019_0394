USE ejemplos;

SELECT f.numero_factura, c.nombre
FROM facturas f, clientes c
WHERE f.idcliente = c.id 
AND numero_factura='2019/0002';

SELECT f.numero_factura, c.nombre
FROM facturas f
INNER JOIN clientes c ON f.idcliente = c.id
WHERE numero_factura='2019/0002';