package com.jk.sixshot.organ.language.scene.chat;

import com.jk.sixshot.organ.language.scene.Scene;


public class Chat000007 extends ChatScene{

	@Override
	public void setAsks() {
		asks.add("{你[" + Scene.SCENE_CHAT + "]}#真棒|真聪明");
//		asks.add("{你[" + Scene.SCENE_CHAT + "]}真聪明");
	}

	@Override
	public void setAnswers() {
		answers.add("你也很棒！");
		answers.add("别夸奖我，我会不好意思的");
		answers.add("还差的远呢！");
		answers.add("还有努力的空间，我还要努力！");
	}

}