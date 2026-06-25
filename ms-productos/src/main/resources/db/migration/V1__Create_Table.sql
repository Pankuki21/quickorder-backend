CREATE TABLE producto(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100)   NOT NULL,
    descripcion VARCHAR(150)   NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(80)    NOT NULL
);