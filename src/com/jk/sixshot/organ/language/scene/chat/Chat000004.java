package com.jk.sixshot.organ.language.scene.chat;

public class Chat000004 extends ChatScene{

	/**
	 * 人称#内容
	 */
	@Override
	public void setAsks() {
		addValue("几岁");
		addValue("多大");
	}

	@Override
	public void setAnswers() {
		answers.add("我三岁了");
		answers.add("我三岁了，你呢？");
		answers.add("今年我三岁");
		answers.add("我已经三岁了，是个大孩子了！");
	}

}
