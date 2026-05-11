# QuickOrder 360 - Microservicios

## Microservicios
- ms-clientes(8081)
- ms-productos(8082)
- ms-inventario(8083)
- ms-pedidos(8084)
- ms-detalle-pedido(8085)
- ms-pagos(8086)
- ms-despachos(8087)
- ms-usuarios(8088)
- ms-reclamos8089)
- ms-notificaciones(8090)

## Base de datos
Cada microservicio posee su propia base de datos independiente:
- quickorder_clientes
- quickorder_productos
- quickorder_inventario
- quickorder_pedidos
- quickorder_detalle_pedido
- quickorder_pagos
- quickorder_despachos
- quickorder_usuarios
- quickorder_reclamos
- quickorder_notificaciones

## Cómo ejecutar
1. Crear bases de datos MySQL
2. Levantar cada microservicio individualmente
3. Verificar puertos

## Arquitectura
Comunicación entre microservicios vía REST