package com.dev.smarthome.resource;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

@Path("/remote")
public class RemoteResource {
	final GpioController gpio = GpioFactory.getInstance();

	
	@GET
	@Path("/pins")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAvailablePins() {
		Set<String> availablePins = Constants.RASPBERRY_PIN_MAP.keySet();
		return Response.ok().entity(availablePins).build();
	}
	
	@GET
	@Path("/status/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPinStatus(@PathParam("id") String id) {
		GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(Constants.RASPBERRY_PIN_MAP.get(id));
		boolean isPinHigh = pin.isHigh();
		gpio.shutdown();
		gpio.unprovisionPin(pin);
		com.dev.smarthome.dto.ResponseDto response = new com.dev.smarthome.dto.ResponseDto();
		response.setResult(isPinHigh);
		return Response.ok().entity(response).build();
	}
	
	@PUT
	@Path("/status/{id}")
	public Response updatePinStatus(@PathParam("id") String id) throws InterruptedException {
		GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(Constants.RASPBERRY_PIN_MAP.get(id), "Interface", PinState.LOW);
		Thread.sleep(400);
		pin.toggle();
		Thread.sleep(400);
		gpio.shutdown();		
		gpio.unprovisionPin(pin);
		return Response.status(Status.NO_CONTENT).build();
	}
}