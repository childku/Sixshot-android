package com.jk.sixshot.organ.language.scene.chat;


public class Chat000001 extends ChatScene{

	/**
	 * 人称#内容
	 */
	
	@Override
	public void setAsks() {
		addValue("豆豆");
	}

	@Override
	public void setAnswers() {
		answers.add("你好！");
		answers.add("诶，在！");
		answers.add("在呢！");
		answers.add("啥事？");
		answers.add("嗨，你好！");
	}

}
