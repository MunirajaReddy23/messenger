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

import com.muniraja.javabrains.messenger.model.Profile;
import com.muniraja.javabrains.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService ps=new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles() {
		return ps.getAllProfiles();	
	}
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String profileName) {
		return ps.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return ps.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile) {
		profile.setProfileName(profileName);
		return ps.updateProfile(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		ps.deleteProfile(profileName);
	}
	
	
	

}
