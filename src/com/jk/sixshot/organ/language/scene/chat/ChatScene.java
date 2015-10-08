package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class ChatScene extends AbstractDialog{

	@Override
	public String getSceneName() {
		return Scene.SCENE_CHAT;
	}

	/**
	 * 人称#内容
	 */
	@Override
	protected abstract void setAsks();
	
	
}
