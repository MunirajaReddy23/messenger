package com.muniraja.javabrains.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.muniraja.javabrains.messenger.model.Message;
import com.muniraja.javabrains.messenger.service.MessageService;

//@path annnotaion used to map the uri
@Path("/messages")
public class MessageResource {
	
	//creating object for service class
	MessageService ms=new MessageService();
	
	//this api returns all the messages from the message resource
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return ms.getAllMessages();
	}
	
	@GET
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageid") long id) {
		return ms.getMessage(id);
	}
	
	//adding an object into database
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return ms.addMessage(message);
	}
	
	//changing an existing object
	@PUT
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageid") long id,Message message) {
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	//Delete message
	@DELETE
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageid") long id) {
		ms.deleteMessage(id);
	}
	
}
