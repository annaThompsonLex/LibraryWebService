package library.data;

import java.util.List;

import library.model.Book;
import library.model.Loan;

public interface LoanDAO {
	
	public void newLoan(Loan loan);
	public List<Loan> findAllLoans() throws LoanNotFounException;
	public List<Loan> findAllExpiredLoans() throws LoanNotFounException;;
	public List<Loan> findLoansByUserId(int userId) throws LoanNotFounException;;
	public List<Loan> findLoansByBookId(int bookId) throws LoanNotFounException;;
	public void updateStatus(boolean status) throws LoanNotFounException;;

}
