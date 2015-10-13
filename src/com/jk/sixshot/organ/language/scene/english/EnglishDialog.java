package com.jk.sixshot.organ.language.scene.english;

import com.jk.sixshot.organ.language.scene.AbstractDialog;

public abstract class EnglishDialog extends AbstractDialog<EnglishScene>{

	@Override
	public EnglishScene getScene() {
		return new EnglishScene();
	}
	
	public void addValue(String value){
		getScene().addValue(value);
	}

}
