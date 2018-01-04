package library.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import library.data.UserDAO;
import library.data.UserNotFoundException;
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
	public Response getAllUsers() {
		return Response.ok(dao.findAllUsers()).build();
	}
	@POST
	@Produces({"application/JSON","application/XML"})
	@Consumes({"application/JSON","application/XML"})
	public Response createUser(User user) {
		try {		
			dao.insertUser(user);
			URI uri = new URI(uriInfo.getAbsolutePath()+"/"+ user.getId());
			return Response.created(uri).build();
		} catch (Exception e) {
			return Response.status(409).build();
		}
		
	}
	
	@GET
	@Path("{id}")
	@Produces({"application/JSON","application/XML"})
	public Response findUserByEmail(@PathParam("id")int id) {
		try {
			User user = dao.findUserById(id);
			
			Link selfLink = Link.fromUri(uriInfo.getAbsolutePath()).rel("self").type("get").build();
			Link updateLink = Link.fromUri(uriInfo.getAbsolutePath()).rel("update").type("put").build();
			Link deleteLink = Link.fromUri(uriInfo.getAbsolutePath()).rel("delete").type("delete").build();
			
			
			return Response.ok(user).links(selfLink, updateLink, deleteLink).build();
		}catch (Exception e) {
			return Response.status(404).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteEmployee(@PathParam("id")int id) {
		try {
			dao.deleteUser(id);

			return Response.status(204).build();
		}
		catch(UserNotFoundException e) {
			return Response.status(404).build();
		}
	}
	
	@PUT
	@Path("{id}")
	@Produces({"application/JSON", "application/XML"})
	@Consumes({"application/JSON"})
	public Response updateEmployee(@PathParam("id")int id, User user) {
		try {
			if(user.getEmail() != null) {
				dao.updateUserEmail(id, user.getEmail());
			}
			if(user.getLastName() != null) {
				dao.updateUserLastName(id, user.getLastName());
			}
			if(user.getPassword() != null) {
				dao.updateUserPassword(id, user.getPassword());
			}
			return Response.ok(dao.findUserById(id)).build();
		}catch (UserNotFoundException e) {
			return Response.status(404).build();
		}

	}

}
