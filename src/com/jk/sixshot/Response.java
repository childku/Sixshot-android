package com.jk.sixshot;

/**
 * 响应
 * @author child
 *
 */
public class Response {
	
	public static final String RESPONSE_TYPE_LANGUAGE = "language";
	
	public static final String RESPONSE_TYPE_MOTION = "motion";
	
	public static final String RESPONSE_TYPE_IMAGE = "image";
	
	
	private String type = RESPONSE_TYPE_LANGUAGE;
	
	//响应的指令或内容
	private String instruction = "";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
