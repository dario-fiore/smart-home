package com.dev.smarthome.dto;

import java.util.Collection;

public class SettingDto {

	private String name;

	private String port;

	private String icon;

	private Collection<RoleDto> roles;

	public SettingDto() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Collection<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleDto> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SettingDto [name=");
		builder.append(name);
		builder.append(", port=");
		builder.append(port);
		builder.append(", icon=");
		builder.append(icon);
		builder.append(", roles=");
		builder.append(roles);
		builder.append("]");
		return builder.toString();
	}

}
