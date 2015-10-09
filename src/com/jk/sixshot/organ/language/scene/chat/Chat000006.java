package com.jk.sixshot.organ.language.scene.chat;

public class Chat000006 extends ChatScene{

	@Override
	public void setAsks() {
		addValue(SLOT_NAME_CHAT, "真笨");
	}

	@Override
	public void setAnswers() {
		answers.add("我才不笨呢！");
		answers.add("我才三岁，当然没你聪明了？");
		answers.add("也不是很笨，只是一点点");
		answers.add("看来我得多学习学习了");
	}

}
