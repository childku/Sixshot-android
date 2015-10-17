package com.jk.sixshot.organ.language.scene.english;

import com.jk.sixshot.organ.language.scene.AbstractScene;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public class EnglishScene extends AbstractScene<EnglishScene>{

	public static final String SLOT_NAME_ENGLISH_CMD = "en_cmd";
	
	public static final String SLOT_NAME_ENGLISH_STATEMENT = "en_st";
	
	public EnglishScene(){
		super();
		
		addValue(SLOT_NAME_ENGLISH_CMD, "怎么说");
		addValue(SLOT_NAME_ENGLISH_CMD, "用英语怎么说");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_NAME_ENGLISH;
	}
	
	
	public void addValue(String value){
		addValue(SLOT_NAME_ENGLISH_STATEMENT, value);
	}
	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		
		RuleSlot cmdSlot = new RuleSlot(true, getSlot(SLOT_NAME_ENGLISH_CMD)); 
		RuleSlot statementSlot = new RuleSlot(getSlot(SLOT_NAME_ENGLISH_STATEMENT)); 
		
		rule.addRuleSlot(cmdSlot);
		rule.addRuleSlot(statementSlot);
		
		recognitionRules.add(rule);
	}
	
	public void addResponseRule(){
		
	}

}
