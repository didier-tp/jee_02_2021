set JAVA_HOME=.../jdk11
exemple : C:\Program Files\Java\jdk-11.0.4

set PATH=....;C:\Program Files\Java\jdk-11.0.4/bin

recopier jeeWpApp/target/jeeWpApp.war   wildfly.../standalone/deployements
lancer wildfly.../bin/standalone.bat ou .sh

http://localhost:8080
http://localhost:8080/jeeWpApp
http://localhost:8080/jeeWpApp/index.html