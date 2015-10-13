package com.jk.sixshot.organ.language.scene.motion;

import com.jk.sixshot.organ.language.scene.AbstractDialog;

public abstract class MotionDialog extends AbstractDialog<MotionScene>{

	@Override
	public MotionScene getScene() {
		return new MotionScene();
	}
	
	public void addValue(String value){
		getScene().addValue(value);
	}

	public void addValue(String slotName, String value){
		getScene().addValue(slotName, value);
	}
}
