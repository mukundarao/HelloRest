package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import database.DatabaseClass;
import model.Message;

public class MessageService {
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	List<Message>list = new ArrayList<Message>();
	
	public MessageService(){
		messages.put(1L, new Message(1L,"Hello 1", "Mukunda"));
		messages.put(2L, new Message(2L,"Test 2", "Test-2"));
	}
	
	
	public List<Message> getAllMessages(){
	
		return new ArrayList<Message> (messages.values());
		
	}
	public List<Message> getMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message> (messages.values());
		return list.subList(start, start+size);
	
	}
	public Message getMessage(long id){
		Message ms = messages.get(id);
		System.out.println(" Message = "+ ms);
		return ms;
//		return list.get((int) id);
		
	}
	public Message addMessage(Message newMessage){
		newMessage.setId((messages.size()+1));
		long newId = newMessage.getId();
		System.out.println("Newly created id = "+ newId);
		messages.put(newMessage.getId(), newMessage);
		return messages.get(newId);
	}
	public Message updateMessage(Message aMessage){
		if(aMessage.getId()<=0){
			return null;
		}
		System.out.println("before update "+ messages.get(aMessage.getId()));
		System.out.println("updating id = "+ aMessage.getId());
		messages.put(aMessage.getId(), aMessage);
		System.out.println("after update "+ messages.get(aMessage.getId()));
		return aMessage;
		
	}
	
	public void deleteMessage(long id){
		messages.remove(id);
		
	}

}
