package com.dev.smarthome.dto;

public class ResponseDto {
	
	private boolean result;

	public ResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}


	@Override
	public String toString() {
		return "Response [result=" + result + "]";
	}
	
}
