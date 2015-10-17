package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

import com.jk.sixshot.Response;


public abstract class AbstractDialog<T> implements Dialog<T>{

	protected List<String> asks = new ArrayList<String>();
	
	@Override
	public List<String> getAsks() {
		return asks;
	}
	
	public abstract void addAsks();
	
	public abstract void addResponses();
	
	public void addAsk(String ask){
		asks.add(ask);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void addResponse(Response response){
		((Scene)getScene()).addResponse(getAsks(), response);
	}
	
	/**
	 * 默认采用语言方式进行响应，子类可以根据需要覆盖此方法
	 * 
	 * @param instruction
	 */
	public void addResponse(String instruction){
		Response response = new Response();
		response.setType(Response.RESPONSE_TYPE_LANGUAGE);
		response.setInstruction(instruction);
		addResponse(response);
	}
	
}
