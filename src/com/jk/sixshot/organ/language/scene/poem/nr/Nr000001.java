package com.jk.sixshot.organ.language.scene.poem.nr;

import com.jk.sixshot.organ.language.scene.poem.PoemScene;


public class Nr000001 extends PoemScene{

	@Override
	public void setAsks() {
		addValue(SLOT_NAME_POEM, "小老鼠");
	}

	@Override
	public void setAnswers() {
		answers.add("小老鼠上登台，偷油吃下不来。喵喵喵，猫来了，叽里咕噜滚下来！");
	}

}
