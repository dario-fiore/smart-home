package com.dev.smarthome.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dev.smarthome.dao.RoleDao;
import com.dev.smarthome.entity.Role;

@Path("/profile")
public class ProfileResource {

	@GET
	@Path("/roles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAvailableRoles() {
		RoleDao roleDao = new RoleDao();
		List<Role> roles = roleDao.getAll();
		return Response.ok().entity(roles).build();
	}

}