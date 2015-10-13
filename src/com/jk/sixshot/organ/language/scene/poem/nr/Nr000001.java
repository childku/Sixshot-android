package com.jk.sixshot.organ.language.scene.poem.nr;

import com.jk.sixshot.organ.language.scene.I;
import com.jk.sixshot.organ.language.scene.poem.PoemDialog;


public class Nr000001 extends PoemDialog implements I{

	@Override
	public void addAsks() {
		addValue("小老鼠");
	}

	@Override
	public void addResponse() {
		addResponse("小老鼠上登台，偷油吃下不来。喵喵喵，猫来了，叽里咕噜滚下来！");
	}

}
