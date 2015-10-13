package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

import com.jk.sixshot.Response;


public abstract class AbstractDialog<T> implements Dialog<T>{

	protected List<String> asks = new ArrayList<String>();
	protected List<Response> responses = new ArrayList<Response>();
	
	@Override
	public List<String> getAsks() {
		return asks;
	}
	
	@Override
	public List<Response> getResponses(String statement) {
		return responses;
	}
	
	protected abstract void addAsks();
	
	protected abstract void addResponse();
	
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
