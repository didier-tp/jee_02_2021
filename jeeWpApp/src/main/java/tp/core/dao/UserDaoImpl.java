package tp.core.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tp.core.entity.User;



//EJB session sans état
//@Stateless //Ejb 3 et EJB 3.1 , 3.2
@Singleton //variante de @Stateless depuis EJB 3.1
//@TransactionManagement(TransactionManagementType.CONTAINER) par défaut
//transactions gérées automatiquement par le contenueur d'EJB (partie de Jboss)
//@TransactionAttribute(TransactionAttributeType.REQUIRED) par défaut
//REQUIRED signifie besoin de .beginTransaction() et .commit()/.rollback()
public class UserDaoImpl implements UserDao {
	@PersistenceContext //pour initialiser le entityManager
	                    //en fonction META-INF/persistence.xml
	EntityManager entityManager;
	
	public User insertUser(User user) {
		entityManager.persist(user);//insert into SQL
		                            //et si @GeneratedValue , le id est
		                            //modifié en mémoire (auto_incr)
		return user;
	}
	
	public void updateUser(User user) {
		
		 entityManager.merge(user);
		 
		/*
		try {
			entityManager.getTransaction().begin();
			  entityManager.merge(user);
			 entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			 entityManager.getTransaction().rollback();
		}
		*/
	}
	
	public void deleteUser(Integer userId) {
		User user = entityManager.find(User.class,userId);
		entityManager.remove(user);
	}
	public User getUserById(Integer userId) {
		return entityManager.find(User.class,userId);
	}
	public List<User> getAllUsers() {
		return entityManager.createQuery("SELECT u FROM User u", User.class)
			                .getResultList();
	}
}
