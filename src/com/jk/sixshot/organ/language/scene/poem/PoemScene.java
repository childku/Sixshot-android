package com.jk.sixshot.organ.language.scene.poem;

import com.jk.sixshot.organ.language.scene.AbstractScene;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public class PoemScene extends AbstractScene<PoemScene>{

	public static final String SLOT_NAME_POEM_CMD = "poem_cmd";
	
	public static final String SLOT_NAME_POEM_NAME = "poem_name";
	
	public PoemScene(){
		super();
		
		addValue(SLOT_NAME_POEM_CMD, "背");
		addValue(SLOT_NAME_POEM_CMD, "背首");
		addValue(SLOT_NAME_POEM_CMD, "背一首");
		addValue(SLOT_NAME_POEM_CMD, "背个");
		addValue(SLOT_NAME_POEM_CMD, "背一个");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_NAME_POEM;
	}
	
	protected void addValue(String value){
		addValue(SLOT_NAME_POEM_NAME, value);
	}
	
	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		
		RuleSlot cmdSlot = new RuleSlot(getSlot(SLOT_NAME_POEM_CMD)); 
		RuleSlot nameSlot = new RuleSlot(getSlot(SLOT_NAME_POEM_NAME)); 
		
		rule.addSlot(cmdSlot);
		rule.addSlot(nameSlot);
		
		recognitionRules.add(rule);
	}
	
	public void addResponseRule(){
		responseRules.add("<" + SLOT_NAME_POEM_CMD +"><" + SLOT_NAME_POEM_NAME + ">");
	}
}
