✅ README.md
# 📦 Inventario Backend

Este proyecto es un sistema backend desarrollado en **Java Spring Boot**, diseñado para gestionar el inventario de equipos tecnológicos de una organización. Incluye el manejo de empleados, usuarios, roles, componentes, asignación de equipos y generación de reportes.

---

## 🚀 Funcionalidad del Proyecto

El sistema permite:
- 📋 Registrar, editar y consultar información de equipos como computadoras, teléfonos, cámaras, impresoras y celulares.
- 👤 Administrar usuarios, empleados y roles.
- 🔄 Asignar equipos a empleados con historial de auditoría.
- 📊 Generar reportes exportables en PDF o Excel.

---

## 🐳 Despliegue con Docker

### 🔧 Requisitos

- Docker y Docker Compose instalados
- Una red Docker llamada `red_icvc` ya creada y usada por el contenedor de PostgreSQL existente

### 🛠️ Configuración

El backend se conectará al contenedor de PostgreSQL a través de la red `red_icvc`. Asegúrate de conocer el **nombre del contenedor PostgreSQL** (por ejemplo, `postgres-icvc`).

### 📁 Estructura mínima esperada

Inventario-Backend/

├── Dockerfile

├── docker-compose.yml

├── src/

├── target/

│ └── inventario-backend-0.0.1-SNAPSHOT.jar

└── application.yml


---

## ⚙️ Despliegue paso a paso

### 1. 🔨 Compilar el proyecto

Si estás en Linux o Mac:
./mvnw clean package

En Windows:
mvnw.cmd clean package
Esto generará el archivo .jar en la carpeta target/.

### 2. 🐳 Crear red compartida (solo una vez)
docker network create red_icvc
Solo si no existe. Verifica con: docker network ls

### 3. ✏️ Editar docker-compose.yml
Asegúrate de que el archivo tenga la red y nombre del contenedor PostgreSQL correcto:

services:

  backend:
  
    build:
    
      context: .
      
      dockerfile: Dockerfile
      
    container_name: spring-backend
    
    environment:
    
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres-icvc:5432/inventario_db
      
      SPRING_DATASOURCE_USERNAME: admin
      
      SPRING_DATASOURCE_PASSWORD: admin123
      
    ports:
    
      - "8080:8080"
      
    networks:
    
      - red_icvc
      

networks:

  red_icvc:
  
    external: true
    
    
### 4. ▶️ Desplegar el backend
docker compose up --build
Esto construirá la imagen del backend y la levantará en el puerto 8080.

### 🌐 Acceder a la API
Por defecto, la API estará disponible en:
http://localhost:8080
Puedes probar los endpoints con herramientas como Postman o conectarlo directamente al frontend Angular del proyecto.

### 📄 Licencia
Este proyecto es parte del desarrollo académico de un sistema de gestión de inventario. Su uso y distribución puede estar sujeto a condiciones institucionales.
