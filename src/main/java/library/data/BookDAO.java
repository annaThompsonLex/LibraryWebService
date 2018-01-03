package library.data;

import java.util.List;

import library.model.Book;

public interface BookDAO {
	
	public void insertBook(Book newBook) throws AlreadyExistException;
	public void deleteBook(int id) throws BookNotFoudException;
	public Book findBookById(int id) throws BookNotFoudException;
	public List<Book> findAllBooks();
	public List<Book> findBookByTitleLike(String title);
	public List<Book> findBookByAuthorLike(String author);
	public List<Book> findBookByGenre(String genre);
	public Book findBookByISBN(String ISBN);
	public void updateNumberOfCopies(int id, int copies) throws BookNotFoudException;
	public void updateAuthor(int id, String author) throws BookNotFoudException;

}
