package library.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Book book;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private boolean returned;
	
	public Loan() {}

	public Loan(User user, Book book) {
		super();
		this.user = user;
		this.book = book;
		this.startDate = LocalDate.now();
		this.endDate = LocalDate.now().plusDays(14);
		this.returned = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public void getReturnde(boolean returned) {
		this.returned = returned;
	}
	
	public void setReturnde(boolean returned) {
		this.returned = returned;
	}
	
	
	
	
	

}
