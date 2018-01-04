package library.data;

import java.util.List;

import library.model.User;

public interface UserDAO {
	
	public void insertUser(User newUser) throws AlreadyExsistsException;
	public void deleteUser(int id) throws UserNotFoundException;
	public User findUserById(int id) throws UserNotFoundException;
	public List<User> findAllUsers();
	public List<User> findUsersByFirstName(String firstName) throws UserNotFoundException;
	public List<User> findUsersByLastName(String lastName) throws UserNotFoundException;
	public User findUserByEmail(String email) throws UserNotFoundException;
	public void updateUserEmail(int id, String newEmail) throws UserNotFoundException;
	public void updateUserLastName(int id, String lastName)throws UserNotFoundException;
	public void updateUserPassword(int id, String password)throws UserNotFoundException;
	
	

}
