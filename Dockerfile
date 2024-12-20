# Imagen base
FROM openjdk:21-jdk-slim

# Instalamos git y maven
RUN apt-get update && apt-get install -y git maven


# Clonamos el repositorio desde GitHub
RUN git clone https://github.com/RodolfoQQ/horariobackentSpring.git

# Cambiamos al directorio del proyecto clonado
WORKDIR /horariobackentSpring

# Construimos el proyecto con Maven
RUN mvn clean package -DskipTests

EXPOSE 8080
# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "target/horario-0.0.1-SNAPSHOT.jar"]