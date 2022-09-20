Attention:
Les versions récentes d'eclipse intègrent en interne le jdk 17
Ce jdk 17 peut rencontrer des problèmes avec de vielles versions
de lombok , de maven-compiler-plugin et de maven-war-plugin.

Versions compatibles:
maven-war-plugin en version 3.3.2
maven-compiler-plugin en version 3.10.1
lombok en version 1.18.24

<build>
<pluginManagement>
	      <plugins>
	        <plugin>
	          <groupId>org.apache.maven.plugins</groupId>
	          <artifactId>maven-compiler-plugin</artifactId>
	          <version>3.10.1</version>
	        </plugin>
	        <plugin>
	          <groupId>org.apache.maven.plugins</groupId>
	          <artifactId>maven-war-plugin</artifactId>
	          <version>3.3.2</version>
	        </plugin>
	      </plugins>
    </pluginManagement>
		

  </build>