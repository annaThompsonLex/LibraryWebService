package library.data;

/**
 * @author Tommy Steger
 * @author Anna Thompson
 */

import java.time.LocalDate;
import java.util.ArrayList;
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

	public void newLoan(Book book, User user) {
		Loan loan = new Loan(book, user);
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
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.returned = :boolean", Loan.class);
		query.setParameter("boolean", false);
		List<Loan>loans = query.getResultList();
		List<Loan>expiredLoans = new ArrayList<>();
		LocalDate today = LocalDate.now();
		for(Loan loan:loans) {
			LocalDate endDate = LocalDate.parse(loan.getEndDate());
			if(endDate.isBefore(today)) {
				expiredLoans.add(loan);
			}
		}
		if(expiredLoans.isEmpty()) {
			throw new LoanNotFounException();
		}
		return expiredLoans;
		
		
	}

	@Override
	public List<Loan> findLoansByUserId(int userId) throws LoanNotFounException {
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l JOIN l.user u WHERE u.id = :userId", Loan.class);
		query.setParameter("userId", userId);
		List<Loan>loans = query.getResultList();
		if(loans.isEmpty()) {
			throw new LoanNotFounException();
		}
		return loans;
	}

	@Override
	public List<Loan> findLoansByBookId(int bookId) throws LoanNotFounException {
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l JOIN l.book b WHERE b.id = :bookId", Loan.class);
		query.setParameter("bookId", bookId);
		List<Loan>loans = query.getResultList();
		if(loans.isEmpty()) {
			throw new LoanNotFounException();
		}
		return loans;
	}


	@Override
	public void returnLoan(int bookId, int userId) {
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l JOIN l.book b JOIN l.user u WHERE b.id = :bookId AND u.id = :userId", Loan.class);
		query.setParameter("bookId", bookId);
		query.setParameter("userId", userId);
		List<Loan>loans = query.getResultList();
		for(Loan loan: loans) {
			loan.setReturned(true);
		}
	}

	

}
