package tp.core.dao;

import java.util.List;

import javax.ejb.Local;

import tp.core.entity.User;



@Local
public interface UserDao {
	User insertUser(User user);
	void updateUser(User user);
	void deleteUser(Integer userId);
	User getUserById(Integer userId);
	List<User> getAllUsers();
	
}
