-- Crear esquema
CREATE SCHEMA IF NOT EXISTS franchise;

-- Usar el esquema
SET search_path TO franchise;

-- Crear tabla franquicia
CREATE TABLE IF NOT EXISTS franquicia (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  status INT NOT NULL
);

-- Crear tabla sucursal
CREATE TABLE IF NOT EXISTS sucursal (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  status INT NOT NULL,
  franquicia_id INT NOT NULL,
  CONSTRAINT fk_sucursal_franquicia FOREIGN KEY (franquicia_id)
    REFERENCES franquicia (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- Crear tabla producto
CREATE TABLE IF NOT EXISTS producto (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  status INT NOT NULL
);

-- Crear tabla sucursal_x_producto
CREATE TABLE IF NOT EXISTS sucursal_x_producto (
  sucursal_id INT NOT NULL,
  producto_id INT NOT NULL,
  stock INT NOT NULL,
  PRIMARY KEY (sucursal_id, producto_id),
  CONSTRAINT fk_sucursal_has_producto_sucursal FOREIGN KEY (sucursal_id)
    REFERENCES sucursal (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_sucursal_has_producto_producto FOREIGN KEY (producto_id)
    REFERENCES producto (id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

-- Crear índices para optimizar consultas
CREATE INDEX idx_sucursal_franquicia ON sucursal (franquicia_id);
CREATE INDEX idx_sucursal_x_producto_sucursal ON sucursal_x_producto (sucursal_id);
CREATE INDEX idx_sucursal_x_producto_producto ON sucursal_x_producto (producto_id);
