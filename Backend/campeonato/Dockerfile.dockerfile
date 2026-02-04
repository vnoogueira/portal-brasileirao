# Etapa 1: build da aplicação
FROM eclipse-temurin:21 AS builder

WORKDIR /app

# Copia os arquivos para o container
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -B

COPY src ./src
RUN ./mvnw clean package -DskipTests

# Etapa 2: imagem final, apenas com o JAR
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia o jar gerado da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
