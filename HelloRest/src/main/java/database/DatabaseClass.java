package database;

import java.util.HashMap;
import java.util.Map;

import model.Message;

public class DatabaseClass {
	private static Map<Long,Message> messages = new HashMap<Long,Message>();
	private static Map<Long,Message> profiles = new HashMap<Long,Message>();
	
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	public static Map<Long,Message> getProfiles(){
		return profiles;
	}

}
