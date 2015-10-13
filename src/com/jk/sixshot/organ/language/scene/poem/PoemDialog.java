package com.jk.sixshot.organ.language.scene.poem;

import com.jk.sixshot.organ.language.scene.AbstractDialog;

public abstract class PoemDialog extends AbstractDialog<PoemScene>{

	@Override
	public PoemScene getScene() {
		return new PoemScene();
	}
	
	public void addValue(String value){
		getScene().addValue(value);
	}

}
