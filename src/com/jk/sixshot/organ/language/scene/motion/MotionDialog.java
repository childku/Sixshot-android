package com.jk.sixshot.organ.language.scene.motion;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class MotionDialog extends AbstractDialog<MotionScene>{

	@Override
	public MotionScene getScene() {
		return Scene.SCENE_MOTION;
	}
	
	public void addValue(String value){
		addAsk(value);
		getScene().addValue(value);
	}

	public void addValue(String slotName, String value){
		getScene().addValue(slotName, value);
	}
}
