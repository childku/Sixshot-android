package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jk.sixshot.Response;


public abstract class AbstractDialog implements Dialog{

	protected List<String> asks = new ArrayList<String>();
	protected List<Response> responses = new ArrayList<Response>();
	protected List<Rule> recognitionRules = new ArrayList<Rule>();

	protected List<String> responseRules = new ArrayList<String>();
	
	
	private Map<String, Slot> slots = new HashMap<String, Slot>();
	
	@Override
	public List<String> getAsks() {
		return asks;
	}
	
	@Override
	public List<Response> getResponses(String statement) {
		return responses;
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
		Slot slot = new Slot();
		slot.setName(slotName);
		
		slots.put(slotName, slot);
	}

	protected abstract void addAsks();
	
	protected abstract void addResponse();
	
	protected abstract void addRecogntionRule();
	
	protected abstract void addResponseRule();
	
	/**
	 * 向给定名称的 slot 内添加值
	 * 
	 * @param slotName
	 * @param value
	 */
	protected void addValue(String slotName, String value){
		slots.get(slotName).addValue(value);
	}
	
	protected Slot getSlot(String slotName){
		return slots.get(slotName);
	}
	
	protected void addResponse(Response response){
		responses.add(response);
	}
	
	/**
	 * 默认采用语言方式进行响应，子类可以根据需要覆盖此方法
	 * 
	 * @param instruction
	 */
	protected void addResponse(String instruction){
		Response response = new Response();
		response.setType(Response.RESPONSE_TYPE_LANGUAGE);
		response.setInstruction(instruction);
		addResponse(response);
	}
	
}
