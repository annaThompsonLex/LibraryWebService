package library.rest;

import java.net.URI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import library.data.LoanDAO;
import library.model.Loan;
import library.model.User;

@Stateless
@Path("/loan")
public class LoanResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private  LoanDAO dao ;
	
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
		}
		
	}

}
