package com.jk.sixshot.organ.language.scene.arithmetic;

import com.jk.sixshot.organ.language.scene.AbstractScene;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public class ArithmeticScene extends AbstractScene<ArithmeticScene>{

	public static final String SLOT_NAME_CACULATE_CMD = "ca_cmd";
	
	public static final String SLOT_NAME_CACULATE_NUMBER = "ca_number";
	
	public static final String SLOT_NAME_CACULATE_RESULT = "ca_result";
	
	
	public ArithmeticScene(){
		super();
		
		addSlot(SLOT_NAME_CACULATE_CMD);
		addSlot(SLOT_NAME_CACULATE_NUMBER);
		addSlot(SLOT_NAME_CACULATE_RESULT);
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_NAME_ARITHMETIC;
	}

	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		
		RuleSlot n1Slot = new RuleSlot(getSlot(SLOT_NAME_CACULATE_NUMBER)); 
		RuleSlot cmdSlot = new RuleSlot(getSlot(SLOT_NAME_CACULATE_CMD));
		RuleSlot n2Slot = new RuleSlot( getSlot(SLOT_NAME_CACULATE_NUMBER)); 
		RuleSlot resultSlot = new RuleSlot(getSlot(SLOT_NAME_CACULATE_RESULT));
		
		rule.addRuleSlot(n1Slot);
		rule.addRuleSlot(cmdSlot);
		rule.addRuleSlot(n2Slot);
		rule.addRuleSlot(resultSlot);
		
		recognitionRules.add(rule);
		
		//TODO 3 加 3 呢？
	}

	public void addResponseRule(){
	}
}