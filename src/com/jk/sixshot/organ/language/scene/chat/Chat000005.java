package com.jk.sixshot.organ.language.scene.chat;

public class Chat000005 extends ChatScene{

	@Override
	public void setAsks() {
		addValue("属啥");
		addValue("属什么");
	}

	@Override
	public void setAnswers() {
		answers.add("我属兔");
		answers.add("我属兔的，小白兔的兔？");
		answers.add("我属小白兔的");
		answers.add("我属兔子的，你呢？");
	}

}
