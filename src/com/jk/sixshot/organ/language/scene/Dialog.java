package com.jk.sixshot.organ.language.scene;

import java.util.List;

/**
 * 对话
 * @author child
 *
 */
public interface Dialog {

	/**
	 * 获取情景名称
	 * @return
	 */
	public String getSceneName();
	
	/**
	 * 语法规则
	 * * ：代表若干个
	 * _ ：代表一个
	 * {}：代表情景
	 * []：代表具体的情景
	 * | ：代表 "或"
	 * 
	 * 例子
	 * 1. {你[chat]}叫什么
	 * 2. {你[chat]}你几岁了
	 */
	public List<String> getAsks();
	
	public List<String> getAnswers();
	
	/**
	 * 生成规则
	 * 
	 * @return
	 */
	public Rule generateRule();
}
