package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

public class Chat implements Scene {
	
	
	/**
	 * 语法规则
	 * * ：代表若干个
	 * _ ：代表一个
	 * {}：代表情景
	 * []：代表具体的情景
	 * 
	 * 例子
	 * 1. {你[chat]}叫什么
	 * 2. {你[chat]}你几岁了
	 */
	private List<String> rules = new ArrayList<String>();
	
	public Chat(){
		init();
	}
	
	private void init(){
		rules.add("你好");
		rules.add("豆豆");
		rules.add("{你[chat]}叫什么");
		rules.add("{你[chat]}几岁");
		rules.add("{你[chat]}多大");
		rules.add("{你[chat]}属啥");
		rules.add("{你[chat]}属什么");
		rules.add("{你[chat]}真笨");
		rules.add("{你[chat]}真棒");
		rules.add("{你[chat]}真聪明");
	}
	
	public String getName() {
		return "chat";
	}

	public List<Dialog> getAskAndAnswer() {
		// TODO Auto-generated method stub
		return null;
	}

}
