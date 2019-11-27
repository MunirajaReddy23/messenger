package com.muniraja.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.muniraja.javabrains.messenger.database.DatabaseClass;
import com.muniraja.javabrains.messenger.model.Profile;

public class ProfileService {
	//Creating map object
	private Map<String,Profile> profiles=DatabaseClass.getProfiles();
	
	//crating and adding objects to the map bcz it is static 
	// so u can add objects to it from outside
	
	  public ProfileService() {
		  //crating profile objects and adding it to map using
		  profiles.put("muni",new Profile(1L,"Muniraja","MunirajaReddy","Boggala"));
		  profiles.put("raja",new Profile(2L,"Hari","Harinadh","abc"));
	  }
	
	//this is service method to fetch all the messages from the map
	public List<Profile> getAllProfiles() {
	return new ArrayList<Profile>(profiles.values());
	}
	
	//method to fetch single profile record from database
	public Profile getProfile(String profileName) {
		
		return profiles.get(profileName);
		
	}
	//this method add profile to database table  
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	//update existing profile
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	//delete an existing profile
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	
	}
}
