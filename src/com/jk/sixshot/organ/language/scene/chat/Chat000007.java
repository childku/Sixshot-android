package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.I;

public class Chat000007 extends ChatDialog implements I{

	@Override
	public void addAsks() {
		addValue("真棒");
		addValue("真聪明");
	}

	@Override
	public void addResponses() {
		addResponse("你也很棒！");
		addResponse("别夸奖我，我会不好意思的");
		addResponse("还差的远呢！");
		addResponse("还有努力的空间，我还要努力！");
	}

}