package library.data;

/**
 * @author Tommy Steger
 * @author Anna Thompson
 */

import java.util.List;

import library.model.Book;
import library.model.Loan;
import library.model.User;

public interface LoanDAO {
	
	public void newLoan(Book book, User user);
	public List<Loan> findAllLoans() throws LoanNotFounException;
	public List<Loan> findAllExpiredLoans() throws LoanNotFounException;;
	public List<Loan> findLoansByUserId(int userId) throws LoanNotFounException;
	public List<Loan> findLoansByBookId(int bookId) throws LoanNotFounException;
	public void returnLoan(int bookId, int userId);
	

}
