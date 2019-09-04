USE libreria;

SELECT id, titulo, descripcion, autor, imagen, precio, descuento
FROM libros;

INSERT INTO libros (titulo, autor, precio, descuento) 
VALUES ('El libro pequeño de petete', 'Pepe', 12.3, 2.2);

SELECT * FROM libros WHERE autor='Pepe';

UPDATE libros 
SET descripcion='Descripción pequeñita', imagen='libro3.png' 
WHERE autor='Pepe';

SELECT * FROM libros;

DELETE FROM libros WHERE autor='Pepe';

SELECT * FROM libros;
