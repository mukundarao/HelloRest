package rest.test;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import model.Message;
import service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResources {
	MessageService ms = new MessageService();
	
//	@Path("/hello")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMessage(){
//		return "Hellow World";
//	}
//	
//	@Path("/allMessages")
//	@GET
//	public  List<Message> getAllMessage(){
//		
//		return ms.getAllMessages();
//	}	
//	
	@GET
	public  List<Message> getPaginationMessage(@QueryParam ("start") int start,
													@QueryParam("size")int size){
				
		return ms.getMessagesPaginated(start, size);
	}	
	
	@GET
	@Path("/{messageId}")
	public Message byId( @PathParam("messageId") long messageId ){
		System.out.println("id sent = "+ messageId);
		return ms.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message aMessage){
		return ms.addMessage(aMessage);
	}
	
	@PUT
	@Path("/{messageId}")

	public Message updateMessage(@PathParam("messageId") long id,Message aMessage){
		aMessage.setId(id);
		return ms.updateMessage(aMessage);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void removeMessage( @PathParam("messageId") long messageId ){
		System.out.println("id sent = "+ messageId);
		ms.deleteMessage(messageId);
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return " Path : = " +path + " Cookies := "+cookies;
	}
	
}
