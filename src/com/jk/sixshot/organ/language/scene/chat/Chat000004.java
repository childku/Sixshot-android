package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.Scene;


public class Chat000004 extends ChatScene{

	/**
	 * 人称#内容
	 */
	@Override
	public void setAsks() {
		asks.add("{你[" + Scene.SCENE_CHAT + "]}#几岁|多大");
//		asks.add("{你[" + Scene.SCENE_CHAT + "]}多大");
	}

	@Override
	public void setAnswers() {
		answers.add("我三岁了");
		answers.add("我三岁了，你呢？");
		answers.add("今年我三岁");
		answers.add("我已经三岁了，是个大孩子了！");
	}

}
