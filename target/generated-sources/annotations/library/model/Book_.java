package library.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, String> picUrl;
	public static volatile SingularAttribute<Book, Integer> copies;
	public static volatile SingularAttribute<Book, String> ISBN;
	public static volatile SingularAttribute<Book, String> author;
	public static volatile SingularAttribute<Book, String> genre;
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, String> shelf;

}

