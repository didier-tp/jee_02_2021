set JAVA_HOME=C:\Program Files\Java\java-se-8u41-ri
set PATH=%JAVA_HOME%\bin;%PATH%
mvn clean package > resBuild.txt 2>&1
pause