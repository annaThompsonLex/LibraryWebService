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

import library.data.UserDAO;
import library.model.User;

@Stateless
@Path("/user")
public class UserResource {
	
	@Context
	private UriInfo uriInfo;
	
	@Inject
	private  UserDAO dao ;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPersons() {
		return Response.ok(dao.findAllUsers()).build();
	}
	@POST
	@Produces({"application/JSON","application/XML"})
	@Consumes({"application/JSON","application/XML"})
	public Response createEmployee(User user) {
		try {		
			dao.insertUser(user);
			URI uri = new URI(uriInfo.getAbsolutePath()+"/"+ user.getId());
			return Response.created(uri).build();
		} catch (Exception e) {
			return Response.status(504).build();
		}
		
	}

}
