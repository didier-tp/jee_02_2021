package tp.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean //ManagedBean de JSF
@RequestScoped //ou SessionScoped
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
    
	public TvaMBean() {
		super();
	}
	
	public Double getHt() {
		return ht;
	}
	public void setHt(Double ht) {
		this.ht = ht;
	}
	public Double getTauxTva() {
		return tauxTva;
	}
	public void setTauxTva(Double tauxTva) {
		this.tauxTva = tauxTva;
	}
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public Double getTtc() {
		return ttc;
	}
	public void setTtc(Double ttc) {
		this.ttc = ttc;
	}
    
    
}
