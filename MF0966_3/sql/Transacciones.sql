START TRANSACTION;
INSERT INTO clientes (nombre) VALUES ('uno');
INSERT INTO clientes (nombre) VALUES ('dos');
DELETE FROM clientes WHERE id > 10;
SELECT * FROM clientes;
ROLLBACK;
COMMIT;
