package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractDialog implements Dialog{

	protected List<String> asks = new ArrayList<String>();
	protected List<String> answers = new ArrayList<String>();
	
	
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
	
}
