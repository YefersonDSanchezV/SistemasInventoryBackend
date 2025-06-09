# Usar una imagen base de Java
FROM eclipse-temurin:17-jdk-alpine

# Crear un directorio para la app
WORKDIR /app

# Copiar el JAR al contenedor
COPY target/Inventario-Backend-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto (ajusta si es diferente)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
