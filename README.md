# API CRUD Tópicos
---
## Descripción
Este proyecto **tiene como objetivo desarrollar una API CRUD básica**.
Esta aplicación crea e interactua con una base de datos donde se almacenan Topicos.
La misma se construyó siguiendo el **[siguiente challange](https://trello.com/b/ktPAjiBN/challenge-spring-boot)**.
---
## Endpoints Disponibles
- `POST /topico`: Registra un Topico en la base de datos.
- `GET /topicos`: Obtiene un registro de todos los Topicos almacenados.
- `GET /topico/{id}`: Obtiene un Topico mediante su Long id.
- `PUT /topico/{id}`: Actualiza un topico existente.
- `DELETE /topico/{id}`: Elimina un topico existente mediante su Long id.
---
## Características Principales

- **Desarrollo Rápido**: Utiliza Docker y Docker Compose para simplificar el entorno de desarrollo y despliegue.
- **Arquitectura Modular**: La aplicación se divide en servicios independientes para una fácil mantenibilidad y escalabilidad.
- **Interfaz de Administración**: Incluye PhpMyAdmin para gestionar la base de datos MySQL de forma intuitiva.
- **Configuración Versátil**: Las variables de entorno permiten una configuración personalizada para diferentes entornos.
---
## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado en tu sistema:

- Docker
- Docker Compose

---

## Instrucciones de Uso

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/francoleon08/apitopicos.git

2. Navega al directorio del proyecto:

   ```bash
   cd apitopicos/

3. Ejecuta el siguiente comando para iniciar los servicios:

   ```bash
   docker-compose up -d

4. Accede a la aplicación desde tu navegador web:
- Aplicación: http://localhost:8080
- PhpMyAdmin: http://localhost:8000
  - Usuario: root (sin contraseña)
