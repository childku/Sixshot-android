package com.jk.sixshot.organ.language.scene.arithmetic;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class ArithmeticDialog extends AbstractDialog<ArithmeticScene>{

	
	@Override
	public ArithmeticScene getScene() {
		return Scene.SCENE_ARITHMETIC;
	}

	public void addValue(String slotName, String value){
		getScene().addValue(slotName, value);
	}

}
