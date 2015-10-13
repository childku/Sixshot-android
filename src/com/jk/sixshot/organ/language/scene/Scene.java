package com.jk.sixshot.organ.language.scene;

import java.util.List;

public interface Scene<T> {
	
	public String SCENE_CHAT = "chat";
	public String SCENE_POEM = "poem";
	public String SCENE_ARITHMETIC = "arithmetic";
	public String SCENE_ENGLISH = "englisth";
	public String SCENE_MOTION = "motion";
	
	/**
	 * 获取情景名称
	 * 
	 * @return
	 */
	public String getSceneName();
	
	public void addValue(String slotName, String value);
	
	/**
	 * 获取识别规则
	 * 
	 * @return
	 */
	public List<Rule> getRecognitionRules();
	
	/**
	 * 获取响应规则
	 * 
	 * @return
	 */
	public List<String> getResponseRules();

}
