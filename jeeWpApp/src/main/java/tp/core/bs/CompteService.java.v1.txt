package tp.core.bs;

import java.util.List;

import javax.ejb.Local;
import javax.jws.WebParam;
import javax.jws.WebService;

import tp.core.entity.Compte;

//@WebService et @WebParam utiles si l'EJB est vu de l'exterieur 
//comme un WEB Service SOAP (XML)

@WebService() //visible comme un WEB Service SOAP (depuis une appli externe)
@Local  //EJB utilisable localement depuis même JVM (ex: MBean JSF)
public interface CompteService {
	public Compte rechercherCompteSelonNum(@WebParam(name="numero")Long numero);
	public List<Compte> rechercherTousLesComptes();
	public List<Compte> rechercherComptesDuClient(@WebParam(name="numeroClient")Long numeroClient);
	
	public void effectuerVirement(@WebParam(name="montant")double montant,
			                      @WebParam(name="numCptDeb")long numCptDeb,
			                      @WebParam(name="numCptCred")long numCptCred);
	//....
}
