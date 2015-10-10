package com.jk.sixshot.organ.language.scene.chat;

import java.util.ArrayList;
import java.util.List;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;
import com.jk.sixshot.organ.language.scene.Slot;

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
		List<Slot> slots = new ArrayList<Slot>();
		Slot slot = null;
		
		String tokens[] = null;
		for(String ask: asks){
			tokens = ask.split("#");
			if(tokens.length==1){
				slot = new Slot();
				slot.setName("chat");
				//TODO 解析多个
				slot.addValue(tokens[0]);
				slots.add(slot);
			}else{
				slot = new Slot();
				slot.setName("person");
//				slot.setValue(tokens[1]);
			}
			slots.add(slot);
		}
//		rule.setSlots();
//		rule.setRule();
		return rule;
	}
}
