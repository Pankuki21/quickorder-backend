CREATE TABLE inventario (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    producto_id BIGINT NOT NULL,
    stock INT NOT NULL,
    ubicacion VARCHAR(100) NOT NULL
);