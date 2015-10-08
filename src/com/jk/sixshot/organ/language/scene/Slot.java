package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

public class Slot {
	private String name;
	
	private List<String> values = new ArrayList<String>();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getValues() {
		return values;
	}
	
	public void setValues(List<String> values) {
		this.values = values;
	}
	
	public void addValue(String value){
		values.add(value);
	}
	
	public void addValues(List<String> values){
		values.addAll(values);
	}

}
