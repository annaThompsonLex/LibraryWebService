package library.model;



import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	@JoinColumn(name = "id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Book book;
	
//	private Date startDate;
//	
//	private Date endDate;
	
	private boolean returned;
	
//	@Transient
//	private LocalDateAttributeConverter dateConverter;
	
	public Loan() {}

	public Loan(User user, Book book) {
		super();
		this.user = user;
		this.book = book;
//		this.startDate = dateConverter.convertToDatabaseColumn(LocalDate.now());
//		this.endDate = dateConverter.convertToDatabaseColumn(LocalDate.now().plusDays(14));
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

//	public LocalDate getStartLocalDate() {
//		return dateConverter.convertToEntityAttribute(startDate);
//	}
//
//	public void setStartLocalDate(LocalDate startDate) {
//		this.startDate = dateConverter.convertToDatabaseColumn(startDate);
//	}
//
//	public LocalDate getEndLocalDate() {
//		return dateConverter.convertToEntityAttribute(endDate);
//	}
//
//	public void setEndLocalDate(LocalDate endDate) {
//		this.endDate = dateConverter.convertToDatabaseColumn(endDate);
//	}
//	
//	public Date getStartDate() {
//		return startDate;
//	}
//	
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//	
//	public Date getEndDate() {
//		return endDate;
//	}
//	
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
	
	public void getReturnde(boolean returned) {
		this.returned = returned;
	}
	
	public void setReturnde(boolean returned) {
		this.returned = returned;
	}
	

	
	
	

}
