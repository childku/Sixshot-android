package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.I;

public class Chat000006 extends ChatDialog implements I{

	@Override
	public void addAsks() {
		addValue("真笨");
	}

	@Override
	public void addResponse() {
		addResponse("我才不笨呢！");
		addResponse("我才三岁，当然没你聪明了？");
		addResponse("也不是很笨，只是一点点");
		addResponse("看来我得多学习学习了");
	}

}
