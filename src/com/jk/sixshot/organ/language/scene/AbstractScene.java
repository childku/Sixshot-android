package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.sixshot.Response;


public abstract class AbstractScene<T> implements Scene<T>{

	protected List<Rule> recognitionRules = new ArrayList<Rule>();

	protected List<String> responseRules = new ArrayList<String>();
	
	protected Map<List<String>, List<Response>> responses = new HashMap<List<String>, List<Response>>();
	
	
	private Map<String, Slot> slots = new HashMap<String, Slot>();
	
	public AbstractScene(){
		System.out.println("AbstractScene is created. clsss is " + this.getClass().getName());
		
		addRecogntionRule();
		addResponseRule();
	}
	
	public List<Slot> getSlots(){
		return new ArrayList<Slot>(slots.values());
	}
	@Override
	public List<Rule> getRecognitionRules() {
		return recognitionRules;
	}

	@Override
	public List<String> getResponseRules() {
		return responseRules;
	}
	
	protected void addSlot(String slotName){
		if(slots.containsKey(slotName)){
			return ;
		}
		Slot slot = new Slot();
		slot.setName(slotName);
		
		slots.put(slotName, slot);
	}

	public Map<List<String>, List<Response>> getResponses(){
		return responses;
	}
	
	protected abstract void addRecogntionRule();
	
	protected abstract void addResponseRule();
	
//	protected abstract void addRecogntionRule();
	
	/**
	 * 向给定名称的 slot 内添加值
	 * 
	 * @param slotName
	 * @param value
	 */
	@Override
	public void addValue(String slotName, String value){
//		System.out.println("--slot name is " + slotName);
		if(slots.containsKey(slotName)){
			slots.get(slotName).addValue(value);
		}else{
			Slot slot = new Slot();
			slot.setName(slotName);
			slots.put(slotName, slot);
			slot.addValue(value);
		}
	}
	
	public void addResponse(List<String> asks, Response response){
		if(responses.containsKey(asks)){
			responses.get(asks).add(response);
		}else{
			List<Response> reses = new ArrayList<Response>();
			reses.add(response);
			responses.put(asks, reses);
		}
	}
	
	@Override
	public Slot getSlot(String slotName){
		if(slots.containsKey(slotName)){
			return slots.get(slotName);
		}else{
			Slot slot = new Slot();
			slot.setName(slotName);
			slots.put(slotName, slot);
			return slot;
		}
	}
	
}
