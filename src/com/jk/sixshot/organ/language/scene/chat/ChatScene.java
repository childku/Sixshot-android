package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.AbstractScene;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public class ChatScene extends AbstractScene<ChatScene>{
	
	/**
	 * 称谓
	 */
	public static final String SLOT_NAME_CHAT_PERSON = "c_person";
	
	/**
	 * 内容
	 */
	public static final String SLOT_NAME_CHAT_CONTENT = "c_content";
	
	public ChatScene(){
		super();
//		addRecogntionRule();
//		addResponseRule();
		System.out.println("ChatScene is created.");
		addValue(SLOT_NAME_CHAT_PERSON, "你");
		addValue(SLOT_NAME_CHAT_PERSON, "豆豆");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_NAME_CHAT;
	}

	public void addValue(String value){
		addValue(SLOT_NAME_CHAT_CONTENT, value);
	}

	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		
		RuleSlot personSlot = new RuleSlot(true, getSlot(SLOT_NAME_CHAT_PERSON)); 
		RuleSlot contentSlot = new RuleSlot(getSlot(SLOT_NAME_CHAT_CONTENT)); 
		
		rule.addRuleSlot(personSlot);
		rule.addRuleSlot(contentSlot);
		
		recognitionRules.add(rule);
	}
	
	public void addResponseRule(){
//		responseRules.add("<" + SLOT_NAME_CHAT_PERSON +"><" + SLOT_NAME_CHAT_CONTENT + ">");
	}
}
