# Étape 1 : Utiliser une image de base avec Maven et JDK
FROM maven:3.8.4-openjdk-11-slim AS build

# Étape 2 : Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Étape 3 : Copier le fichier pom.xml et télécharger les dépendances Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Étape 4 : Copier le reste des fichiers du projet
COPY src /app/src

# Étape 5 : Compiler le projet avec Maven
RUN mvn clean package -DskipTests

# Étape 6 : Utiliser une image JRE pour exécuter l'application
FROM openjdk:11-jre-slim

# Étape 7 : Copier le fichier JAR généré depuis l'étape précédente
COPY --from=build /app/target/mytva-1.0.0.jar /app/mytva.jar

# Étape 8 : Exposer le port sur lequel l'application va écouter (si nécessaire)
EXPOSE 8080

# Étape 9 : Définir la commande pour démarrer l'application
CMD ["java", "-jar", "/app/mytva.jar"]
