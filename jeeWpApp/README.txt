Attention : si l'application à déployer dans le serveur jboss 
a besoin de se connecter à une base de données (mysql , postgres , oracle ou autre)
il faut préparer la base données nécessaire (ex: https://github.com/didier-tp/jee_02_2021/config_jboss_wildfly/config_database )
et il faut également configurer un driver et un datasource au sein de JBOSS
Mode opératoire :
https://github.com/didier-tp/jee_02_2021/config_jboss_wildfly/
   Configuration_Serveur_JBoss_wildfly.txt et fichiers annexes

==================================
Utilisation de jboss sans eclipse:

set JAVA_HOME=.../jdk11
exemple : C:\Program Files\Java\jdk-11.0.4

set PATH=....;C:\Program Files\Java\jdk-11.0.4/bin

recopier jeeWpApp/target/jeeWpApp.war   wildfly.../standalone/deployements
lancer wildfly.../bin/standalone.bat ou .sh

http://localhost:8080
http://localhost:8080/jeeWpApp
http://localhost:8080/jeeWpApp/index.html


===================
Avec plugin jboss pour eclipse:

1) Très longue installation du plugin "jboss pour eclipse":
Menu Windows/Preferences
et Server / Runtime Environment
new Red Hat JBoss Middleware/ JBoss AS, Wildfly & EAP Server Tools
patentier ... , patentier , choisir "JBoss ..."
Accepter licence ... et Finish --> démarrage de l'installation du plugin en tâche de fond ...
Apply & Close ; 
Encore patentier ... , patentier ... (installing JBoss ... Tools , 7% , 12 % , ...)
Réponde "install anyway" si manque signature sur une partie du plugin.
Redémarrer eclipse si nécessaire .

2) Configuration (ENFIN!!!) du plugin "jboss pour eclipse":
Relancer une nouvelle fois le menu Windows/Preferences
et Server / Runtime Environment
- new JBoss Community/Wilfly_21_ou_autre
- Sélectionner le répertoire ou Jboss_wildfly a été téléchargé et dé-zippé 
(ex: C:\Prog\wildfly-21.0.2.Final)
Finish & Apply and close.

3) Déploiement et lancement d'une application JEE avec JBOSS:
- Se placer à la racine du projet maven (ayant jboss pour cible)
- Run as / Run on server.
- la première fois "manually define a new server" et choisir JBoss Community/Wilfly_21_ou_autre
- next et/ou finish
- regarder les messages qui s'affichent au sein de la console

Si le serveur arrive démarre bien , dans l'onglet "server" de jboss , on peut déclencher "stop" , "restart" , ...
