# 🐾 PetStore API Test Automation

Este proyecto contiene la automatización de pruebas para la API de PetStore utilizando **Java**, **Rest-Assured**, **TestNG** y **Maven**.

## 📌 Objetivo

Automatizar 6 funcionalidades clave expuestas por la API pública de PetStore:

1. Crear un usuario.
2. Hacer login con el usuario recién creado.
3. Listar todas las mascotas con status "available".
4. Consultar los datos de una mascota en específico.
5. Crear una orden de compra para una mascota.
6. Hacer logout de la aplicación.

### 1. Clonar el repositorio

```bash
git clone https://github.com/tu_usuario/petstore-tests.git
cd petstore-tests
```

### 2. Ejecutar con Maven

```bash
mvn clean test
```

### 3. Ejecutar con archivo testing.xml (opcional)

```bash
mvn test -DsuiteXmlFile=src/test/resources/testing.xml
```

## 🧹 Notas
- Todos los tests son independientes y no requieren ejecución en orden.
- .log().ifValidationFails() se utiliza para mantener limpio el log y facilitar la depuración.
