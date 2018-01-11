package library.data;
/**
 * @author Tommy Steger
 * @author Anna Thompson
 */

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
			//loadCoverPic(newBook.getISBN());
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
		Query q = em.createQuery("select book from Book book where book.title like :title");
		q.setParameter("title","%"+title+"%");
		List<Book> book = q.getResultList();
		return book;
	}

	@Override
	public List<Book> findBookByAuthorLike(String author) {
		Query q = em.createQuery("select book from Book book where book.author like :author");
		q.setParameter("author", "%"+author+"%");
		List<Book> book = q.getResultList();
		return book;
	}

	@Override
	public List<Book> findBookByGenre(String genre) {
		Query q = em.createQuery("select book from Book book where book.genre = :genre");
		q.setParameter("genre", genre);
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
	public void updateNumberOfCopies(int id, Integer copies) throws BookNotFoudException {
		Book book = findBookById(id);
		book.setCopies(copies);
		
	}

	@Override
	public void updateAuthor(int id, String author) throws BookNotFoudException {
		Book book = findBookById(id);
		book.setAuthor(author);
		
		
	}
	@Override
	public void updateShelf(int id, String shelf) throws BookNotFoudException {
		Book book = findBookById(id);
		book.setShelf(shelf);
		
		
	}
	@Override
	public void LoanABook(int id) throws BookNotFoudException {
		Book book = findBookById(id);
		int copies=book.getCopies();
		if(copies>=1) {
			book.setCopies(copies-1);
		}
		else
			throw new BookNotFoudException();
		
	}

	@Override
	public void ReturnABook(int id) throws BookNotFoudException {
		Book book = findBookById(id);
		int copies=book.getCopies();
		book.setCopies(copies+1);
		
		
	}
//	public void loadCoverPic(String fileName) {
//		File file = new File("C:\\"+fileName+".jpg");
//		byte[] picInBytes = new byte[(int) file.length()];
//		FileInputStream fileInputStream;
//		try {
//			fileInputStream = new FileInputStream(file);
//			fileInputStream.read(picInBytes);
//			fileInputStream.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Book book = findBookByISBN(fileName);
//		book.setCoverPic(picInBytes);
//		
//	}
	

}
