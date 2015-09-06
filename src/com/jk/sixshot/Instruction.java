package com.jk.sixshot;

public class Instruction {
	
	public static final String INSTRUCTION_TYPE_SPEAK = "speak";
	
	public static final String INSTRUCTION_TYPE_WAKL = "walk";
	
	private String type = INSTRUCTION_TYPE_SPEAK;
	
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
