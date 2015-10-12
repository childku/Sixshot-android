package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class ChatScene extends AbstractDialog{

	/**
	 * 称谓
	 */
	protected String SLOT_NAME_CHAT_PERSON = "c_person";
	
	/**
	 * 内容
	 */
	protected String SLOT_NAME_CHAT_CONTENT = "c_content";
	
	public ChatScene(){
		addSlot(SLOT_NAME_CHAT_PERSON);
		addSlot(SLOT_NAME_CHAT_CONTENT);
		
		addValue(SLOT_NAME_CHAT_PERSON, "{你[" + Scene.SCENE_CHAT + "]}");
		addValue(SLOT_NAME_CHAT_PERSON, "豆豆");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_CHAT;
	}

	@Override
	protected abstract void addAsks();
	
	protected void addValue(String value){
		addValue(SLOT_NAME_CHAT_CONTENT, value);
	}

	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		
		RuleSlot personSlot = new RuleSlot(true, getSlot(SLOT_NAME_CHAT_PERSON)); 
		RuleSlot contentSlot = new RuleSlot(getSlot(SLOT_NAME_CHAT_CONTENT)); 
		
		rule.addSlot(personSlot);
		rule.addSlot(contentSlot);
		
		recognitionRules.add(rule);
	}
	
	public void addResponseRule(){
		responseRules.add("<" + SLOT_NAME_CHAT_PERSON +"><" + SLOT_NAME_CHAT_CONTENT + ">");
	}
}
