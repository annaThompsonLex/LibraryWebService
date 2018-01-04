package library.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import library.data.BookDAO;
import library.model.Book;
import library.model.Member;

@Stateless
@Path("/book")
public class BookResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private  BookDAO dao ;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersons() {
		return Response.ok(dao.findAllBooks()).build();
	}
	@POST
	@Produces({"application/JSON","application/XML"})
	@Consumes({"application/JSON","application/XML"})
	public Response createEmployee(Book book) {
		try {		
			dao.insertBook(book);
			URI uri = new URI(uriInfo.getAbsolutePath()+"/"+ book.getId());
			return Response.created(uri).build();
		} catch (Exception e) {
			return Response.status(504).build();
		}
		
	}

}
