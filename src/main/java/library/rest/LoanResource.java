package library.rest;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import library.data.BookDAO;
import library.data.BookNotFoudException;
import library.data.LoanDAO;
import library.data.UserDAO;
import library.data.UserNotFoundException;
import library.model.Loan;
import library.model.User;

@Stateless
@Path("/loan")
public class LoanResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private UserDAO userDao ;
	
<<<<<<< HEAD
	@Inject
	private  BookDAO bookDao ;
	
	@Inject
	private  LoanDAO loanDao ;
	
	@GET
	@Path("/takeloan/{bookId}/{userId}")
	public Response LoanABook(@PathParam("bookId") int bookId,@PathParam("userId") int userId) {
		try {
			bookDao.LoanABook(bookId);
			loanDao.newLoan(bookDao.findBookById(bookId),userDao.findUserById(userId));
			return Response.status(202).build();
					
		} catch (BookNotFoudException | UserNotFoundException e) {
			
			return Response.status(404).build();
=======
	@POST
	@Produces({"application/JSON","application/XML"})
	@Consumes({"application/JSON","application/XML"})
	public Response createLoan(Loan loan) {
		try {		
			dao.newLoan(loan);
			URI uri = new URI(uriInfo.getAbsolutePath()+"/"+ loan.getId());
			return Response.created(uri).build();
		}catch(IllegalArgumentException e) {
			return Response.status(400).build();
		} catch (Exception e) {
			return Response.status(409).build();
>>>>>>> f107302d3ab465886b8696b7d4b7467017238638
		}
		
	}
	@GET
	@Path("/returnloan/{bookId}/{userId}")
	public Response ReturnABook(@PathParam("bookId") int bookId,@PathParam("userId") int userId) {
		try {
			bookDao.ReturnABook(bookId);
			loanDao.returnLoan(bookId,userId);
			return Response.status(202).build();
					
		} catch (BookNotFoudException e) {
			
			return Response.status(404).build();
		}
		
	}
	

}
