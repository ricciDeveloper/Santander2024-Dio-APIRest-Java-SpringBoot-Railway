# Base image
FROM openjdk:17-jdk-slim

# Define um diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR produzido pelo Maven
COPY target/santanderAPIRest-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta em que sua aplicação estará rodando
EXPOSE 8080

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
