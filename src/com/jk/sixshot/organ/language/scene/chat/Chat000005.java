package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.I;

public class Chat000005 extends ChatDialog implements I{

	@Override
	public void addAsks() {
		addValue("属啥");
		addValue("属什么");
	}

	@Override
	public void addResponse() {
		addResponse("我属兔");
		addResponse("我属兔的，小白兔的兔？");
		addResponse("我属小白兔的");
		addResponse("我属兔子的，你呢？");
	}

}
