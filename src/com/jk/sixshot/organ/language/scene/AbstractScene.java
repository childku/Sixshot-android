package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractScene<T> implements Scene<T>{

	protected List<Rule> recognitionRules = new ArrayList<Rule>();

	protected List<String> responseRules = new ArrayList<String>();
	
	
	private Map<String, Slot> slots = new HashMap<String, Slot>();
	
	
	@Override
	public List<Rule> getRecognitionRules() {
		return recognitionRules;
	}

	@Override
	public List<String> getResponseRules() {
		return responseRules;
	}
	
	protected void addSlot(String slotName){
		Slot slot = new Slot();
		slot.setName(slotName);
		
		slots.put(slotName, slot);
	}

	protected abstract void addRecogntionRule();
	
	protected abstract void addResponseRule();
	
	/**
	 * 向给定名称的 slot 内添加值
	 * 
	 * @param slotName
	 * @param value
	 */
	public void addValue(String slotName, String value){
		slots.get(slotName).addValue(value);
	}
	
	protected Slot getSlot(String slotName){
		return slots.get(slotName);
	}
	
}
