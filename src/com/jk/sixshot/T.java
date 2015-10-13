package com.jk.sixshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Dialog;
import com.jk.sixshot.organ.language.scene.I;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;
import com.jk.sixshot.organ.language.scene.Slot;

public class T {
	// sceneName, rules ， 一个情景下可以有多个规则
	private Map<String, List<Rule>> rules = new HashMap<String, List<Rule>>();
	// slotName, slot
	private Map<String, Slot> slots = new HashMap<String, Slot>();
	
	/**
	 * 获取所有的对话
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Class> getDialogClasses(){
		Reflections reflections = new Reflections("com.jk.sixshot");
		
		Set clazzes = reflections.getSubTypesOf(I.class);
		
		List<Class> classes = new ArrayList<Class>(clazzes);
		
		System.out.println(" classes length :" + clazzes.size());
		for(Class c : classes){
			System.out.println(" class is :" + c.getName());
		}
		return classes;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void analisys(List<Class> classes){
		AbstractDialog dialog = null;
//		Dialog dia = null;
		try {
			for(Class c : classes){
				dialog = (AbstractDialog<Scene>)c.newInstance();
				
				dialog.getAsks();
				dialog.getResponses();
				
				Scene scene = ((Dialog<Scene>)dialog).getScene();
				addRules(scene.getSceneName(), scene.getRecognitionRules());
				addSlots(scene.getSlots());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(String scene : rules.keySet()){
			System.out.println("--------scene is " + scene);
			List<Rule> rs = rules.get(scene);
			for(Rule r : rs){
				System.out.println("    " + r.getRule());
			}
		}
	}
	
	private void addRules(String sceneName, List<Rule> rs){
		if(rules.containsKey(sceneName)){
			rules.get(sceneName).addAll(rs);
		}else{
			rules.put(sceneName, new ArrayList<Rule>(rs));
		}
	}
	
	private void addSlots(List<Slot> ss){
		for(Slot s : ss){
			if(slots.containsKey(s.getName())){
				slots.get(s.getName()).addValues(s.getValues());
			}else{
				Slot slot = new Slot();
				slot.setName(s.getName());
				slot.addValues(s.getValues());
				
				slots.put(s.getName(), slot);
			}
		}
	}
	public static void main(String ...strings) throws InstantiationException, IllegalAccessException{
		T t = new T();
		List<Class> classes = t.getDialogClasses();
		t.analisys(classes);
	}
}
