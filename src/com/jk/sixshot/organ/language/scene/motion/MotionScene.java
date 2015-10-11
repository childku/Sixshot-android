package com.jk.sixshot.organ.language.scene.motion;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class MotionScene extends AbstractDialog{

	protected String SLOT_NAME_MOTION_PARTICLE = "mo_particle";
	
	protected String SLOT_NAME_MOTION_DIRECTION = "mo_direction";
	
	protected String SLOT_NAME_MOTION_CMD = "mo_cmd";
	
	protected String SLOT_NAME_MOTION_SIGNLE_CMD = "mo_signle_cmd";
	
	public MotionScene(){
		addSlot(SLOT_NAME_MOTION_PARTICLE);
		addSlot(SLOT_NAME_MOTION_DIRECTION);
		addSlot(SLOT_NAME_MOTION_CMD);
		addSlot(SLOT_NAME_MOTION_SIGNLE_CMD);
		
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
		return Scene.SCENE_CHAT;
	}

	/**
	 * 人称#内容
	 */
	@Override
	protected abstract void setAsks();
	
//	protected void addValue(String value){
//		addValue(SLOT_NAME_CHAT, value);
//	}
	
	@Override
	public Rule generateRule() {
		Rule rule = new Rule();
		rule.setRule("<" + SLOT_NAME_MOTION_PARTICLE  + "><" + SLOT_NAME_MOTION_DIRECTION + ">[<" + SLOT_NAME_MOTION_CMD  + ">]|<" + SLOT_NAME_MOTION_SIGNLE_CMD + ">");
		return rule;
	}
}
