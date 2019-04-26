package com.dev.smarthome.resource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

public class Constants {

	public Constants() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 27 (right side)
	 * 20 (left side)
	 */
	public static final Map<String, Pin> RASPBERRY_PIN_MAP;
	static {
		Map<String, Pin> defaultMap = new HashMap<String, Pin>();
		defaultMap.put("27", RaspiPin.GPIO_02);
		defaultMap.put("26", RaspiPin.GPIO_25);
		defaultMap.put("25", RaspiPin.GPIO_06);
		defaultMap.put("24", RaspiPin.GPIO_05);
		defaultMap.put("23", RaspiPin.GPIO_04);
		defaultMap.put("22", RaspiPin.GPIO_03);
		defaultMap.put("21", RaspiPin.GPIO_29);
		defaultMap.put("20", RaspiPin.GPIO_28);
		RASPBERRY_PIN_MAP = Collections.unmodifiableMap(defaultMap);
	}

}
