package tp.web.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
//partie du milieu des URLs après http://localhost:8080/jeeWpApp
//et avant les valeurs de @Path() des classes java
public class RestAppConfig extends Application{
	//rien (découverte automatique via un scan automatique 
	//des packages java de l'application)
}
