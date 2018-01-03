package library.data;

import java.util.List;

import library.model.User;

public interface UserDAO {
	
	public void insertUser(User newUser);
	public void deleteUser(int id);
	public User findUserById(int id);
	public List<User> findAllUsers();
	public List<User> findUsersByFirstName(String firstName);
	public List<User> findUsersByLastName(String lastName);
	public User findUserByEmail(String email);
	public void updateUserEmail(int id, String newEmail);
	public void updateUserLastName(int id, String lastName);
	
	

}
