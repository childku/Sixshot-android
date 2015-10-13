package com.jk.sixshot.organ.language.scene.motion;

import com.jk.sixshot.organ.language.scene.AbstractScene;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public class MotionScene extends AbstractScene<MotionScene>{

	public static final String SLOT_NAME_MOTION_PARTICLE = "mo_particle";
	
	public static final String SLOT_NAME_MOTION_DIRECTION = "mo_direction";
	
	public static final String SLOT_NAME_MOTION_CMD = "mo_cmd";
	
	public static final String SLOT_NAME_MOTION_SIGNLE_CMD = "mo_signle_cmd";
	
	public MotionScene(){
		super();
		
		addValue(SLOT_NAME_MOTION_PARTICLE, "往");
		addValue(SLOT_NAME_MOTION_PARTICLE, "向");
		
		addValue(SLOT_NAME_MOTION_DIRECTION, "前");
		addValue(SLOT_NAME_MOTION_DIRECTION, "后");		
		addValue(SLOT_NAME_MOTION_DIRECTION, "左");
		addValue(SLOT_NAME_MOTION_DIRECTION, "右");
		
		addValue(SLOT_NAME_MOTION_CMD, "走");
		
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "过来");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "停");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "停下");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "停下来");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "行");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "行了");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "好");
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, "好了");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_NAME_MOTION;
	}

	
	public void addValue(String value) {
		addValue(SLOT_NAME_MOTION_SIGNLE_CMD, value);
		
	}
	
	@Override
	public void addRecogntionRule() {
		Rule rule = new Rule();
		
		RuleSlot particleSlot = new RuleSlot(getSlot(SLOT_NAME_MOTION_PARTICLE)); 
		RuleSlot directionSlot = new RuleSlot(getSlot(SLOT_NAME_MOTION_DIRECTION)); 
		RuleSlot cmdSlot = new RuleSlot(true, getSlot(SLOT_NAME_MOTION_CMD)); 
		
		rule.addSlot(particleSlot);
		rule.addSlot(directionSlot);
		rule.addSlot(cmdSlot);
		
		recognitionRules.add(rule);
		
		//单独命令规则，TODO 需要确认语境
		rule = new Rule();
		
		RuleSlot signelSlot = new RuleSlot(getSlot(SLOT_NAME_MOTION_SIGNLE_CMD)); 
		
		rule.addSlot(signelSlot);
		
		recognitionRules.add(rule);
	}
	
	public void addResponseRule(){
	}

}
