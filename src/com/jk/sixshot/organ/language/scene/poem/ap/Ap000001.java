package com.jk.sixshot.organ.language.scene.poem.ap;

import com.jk.sixshot.organ.language.scene.I;
import com.jk.sixshot.organ.language.scene.poem.PoemDialog;


public class Ap000001 extends PoemDialog implements I{

	@Override
	public void addAsks() {
		addValue("登鹳雀楼");
	}

	@Override
	public void addResponse() {
		addResponse("《登鹳雀楼》，作者：盛唐诗人，王之涣。白日依山尽，黄河入海流。欲穷千里目，更上一层楼。");
	}

}
