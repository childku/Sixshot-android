package com.jk.sixshot.organ.language.scene.chat;

public class Chat000004 extends ChatScene{

	/**
	 * 人称#内容
	 */
	@Override
	public void addAsks() {
		addValue("几岁");
		addValue("多大");
	}

	@Override
	public void addResponse() {
		addResponse("我三岁了");
		addResponse("我三岁了，你呢？");
		addResponse("今年我三岁");
		addResponse("我已经三岁了，是个大孩子了！");
	}

}
