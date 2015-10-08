package com.jk.sixshot.organ.language.scene.arithmetic;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public class ArithmeticScene extends AbstractDialog{

	@Override
	public String getSceneName() {
		return Scene.SCENE_ARITHMETIC;
	}

	/**
	 * x加x#等于|得
	 */
//	@Override
//	protected abstract void setAsks();

	@Override
	protected void setAsks() {
		asks.add("{你[" + Scene.SCENE_CHAT + "]}#几岁|多大");		
	}
	
	protected void setAnswers() {
		
	}

	@Override
	public Rule generateRule() {
		return null;
	}
}