package library.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import library.controller.ValidateISBN;
import library.model.Book;
@Stateless
public class BookDAOImplementation implements BookDAO{

	@Inject
	private EntityManager em;
	
	@Override
	public void insertBook(Book newBook) throws AlreadyExistException {
		ValidateISBN validate = new ValidateISBN();
		if((validate.checkISBN(newBook.getISBN())==true) && (findBookByISBN(newBook.getISBN()) == null)) {
			em.persist(newBook);
		}
		else {
			throw new AlreadyExistException();
		}
		
	}

	@Override
	public void deleteBook(int id) throws BookNotFoudException {
		Book book = findBookById(id);
		em.remove(book);
		
	}

	@Override
	public Book findBookById(int id) throws BookNotFoudException {
		Query q = em.createQuery("select Book from Book book where book.id = :id");
		q.setParameter("id", id);
		try {
		return (Book)q.getSingleResult();
		}
		catch (NoResultException e) {
			throw new BookNotFoudException();
		}
	}

	@Override
	public List<Book> findAllBooks() {
		Query q = em.createQuery("select book from Book book");
		List<Book> book = q.getResultList();
		return book;
	}

	@Override
	public List<Book> findBookByTitleLike(String title) {
		Query q = em.createQuery("select book from Book book where lower book.author like :title");
		q.setParameter("title","%"+ title.toLowerCase()+"%");
		List<Book> book = q.getResultList();
		return book;
	}

	@Override
	public List<Book> findBookByAuthorLike(String author) {
		Query q = em.createQuery("select book from Book book where lower book.author like :author");
		q.setParameter("author", "%"+author.toLowerCase()+"%");
		List<Book> book = q.getResultList();
		return book;
	}

	@Override
	public List<Book> findBookByGenre(String genre) {
		Query q = em.createQuery("select book from Book book where lower book.genre = :genre");
		q.setParameter("genre", genre.toLowerCase());
		return q.getResultList();
	}

	@Override
	public Book findBookByISBN(String ISBN) {
		Query q = em.createQuery("select book from Book book where book.ISBN = :ISBN");
		q.setParameter("ISBN", ISBN);
		try {
			return (Book)q.getSingleResult();
		}
		catch (NoResultException e) {
			//throw new BookNotFoudException();
			return null;
		}
		
	}

	@Override
	public void updateNumberOfCopies(int id, int copies) throws BookNotFoudException {
		Book book = findBookById(id);
		book.setCopies(copies);
		
	}

	@Override
	public void updateAuthor(int id, String author) throws BookNotFoudException {
		Book book = findBookById(id);
		book.setAuthor(author);
		
		
	}

}
