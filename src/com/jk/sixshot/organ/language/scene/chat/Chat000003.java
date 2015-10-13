package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.I;

public class Chat000003 extends ChatDialog implements I{

	@Override
	public void addAsks() {
		addValue("叫什么");
	}

	@Override
	public void addResponse() {
		addResponse("我叫豆豆！");
		addResponse("我叫豆豆，黄豆的豆！");
		addResponse("我叫豆豆，你呢！？");
		addResponse("我叫豆豆。");
	}

}
