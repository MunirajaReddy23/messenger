package com.muniraja.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.muniraja.javabrains.messenger.database.DatabaseClass;
import com.muniraja.javabrains.messenger.model.Message;

public class MessageService {
	
	//Creating map object
	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	//crating and adding objects to the map bcz it is static 
	// so u can add objects to it from outside
	public MessageService() {
		//crating map objects and adding it to map using put method()
		messages.put(1L,new Message(1L,"Hello world!","muniraja"));
		messages.put(2L,new Message(2L,"Java World!","muniraja"));
		messages.put(3L,new Message(2L,"Spring world!","muniraja"));
		messages.put(4L,new Message(4L,"RESTful World!","muniraja"));
	}
	
	//this is service method to fetch all the messages from the map
	public List<Message> getAllMessages() {
	return new ArrayList<Message>(messages.values());
	}
	
	//method to fetch single record from database
	public Message getMessage(long id) {
		
		return messages.get(id);
		
	}
	//this method add messages to database table  
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	//update existing message
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	//delete an existing object
	public Message deleteMessage(long id) {
		return messages.remove(id);
	}

}
