package library.data;

import java.util.List;

import library.model.Book;
import library.model.Loan;

public interface LoanDAO {
	
	public void newLoan(Loan loan);
	public List<Loan> findAllLoans();
	public List<Loan> findLoansByUserId(int userId);
	public List<Loan> findLoansByBookId(int bookId);
	public void updateStatus(boolean status);

}
