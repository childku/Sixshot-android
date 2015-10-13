package com.jk.sixshot.organ.language.scene;

import java.util.List;

import com.jk.sixshot.organ.language.scene.arithmetic.ArithmeticScene;
import com.jk.sixshot.organ.language.scene.chat.ChatScene;
import com.jk.sixshot.organ.language.scene.english.EnglishScene;
import com.jk.sixshot.organ.language.scene.motion.MotionScene;
import com.jk.sixshot.organ.language.scene.poem.PoemScene;

public interface Scene<T> {
	
	public String SCENE_NAME_CHAT = "chat";
	public String SCENE_NAME_POEM = "poem";
	public String SCENE_NAME_ARITHMETIC = "arithmetic";
	public String SCENE_NAME_ENGLISH = "englisth";
	public String SCENE_NAME_MOTION = "motion";
	
	
	public static final ChatScene SCENE_CHAT = new ChatScene();
	public Scene<PoemScene> SCENE_POEM = new PoemScene();
	public Scene<ArithmeticScene> SCENE_ARITHMETIC = new ArithmeticScene();
	public Scene<EnglishScene> SCENE_ENGLISH = new EnglishScene();
	public Scene<MotionScene> SCENE_MOTION = new MotionScene();
	/**
	 * 获取情景名称
	 * 
	 * @return
	 */
	public String getSceneName();
	
	public void addValue(String slotName, String value);
	
	public Slot getSlot(String slotName);
	
	public List<Slot> getSlots();
	
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
