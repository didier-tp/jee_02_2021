package tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean //ManagedBean de JSF
@RequestScoped //ou SessionScoped
@Getter @Setter @NoArgsConstructor
public class TvaMBean {
    private Double ht; //à saisir 
    private Double tauxTva; //à saisir ou choisir
    
    private Double tva; //à calculer et afficher
    private Double ttc;//à calculer et afficher
    
    public String calculerTva() {
    	String suite=null;
    	
    	this.tva = this.ht * this.tauxTva / 100;
    	this.ttc = this.ht + this.tva;
    	
    	return suite; //influencer la navigation
    	//si on retourne suite==null , on reste sur la meme page
    	//pour afficher le résultat
    }
    
	
    
    
}
