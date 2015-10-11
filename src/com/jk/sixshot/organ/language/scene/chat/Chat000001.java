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
		addResponse("你好！");
		addResponse("诶，在！");
		addResponse("在呢！");
		addResponse("啥事？");
		addResponse("嗨，你好！");
	}

}
