# p12JavaVegetAble
Projet 12 Parcours Développeur Java (API REST)

# DESCRIPTION
Application de gestion de dons de Fruits et Légumes entre particuliers

# ENVIRONNEMENT
* JavaEE 8  
* PostgreSQL  
* Maven
* Spring Boot
* Spring Web
* Spring Security
* Spring Data Jpa
* Spring MVC
* OpenFeign
* Bootstrap  

Optimisé pour TOMCAT 9.0

# CLONAGE DES COMPOSANTS DU PROJET
Pour cloner les composants du projet : 
	* https://github.com/emplms/p12VegetAble.git
	
# DEPLOIEMENT
##### BDD (postgresql)
1- Télécharger PostgreSQL  
2- Executer les scripts sql (dossier p12JavaVegetAble/p12-JavaVegetAbleAPI/src/main/ressources/doc)

##### paramètres de connection à la Base de Données
Le user et le mot de passe de connection à la base de données par défaut sont renseignés dans le fichier application.properties  
Pour les modifier, le chemin d'accès au fichier dans le projet est :  
		p12JavaVegetAble/p12-JavaVegetAbleAPI/src/main/resources/application.properties

##### Lancement de l'API	
1- Récupérer le fichier jar : dans le repository qui accueille le clone, saisir  la commande mvn install  
2- Dans le dossier target, saisir la commande :    java -jar p12-JavaVegetAbleAPI-1.0.0-Snapshot.jar 
l'API utilise le port 9001

##### Lancement de l'appliweb
1- Récupérer le fichier jar : dans le repository qui accueille le clone, saisir  la commande mvn install  
2- Dans le dossier target, saisir la commande :    java -jar  p12-JavaVegetAbleWEB-1.0.0-Snapshot.jar
3- url de la page d'accueil :http://localhost:8080/


# VERSION
1.0.0-Snapshot

# AUTEUR
Emmanuel PLUMAS - Juillet 2021
