package com.jk.sixshot.organ.language.scene.english;

import com.jk.sixshot.organ.language.scene.AbstractScene;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public class EnglishScene extends AbstractScene<EnglishScene>{

	public String SLOT_NAME_ENGLISH_CMD = "en_cmd";
	
	public String SLOT_NAME_ENGLISH_STATEMENT = "en_st";
	
	public EnglishScene(){
		addSlot(SLOT_NAME_ENGLISH_CMD);
		addSlot(SLOT_NAME_ENGLISH_STATEMENT);
		
		addValue(SLOT_NAME_ENGLISH_CMD, "怎么说");
		addValue(SLOT_NAME_ENGLISH_CMD, "用英语怎么说");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_POEM;
	}
	
	
	public void addValue(String value){
		addValue(SLOT_NAME_ENGLISH_STATEMENT, value);
	}
	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		rule.setRule("<" + SLOT_NAME_ENGLISH_STATEMENT  + "><" + SLOT_NAME_ENGLISH_CMD + ">");
		recognitionRules.add(rule);
	}
	
	public void addResponseRule(){
		
	}

}
