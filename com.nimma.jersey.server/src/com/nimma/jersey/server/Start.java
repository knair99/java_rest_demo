package com.nimma.jersey.server;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nimma.jersey.server.clientdatum.*;
import java.util.HashMap;



@Path("/posts")
public class Start {
	
	public static HashMap<Integer, String> clients = new HashMap<Integer, String>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(ClientDatum data) {
				
		String previous_data = clients.get(data.getid());
		if(previous_data == null){
			previous_data = "";
			clients.put(data.getid(), ""); //just initialize if no previous data
		}
		
		String new_data = previous_data + " | " + data.getdata();
		clients.put(data.getid(), new_data);
		
		String result = "Hello client: " + data.getid() + " : Your data so far: " + new_data + "size of map: " + clients.size();
		return Response.status(201).entity(result).build();
		
	}

}
