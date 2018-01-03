package library.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;

import library.model.User;

@Stateless
public class UserDAOImplementation implements UserDAO {
	
	@Inject
	EntityManager em;

	@Override
	public void insertUser(User newUser) throws AlreadyExsistsException {
		try {
			findUserByEmail(newUser.getEmail());
			throw new AlreadyExsistsException();
		}
		catch(UserNotFoundException e) {
			// if email not found the new user can be inserted
		}
		em.persist(newUser);
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException{
		User user = findUserById(id);
		em.remove(user);

	}

	@Override
	public User findUserById(int id) throws UserNotFoundException{
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.getId() = :id", User.class);
		query.setParameter("id", id);
		try {
			return (User) query.getSingleResult();
		}
		catch(NoResultException e) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
		return query.getResultList();
	}

	@Override
	public List<User> findUsersByFirstName(String firstName) throws UserNotFoundException{
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.getFirstName() = :firstName", User.class);
		query.setParameter("firstName", firstName);
		List<User>users = query.getResultList();
		if(users.isEmpty()) {
			throw new UserNotFoundException();
		}
		return users;
	}

	@Override
	public List<User> findUsersByLastName(String lastName) throws UserNotFoundException{
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.getLastName() = :lastName", User.class);
		query.setParameter("lastName", lastName);
		List<User>users = query.getResultList();
		if(users.isEmpty()) {
			throw new UserNotFoundException();
		}
		return users;
	}

	@Override
	public User findUserByEmail(String email) throws UserNotFoundException{
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.getEmail() = :email", User.class);
		query.setParameter("email", email);
		try {
			return (User) query.getSingleResult();
		}
		catch(NoResultException e) {
			throw new UserNotFoundException();
		}
		
	}

	@Override
	public void updateUserEmail(int id, String newEmail) throws UserNotFoundException {
		User user = findUserById(id);
		user.setEmail(newEmail);
		em.merge(user);

	}

	@Override
	public void updateUserLastName(int id, String lastName) throws UserNotFoundException {
		User user = findUserById(id);
		user.setLastName(lastName);
		em.merge(user);

	}

}
