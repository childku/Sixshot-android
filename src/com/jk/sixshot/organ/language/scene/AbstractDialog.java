package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractDialog implements Dialog{

	protected List<String> asks = new ArrayList<String>();
	protected List<String> answers = new ArrayList<String>();
	protected Rule rule = new Rule();
	
	private Map<String, Slot> slots = new HashMap<String, Slot>();
	
	@Override
	public List<String> getAsks() {
		return asks;
	}
	@Override
	public List<String> getAnswers() {
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
	
}
