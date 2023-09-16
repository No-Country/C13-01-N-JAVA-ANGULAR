# Usa una imagen base de OpenJDK para Java 11
FROM openjdk:17

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR de tu aplicación Spring Boot al contenedor
COPY target/doctime-0.0.1-SNAPSHOT.jar doctime-0.0.1-SNAPSHOT.jar

# Expone el puerto en el que la aplicación Spring Boot escuchará las solicitudes (puerto por defecto de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "doctime-0.0.1-SNAPSHOT.jar"]