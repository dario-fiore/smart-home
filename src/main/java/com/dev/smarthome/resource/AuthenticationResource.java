package com.dev.smarthome.resource;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dev.smarthome.dao.UserDao;
import com.dev.smarthome.dto.UserDto;
import com.dev.smarthome.entity.User;
import com.dev.smarthome.mapper.UserMapper;
import com.dev.smarthome.util.EncryptionUtil;

@Path("/auth")
public class AuthenticationResource {

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticate(UserDto user) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (username != null && password != null) {
			UserDao userDao = new UserDao();
			List<User> users = userDao.get(username);
			if (users != null && !users.isEmpty()) {
				String inputPassword = EncryptionUtil.getMd5(password);
				String storedPassword = users.get(0).getPassword();
				if (inputPassword.equals(storedPassword)) {
					return Response.ok().entity(users.get(0)).build();
				}
			}
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(UserDto user) {
		if (user != null) {
			User userModel = UserMapper.INSTANCE.userDtoToUser(user);
			UserDao userDao = new UserDao();
			String userId = UUID.randomUUID().toString();
			userModel.setId(userId);
			userModel.setPassword(EncryptionUtil.getMd5(user.getPassword()));
			userDao.save(userModel);
			return Response.status(Status.CREATED).build();
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	

}