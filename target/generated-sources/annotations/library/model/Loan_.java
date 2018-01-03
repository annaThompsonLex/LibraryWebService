package library.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Loan.class)
public abstract class Loan_ {

	public static volatile SingularAttribute<Loan, LocalDate> endDate;
	public static volatile SingularAttribute<Loan, Book> book;
	public static volatile SingularAttribute<Loan, Integer> id;
	public static volatile SingularAttribute<Loan, Boolean> returned;
	public static volatile SingularAttribute<Loan, User> user;
	public static volatile SingularAttribute<Loan, LocalDate> startDate;

}

