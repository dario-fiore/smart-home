package com.dev.smarthome.resource;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.dev.smarthome.dao.SettingDao;
import com.dev.smarthome.dto.SettingDto;
import com.dev.smarthome.entity.Setting;
import com.dev.smarthome.mapper.SettingMapper;

@Path("/settings")
public class SettingResource {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAvailableSettings() {
		SettingDao settingDao = new SettingDao();
		List<Setting> settings = settingDao.getAll();
		return Response.ok().entity(settings).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerSetting(SettingDto setting) {
		if (setting != null) {
			Setting settingModel = SettingMapper.INSTANCE.settingDtoToSetting(setting);
			SettingDao settingDao = new SettingDao();
			String settingId = UUID.randomUUID().toString();
			settingModel.setId(settingId);
			settingDao.save(settingModel);
			return Response.status(Status.CREATED).build();
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSetting(@PathParam("id") String id, SettingDto setting) {
		if (id != null && setting != null) {
			Setting settingModel = SettingMapper.INSTANCE.settingDtoToSetting(setting);
			SettingDao settingDao = new SettingDao();
			settingModel.setId(id);
			settingDao.update(settingModel);
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSetting(@PathParam("id") String id) {
		if (id != null) {
			SettingDao settingDao = new SettingDao();
			settingDao.delete(id);
			return Response.status(Status.NO_CONTENT).build();
		} else {
			return Response.status(Status.BAD_REQUEST).build();
		}
	}


}
