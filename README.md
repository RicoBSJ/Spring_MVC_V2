# Développez le nouveau Système d’Information de la bibliothèque d’une grande ville, Projet 7, dans le cadre de la formation DA JAVA JEE OPENCLASSROOMS
# Le Projet 7 a été scindé en 3 sous-projets
# Ce sous-projet représente le front-end de l'application, développé à partir de Spring MVC

## Contexte

    Vous travaillez au sein de la Direction du Système d’Information (DSI) de la mairie d’une grande ville, sous la direction de Patricia, la responsable du service. 
    La DSI est en charge de tous les traitements numériques pour la mairie et les structures qui lui sont rattachées, comme la gestion du site web de la ville par exemple. 
    À ce titre, Patricia est contactée par le service culturel de la ville qui souhaite moderniser la gestion de ses bibliothèques. 
    John, architecte logiciel, sera chargé de la validation technique du projet.

    Nous souhaitons confier à la DSI la création d’un ensemble d’outils numériques pour les différents acteurs des bibliothèques de la ville. 
    Voici la liste des tâches qui me sont confiées :

    Développer UNE API Web : cette application permettra aux usagers de la bibliothèque d’avoir accès aux fonctionnalités suivantes :

    ⁃	S’enregistrer comme utilisateur ;
    ⁃	Se connecter à l’application en tant qu’utilisateur inscrit ;
    ⁃	Rechercher des ouvrages et voir le nombre d’exemplaires disponibles ;
    ⁃	De Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines ;
    ⁃	De Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

    Développer une Application web Batch  pour des traitements automatisés (mails de relance).

## Les fonctionnalités :

    F1 : Créer un utilisateur, via son email et un mot de passe;

    F2 : Loguer un utilisateur existant tout en faisant appel au token de Spring Security afin de garantir un accès sécurisé;

    F3 : Rechercher des ouvrages et voir le nombre d’exemplaires disponibles;

    F4 : Consulter leurs prêts en cours. Les prêts sont pour une période de 4 semaines;

    F5 : Prolonger un prêt en cours. Le prêt d’un ouvrage n’est prolongeable qu’une seule fois. La prolongation ajoute une nouvelle période de prêt (4 semaines) à la période initiale.

## Choix techniques retenus

	- Application web avec un framework MVC (Spring MVC, Struts, …)
	- Packaging avec Maven

	Pour l’application mobile et le logiciel des personnels, une autre réunion sera organisée.

	À noter : Dès la release 1.0, les actions de création d’un prêt et retour d’un prêt seront implémentés même si elles ne seront utilisées par le logiciel pour les personnels uniquement à la release 2.0.

## Spécificités

Les outils utilisés pour le développement

	Cette application a été développée avec :
	
	- IntelliJ IDEA 2021.1 (Ultimate Edition - Build #IU-211.6693.111, built on April 6, 2021)
	- Apache Maven 3.6.3
	- Java 8 (version 1.8 Update 251)
	- Hibernate ORM (version hibernate-release-6.1.6.Final)
	- Spring Boot version 2.4.2 (Tomcat version 9.0.43 embarqué)
	- Spring Security version 2.4.2
	- Spring MVC version 5.3.4
	- Bootstrap version 4.4.1

Les étapes de déploiement de l'application

	1/Vous devez au-préalable télécharger et installer :
	
	- Java sur https://www.java.com/fr/download/
	- Le JDK sur https://www.oracle.com/fr/java/technologies/javase/javase-jdk8-downloads.html
	- Apache Maven sur https://maven.apache.org/download.cgi (n'oubliez pas d'ajouter la variable d'environnement d'Apache au "Path")
	- Hibernate sur https://sourceforge.net/projects/hibernate/files/hibernate-validator/6.1.6.Final/hibernate-validator-6.1.6.Final-dist.zip/download

	2/Si vous ne l'avez pas déjà effectué, vous devez lancer pgAdmin4 :
	
	- Voici le chemin : /Library/PostgreSQL/12/
	- Dans la base de données, créez un utilisateur "postgres", attribuez lui le mot de passe "postgres"
	- Nul besoin de lancer un script de création de base de données car Hibernate se charge de le faire. 
	Ceci étant, vous trouverez un dump dans " PBiblio_Api_03_Script_SQL_Creation_Base_De_Donnees.sql " que vous trouverez dans le package
	- Pareillement pour le jeu de données, nul besoin d'exécuter le script car l'API contient un fichier " data.sql " se chargeant 
	de l'opération à son lancement. Ceci étant, vous trouverez ce fichier "PBiblio_Api_04_Script_SQL_Jeu_De_Donnees.sql"
	
	3/A partir de votre IDE, veuillez cloner le front-end à l'adresse suivante :
	
	- https://github.com/RicoBSJ/Spring_MVC_V2.git

Le lancement de l'application

	- Vous devez configurer le démarrage de l'application
	- Allez, en haut et à droite, dans " Add Configuration ", cliquez dessus
	- Une fenêtre s'ouvre intitulée " Run/Debug Configurations "
	- Cliquez sur le signe + situé en haut et à gauche
	- Sélectionnez " Tomcat Server Local "
	- Cliquez sur l'onglet " Deployment "
	- Cliquez sur le signe +
	- Cliquez sur " Artifact "
	- Cliquez sur " library-exposition:war exploded "
	- Cliquez sur OK
	- Vous pouvez à présent démarrée l'application
	- L'application démarrée, vous devez à présent cloner le sous-projet représentant le batch-end de l'application à l'adresse suivante : https://github.com/RicoBSJ/Spring_Batch.git

## Auteur

Rico BSJ