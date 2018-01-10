package library.rest;



import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import library.data.BookDAO;
import library.data.BookNotFoudException;
import library.data.LoanDAO;
import library.data.UserDAO;
import library.data.UserNotFoundException;


@Stateless
@Path("/loan")
public class LoanResource {
	

	
	@Inject
	private UserDAO userDao ;
	

	@Inject
	private  BookDAO bookDao ;
	
	@Inject
	private  LoanDAO loanDao ;
	
	@GET
	@Path("/takeloan/{bookId}/{userId}")
	@Produces({"application/JSON","application/XML"})
	public Response LoanABook(@PathParam("bookId") int bookId,@PathParam("userId") int userId) {
		try {
			bookDao.LoanABook(bookId);
			loanDao.newLoan(bookDao.findBookById(bookId),userDao.findUserById(userId));
			return Response.status(202).build();
					
		} catch (BookNotFoudException | UserNotFoundException e) {
			
			return Response.status(404).build();

		}
	}
			
	@GET
	@Path("/returnloan/{bookId}/{userId}")
	@Produces({"application/JSON","application/XML"})
	public Response ReturnABook(@PathParam("bookId") int bookId,@PathParam("userId") int userId) {
		try {
			bookDao.ReturnABook(bookId);
			loanDao.returnLoan(bookId,userId);
			return Response.status(202).build();
					
		} catch (BookNotFoudException e) {
			
			return Response.status(404).build();
		}
		
	}
	@GET
	@Produces({"application/JSON","application/XML"})
	public Response getBooks (@QueryParam("bookid") int bookid, @QueryParam("userid") int userid, @QueryParam("expired") String expired ){
		
		try {
			if(bookid != 0)
				return Response.ok(loanDao.findLoansByBookId(bookid)).build();
			else if(userid !=0)
				return Response.ok(loanDao.findLoansByUserId(userid)).build();
			else if (expired !=null)
				return Response.ok(loanDao.findAllExpiredLoans()).build();
			else
				return Response.ok(loanDao.findAllLoans()).build();
		} catch (Exception e) {
			return Response.status(400).build();
		}
		
	}

}
