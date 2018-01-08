package library.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import library.model.Book;
import library.model.Loan;
import library.model.User;

@Stateless
public class LoanDAOImplementation implements LoanDAO {
	
	@Inject
	EntityManager em;

	@Override
<<<<<<< HEAD
	public void newLoan(Book book, User user) {
		Loan loan = new Loan(book, user);
=======
	public void newLoan(Loan loan) {
		if(loan.getUser() == null || loan.getBook() == null) {
			throw new IllegalArgumentException();
		}
>>>>>>> f107302d3ab465886b8696b7d4b7467017238638
		em.persist(loan);

	}

	@Override
	public List<Loan> findAllLoans() throws LoanNotFounException {
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l ", Loan.class);
		List<Loan>loans = query.getResultList();
		if(loans.isEmpty()) {
			throw new LoanNotFounException();
		}
		return loans;
	}

	@Override
	public List<Loan> findAllExpiredLoans() throws LoanNotFounException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> findLoansByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> findLoansByBookId(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(boolean status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void returnLoan(int bookId, int userId) {
		// TODO Auto-generated method stub
		
	}

	

}
