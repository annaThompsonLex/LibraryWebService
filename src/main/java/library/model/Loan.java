package library.model;



import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import library.util.LocalDateAttributeConverter;

@Entity
@XmlRootElement
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Book book;
	
	
	@OneToOne
	private User user;
	
	private String startDate;
	
	private String endDate;
	
	private boolean returned;
	
	@Transient
	private LocalDateAttributeConverter dateConverter;
	
	public Loan() {}

	public Loan(Book book, User user) {
		super();
	
		this.user = user;
		this.book= book;
		this.startDate = LocalDate.now().toString();
		this.endDate = LocalDate.now().plusDays(14).toString();
		this.returned = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public LocalDateAttributeConverter getDateConverter() {
		return dateConverter;
	}

	public void setDateConverter(LocalDateAttributeConverter dateConverter) {
		this.dateConverter = dateConverter;
	}


	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void getReturnde(boolean returned) {
		this.returned = returned;
	}
	
	public void setReturnde(boolean returned) {
		this.returned = returned;
	}
	

	
	
	

}
