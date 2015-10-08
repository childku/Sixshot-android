package com.jk.sixshot.organ.language.scene.poem;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class PoemScene extends AbstractDialog{

	@Override
	public String getSceneName() {
		return Scene.SCENE_POEM;
	}
	
	protected String getRule(){
		return "背首|背个|背|背一个";
	}
	
	/**
	 * 人称#内容
	 */
	@Override
	protected abstract void setAsks();
	
	@Override
	public Rule generateRule() {
		return null;
	}
}
