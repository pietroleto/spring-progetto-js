package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.dto.AddRuoloDTO;
import it.corso.dto.RuoloShowDTO;
import it.corso.service.RuoloService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/ruolo")
public class RuoloController {
	@Autowired
	private RuoloService ruoloService;
	
	@GET
	@Path("/ruolo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRuoloById(@PathParam("id") int id) {
		try {
			return Response.ok(ruoloService.getRuoloById(id)).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@GET
	@Path("/ruoli")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRuoli() {
	    try {
	        List<RuoloShowDTO> ruoli;
	        
	        ruoli = ruoloService.getRuoli();

	        return Response.ok(ruoli).build();
	    } catch (Exception e) {
	        return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRuolo(@RequestBody AddRuoloDTO ruolo) {
		try {			
			ruoloService.creaRuolo(ruolo);
			
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response delRuolo(@PathParam("id") int id) {
	    try {
	    	ruoloService.deleteRuoloById(id);
	    	return Response.status(Response.Status.OK).build();
	    } catch (Exception e) {
	        return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRuolo(@RequestBody RuoloShowDTO ruolo) {
		try {
			ruoloService.updateRuolo(ruolo);
			
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
}
