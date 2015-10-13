package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.I;


public class Chat000002 extends ChatDialog implements I{

	@Override
	public void addAsks() {
		addValue("你好");
	}

	@Override
	public void addResponse() {
		addResponse("你好！");
		addResponse("你好呀！");
		addResponse("你好，我是豆豆！");
		addResponse("你好，有什么需要帮助的么？虽然我帮不了你太多。");
	}
}
