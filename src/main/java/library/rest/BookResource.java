package library.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



import library.data.BookDAO;
import library.data.BookNotFoudException;
import library.model.Book;


@Stateless
@Path("/book")
public class BookResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private  BookDAO dao ;
	
	@GET
	@Produces("application/JSON")
	public Response getBooks (@QueryParam("title") String title, @QueryParam("author") String author, @QueryParam("genre") String genre , @QueryParam("isbn") String isbn ){
		
		try {
			if(title != null)
				return Response.ok(dao.findBookByTitleLike(title)).build();
			else if(author !=null)
				return Response.ok(dao.findBookByAuthorLike(author)).build();
			else if (genre !=null)
				return Response.ok(dao.findBookByGenre(genre)).build();
			else if (isbn!=null)
				return Response.ok(dao.findBookByISBN(isbn)).build();
			else
				return Response.ok(dao.findAllBooks()).build();
		} catch (Exception e) {
			return Response.status(400).build();
		}
		
	
		//
		
	}
	
//	@GET
//	@Produces({"application/JSON","application/XML"})
//	public Response getAllBooks() {
//		return Response.ok(dao.findAllBooks()).build();
//	}
	@POST
	@Produces({"application/JSON","application/XML"})
	@Consumes({"application/JSON","application/XML"})
	public Response createBook(Book book) {
		try {		
			dao.insertBook(book);
			URI uri = new URI(uriInfo.getAbsolutePath()+"/"+ book.getId());
			return Response.created(uri).build();
		} catch (Exception e) {
			return Response.status(409).build();
		}
		
	}
	@GET
	@Produces({"application/JSON","application/XML"})
	@Path("{id}")
	public Response findBookById(@PathParam("id")   int id) {
		try {
			Book result = dao.findBookById(id);
			
			Link selfLink =   Link.fromUri(uriInfo.getAbsolutePath()).rel("self").type("get").build();
			Link updateLink = Link.fromUri(uriInfo.getAbsolutePath()).rel("update").type("put").build();
			Link deleteLink = Link.fromUri(uriInfo.getAbsolutePath()).rel("delete").type("delete").build();
			return Response.ok(result).links(selfLink,updateLink,deleteLink).build();
		} catch (BookNotFoudException e) {
			
			return Response.status(404).build();
		}
	}
	@DELETE
	@Path("{id}")
	public Response deleteBook(@PathParam("id") int id) {
		try {
			dao.deleteBook(id);
			return Response.status(204).build();
					
		} catch (BookNotFoudException e) {
			
			return Response.status(404).build();
		}
		
	}
	@PUT
	@Path("{id}")
	@Produces({"application/JSON","application/XML"})
	@Consumes({"application/JSON"})
	public Response updateBook(@PathParam("id") int id,Book book) {
		try {
			if(book.getAuthor()!=null)
				dao.updateAuthor(id, book.getAuthor());
			if(book.getCopies()!=null)
				dao.updateNumberOfCopies(id, book.getCopies());
			if(book.getShelf()!=null)
				dao.updateShelf(id, book.getShelf());
			
			return Response.ok(dao.findBookById(id)).build();
			
		} catch (BookNotFoudException e1) {
			return Response.status(404).build();
		}
	}
	
		 


}
