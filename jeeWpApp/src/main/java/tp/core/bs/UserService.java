package tp.core.bs;

import java.util.List;

import javax.ejb.Local;

import tp.core.entity.User;

//interface d'un service métier (business service) gérant les "User"


@Local //ejb accessible depuis partie web pris en charge par même serveur jboss
//@Inject (coté web) fonctionne mieux avec @Local (coté ejb)
public interface UserService {
	User createUser(User user);
	void modifyUser(User user);
	void removeUser(Integer userId);
	User findUserById(Integer userId);
	List<User> findAllUsers();
	//+ autres methodes ...
	//verifierXy()
	//grosTraitementUtilisantPlusieursDaoEnInterne()
}
