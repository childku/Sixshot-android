package com.jk.sixshot.organ.language.scene.chat;

public class Chat000003 extends ChatScene{

	@Override
	public void setAsks() {
		addValue("叫什么");
	}

	@Override
	public void setAnswers() {
		addResponse("我叫豆豆！");
		addResponse("我叫豆豆，黄豆的豆！");
		addResponse("我叫豆豆，你呢！？");
		addResponse("我叫豆豆。");
	}

}
