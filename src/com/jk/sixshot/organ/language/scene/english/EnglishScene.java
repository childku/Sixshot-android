package com.jk.sixshot.organ.language.scene.english;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class EnglishScene extends AbstractDialog{

	protected String SLOT_NAME_ENGLISH_CMD = "en_cmd";
	
	protected String SLOT_NAME_ENGLISH_STATEMENT = "en_st";
	
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
	
	/**
	 * 人称#内容
	 */
	@Override
	protected abstract void setAsks();
	
	protected void addValue(String value){
		addValue(SLOT_NAME_ENGLISH_STATEMENT, value);
	}
	
	@Override
	public Rule generateRule() {
		Rule rule = new Rule();
		rule.setRule("<" + SLOT_NAME_ENGLISH_STATEMENT  + "><" + SLOT_NAME_ENGLISH_CMD + ">");
		return rule;
	}
}
