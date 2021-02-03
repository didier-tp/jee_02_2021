package tp.core.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.PersistenceContext;

import tp.core.entity.Compte;

@Singleton //ou @Stateless
public class CompteDaoImpl implements CompteDao {
	
	//@PersistenceContext() initialise entityManager
	//à partir de META-INF/persistence.xml
	@PersistenceContext()
	private EntityManager entityManager;

	@Override
	public Compte findById(Long numero) {
		return entityManager.find(Compte.class, numero);
	}

	@Override
	public List<Compte> findAll() {
		/*return entityManager
				.createQuery("SELECT c FROM Compte c",Compte.class)
				.getResultList();*/
		return entityManager
				.createNamedQuery("Compte.findAll",Compte.class)
				.getResultList();	
		// un peu plus performant , car requête connue et préparée par Mysql ou ...
	}

	@Override
	public List<Compte> findByNumClient(Long numClient) {
		return entityManager
				.createQuery("SELECT c FROM Compte c JOIN c.client cli WHERE cli.numClient = :numCli",Compte.class)
				.setParameter("numCli", numClient)
				.getResultList();  //à compléter plus tard avec JOIN et la classe Client
		
	}

	@Override
	public Compte save(Compte cpt) {
		if(cpt.getNumero()==null)
			entityManager.persist(cpt); //INSERT INTO , auto_incr du numero
		else
			entityManager.merge(cpt); //UPDATE
		return cpt; //avec numero qui n'est normalement pas null
	}

	@Override
	public void deleteById(Long numero) {
		Compte cpt = entityManager.find(Compte.class, numero);
		entityManager.remove(cpt);
	}

}
