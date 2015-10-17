package com.jk.sixshot.organ.language.scene.english;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class EnglishDialog extends AbstractDialog<EnglishScene>{

	@Override
	public EnglishScene getScene() {
		return Scene.SCENE_ENGLISH;
	}
	
	public void addValue(String value){
		getScene().addValue(value);
	}

}
