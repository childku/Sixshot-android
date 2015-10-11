package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class ChatScene extends AbstractDialog{

	protected String SLOT_NAME_PERSON = "person";
	
	protected String SLOT_NAME_CHAT = "chat";
	
	public ChatScene(){
		addSlot(SLOT_NAME_PERSON);
		addSlot(SLOT_NAME_CHAT);
		
		addValue(SLOT_NAME_PERSON, "{你[" + Scene.SCENE_CHAT + "]}");
		addValue(SLOT_NAME_PERSON, "豆豆");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_CHAT;
	}

	/**
	 * 人称#内容
	 */
	@Override
	protected abstract void setAsks();
	
	protected void addValue(String value){
		addValue(SLOT_NAME_CHAT, value);
	}

	@Override
	public Rule generateRule() {
		Rule rule = new Rule();
		rule.setRule("[<" + SLOT_NAME_PERSON  + ">]<" + SLOT_NAME_CHAT + ">");
		return rule;
	}
}
