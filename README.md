SgaWs Cliente para Java
=======================

Cliente Java para los Web Services del "Sistema de Gestión Académica" de la "Universidad Nacional de Loja".

Este es un cliente sumamente simple en donde nosotros mismo tenenmos que ir agregando los métodos del web service que necesitemos.

Usa llamadas HttpGet y luego las decodifica con json, para lo cual usa las siguientes librerías:
- httpcomponents-client-4.3.4 (Librería para tratar las peticiones http)
  http://hc.apache.org/downloads.cgi

- json-simple-1.1.1.jar (JSON)
  https://json-simple.googlecode.com/files/json-simple-1.1.1.jar

Ejecución
=========
- En la clase TestWs fijar las credenciales del web service:
  SgaWs.setCredentials("poner_nombre_usuario", "poner_clave_usuario");

- Ejecutar la clase TestWs que tiene un método main de prueba
