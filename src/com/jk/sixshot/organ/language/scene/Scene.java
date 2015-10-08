package com.jk.sixshot.organ.language.scene;

import java.util.List;

public interface Scene {
	
	public String SCENE_CHAT = "chat";
	public String SCENE_POEM = "poem";
	public String SCENE_ARITHMETIC = "arithmetic";
	public String SCENE_ENGLISH = "englisth";
	public String SCENE_MOTION = "motion";
	
	/**
	 * 获取情景名称
	 * @return
	 */
	public String getName();

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
	public List<Dialog> getAskAndAnswer();
}
