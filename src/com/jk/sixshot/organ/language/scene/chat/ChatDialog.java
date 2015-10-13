package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.AbstractDialog;

public abstract class ChatDialog extends AbstractDialog<ChatScene>{

	
	@Override
	public ChatScene getScene() {
		return new ChatScene();
	}

	public void addValue(String value){
		getScene().addValue(value);
	}

}
