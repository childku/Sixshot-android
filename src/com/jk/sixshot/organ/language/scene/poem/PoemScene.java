package com.jk.sixshot.organ.language.scene.poem;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public abstract class PoemScene extends AbstractDialog{

	protected String SLOT_NAME_POEM_CMD = "poem_cmd";
	
	protected String SLOT_NAME_POEM = "poem";
	
	public PoemScene(){
		addValue(SLOT_NAME_POEM_CMD, "背");
		addValue(SLOT_NAME_POEM_CMD, "背首");
		addValue(SLOT_NAME_POEM_CMD, "背一首");
		addValue(SLOT_NAME_POEM_CMD, "背个");
		addValue(SLOT_NAME_POEM_CMD, "背一个");
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_POEM;
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
