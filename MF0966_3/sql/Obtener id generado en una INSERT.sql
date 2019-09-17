INSERT INTO clientes (nombre) VALUES ('dafgsdfg');
SELECT * FROM clientes WHERE id = LAST_INSERT_ID();
