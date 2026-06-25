# QuickOrder Backend

## Integrante

* Francisca Acosta

## Microservicios implementados

* Eureka Server
* API Gateway
* ms-clientes
* ms-productos
* ms-inventario
* ms-pedidos
* ms-detalle-pedido
* ms-pagos
* ms-despachos
* ms-usuarios
* ms-reclamos
* ms-notificaciones

## Rutas principales del API Gateway

| Ruta               | Microservicio     |
| ------------------ | ----------------- |
| /clientes/**       | ms-clientes       |
| /productos/**      | ms-productos      |
| /inventario/**     | ms-inventario     |
| /pedidos/**        | ms-pedidos        |
| /detalle-pedido/** | ms-detalle-pedido |
| /pagos/**          | ms-pagos          |
| /despachos/**      | ms-despachos      |
| /usuarios/**       | ms-usuarios       |
| /reclamos/**       | ms-reclamos       |
| /notificaciones/** | ms-notificaciones |

## Documentación Swagger

Cada microservicio dispone de documentación Swagger.

Ejemplos:

* http://localhost:8081/swagger-ui/index.html
* http://localhost:8082/swagger-ui/index.html
* http://localhost:8083/swagger-ui/index.html
* http://localhost:8084/swagger-ui/index.html
* http://localhost:8085/swagger-ui/index.html
* http://localhost:8086/swagger-ui/index.html
* http://localhost:8087/swagger-ui/index.html
* http://localhost:8088/swagger-ui/index.html
* http://localhost:8089/swagger-ui/index.html
* http://localhost:8090/swagger-ui/index.html

## Ejecución local

1. Crear las bases de datos MySQL.
2. Ejecutar Eureka Server.
3. Ejecutar API Gateway.
4. Ejecutar los microservicios.
5. Acceder a los endpoints mediante el Gateway o directamente por el puerto de cada microservicio.

## Ejecución con Docker

Desde la carpeta principal del proyecto ejecutar:

```bash
docker compose up --build
```