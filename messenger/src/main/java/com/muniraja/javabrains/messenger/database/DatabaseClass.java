package com.muniraja.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.muniraja.javabrains.messenger.model.Message;
import com.muniraja.javabrains.messenger.model.Profile;


//this class act as dummy database,in general web applications we write JDBC or 
//Hibernate code here
public class DatabaseClass {
	
	//crating temporary database tables using map which holds model type objects
	public static Map<Long,Message>messages=new HashMap<>();
	public static Map<String,Profile>profiles=new HashMap<>();
	
	//this is returning Message map
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	
	//this is returning Profile map
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}
	
}
