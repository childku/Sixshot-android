package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class ChatDialog extends AbstractDialog<ChatScene>{

	
	@Override
	public ChatScene getScene() {
		return Scene.SCENE_CHAT;
	}

	public void addValue(String value){
		getScene().addValue(value);
	}

}
