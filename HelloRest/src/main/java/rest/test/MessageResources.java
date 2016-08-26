package rest.test;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Message;
import service.MessageService;

@Path("/messages")
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
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public  List<Message> getAllMessage(){
		
		return ms.getAllMessages();
	}	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message byId( @PathParam("messageId") long messageId ){
		System.out.println("id sent = "+ messageId);
		return ms.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message aMessage){
		return ms.addMessage(aMessage);
	}
}
