package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.I;


public class Chat000001 extends ChatDialog implements I{

	@Override
	public void addAsks() {
		addValue("豆豆");
	}

	@Override
	public void addResponse() {
		addResponse("你好！");
		addResponse("诶，在！");
		addResponse("在呢！");
		addResponse("啥事？");
		addResponse("嗨，你好！");
	}

}
