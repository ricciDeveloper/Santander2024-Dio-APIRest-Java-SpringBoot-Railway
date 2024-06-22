# Base image
FROM openjdk:17-jdk-slim

# Define um diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo JAR produzido pelo Maven para o diretório de trabalho
COPY santanderAPIRest/target/santanderAPIRest-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta em que sua aplicação estará rodando
EXPOSE 30436

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
