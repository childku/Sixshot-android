package com.jk.sixshot.organ.language.scene.arithmetic;

import com.jk.sixshot.organ.language.scene.AbstractDialog;

public abstract class ArithmeticDialog extends AbstractDialog<ArithmeticScene>{

	
	@Override
	public ArithmeticScene getScene() {
		return new ArithmeticScene();
	}

	public void addValue(String slotName, String value){
		getScene().addValue(slotName, value);
	}

}
