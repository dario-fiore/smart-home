package com.dev.smarthome.dto;

public class RoleDto {
	private String id;

	public RoleDto() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleDto [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
