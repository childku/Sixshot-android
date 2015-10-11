package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.sixshot.Response;


public abstract class AbstractDialog implements Dialog{

	protected List<String> asks = new ArrayList<String>();
	protected List<Response> answers = new ArrayList<Response>();
	protected Rule rule = new Rule();
	
	private Map<String, Slot> slots = new HashMap<String, Slot>();
	
	@Override
	public List<String> getAsks() {
		return asks;
	}
	
	@Override
	public List<Response> getResponses(String statement) {
		return answers;
	}

	protected abstract void setAsks();
	
	protected abstract void setAnswers();
	
	protected void addSlot(String slotName){
		Slot slot = new Slot();
		slot.setName(slotName);
		
		slots.put(slotName, slot);
	}
	
	protected void addValue(String slotName, String value){
		slots.get(slotName).addValue(value);
	}
	
	protected Slot getSlot(String slotName){
		return slots.get(slotName);
	}
	
	protected void addResponse(Response response){
		answers.add(response);
	}
	
	protected void addResponse(String instruction){
		Response response = new Response();
		response.setInstruction(instruction);
		addResponse(response);
	}
	
}
