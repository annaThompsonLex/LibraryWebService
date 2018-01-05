package library.data;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import library.model.Loan;
import library.model.User;

@Stateless
public class LoanDAOImplementation implements LoanDAO {
	
	@Inject
	EntityManager em;

	@Override
	public void newLoan(Loan loan) {
		if(loan.getUser() == null || loan.getBook() == null) {
			throw new IllegalArgumentException();
		}
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

}
