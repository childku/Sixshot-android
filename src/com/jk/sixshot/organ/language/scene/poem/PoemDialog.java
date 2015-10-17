package com.jk.sixshot.organ.language.scene.poem;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class PoemDialog extends AbstractDialog<PoemScene>{

	@Override
	public PoemScene getScene() {
		return Scene.SCENE_POEM;
	}
	
	public void addValue(String value){
		getScene().addValue(value);
	}

}
