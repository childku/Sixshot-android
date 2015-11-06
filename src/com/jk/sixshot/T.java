package com.jk.sixshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.reflections.Reflections;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.I;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.RuleSlot;
import com.jk.sixshot.organ.language.scene.Scene;

public class T {
	
	private StringBuffer slots = new StringBuffer();
	
	private StringBuffer rules = new StringBuffer();
	
	private StringBuffer values = new StringBuffer();
	
	private StringBuffer grammars = new StringBuffer();
	
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void analisys(List<Class> classes){
		AbstractDialog dialog = null;
		try {
			for(Class c : classes){
				
				dialog = (AbstractDialog<Scene>)c.newInstance();
				
				dialog.addAsks();
				dialog.addResponses();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Scene> scenes = new ArrayList<Scene>();
		scenes.add(Scene.SCENE_ARITHMETIC);
		scenes.add(Scene.SCENE_CHAT);
		scenes.add(Scene.SCENE_ENGLISH);
		scenes.add(Scene.SCENE_MOTION);
		scenes.add(Scene.SCENE_POEM);
		
		List<String> asks = null;
		List<Response> responses = null;
		String ress = "";
//		!start <rules>;
//		<rules>:
		
		rules.append("!start <rules>;\n");
		rules.append("<rules>:\n");
		rules.append(";\n");
		
		for(Scene scene : scenes){
			System.out.println("--------scene is " + scene.getSceneName());
			for(Rule rule :(List<Rule>)scene.getRecognitionRules()){
				System.out.println("    " + rule.getRule());
				rules.append(rule.getRule() + "|\n");
				for(RuleSlot ruleSlot :rule.getDistinctedRuleSlots()){
					
					System.out.println("      " + ruleSlot.getSlot().getName() + "  values: " + ruleSlot.getSlot().getValues());
					slots.append("!slot <" + ruleSlot.getSlot().getName() + ">;\n");
					String valuesString = ruleSlot.getSlot().getValues().toString();
					valuesString = valuesString.replace("[", "");
					valuesString = valuesString.replace("]", "");
					valuesString = valuesString.replace(", ", "|");
					
					values.append("<" + ruleSlot.getSlot().getName() + ">:" + valuesString + ";\n");
				}
			}
			scene.getResponses().entrySet();
			for(Entry<List<String>, List<Response>> e : (Set<Entry<List<String>, List<Response>>>)scene.getResponses().entrySet()){
				ress = "";
				asks = e.getKey();
				responses = e.getValue();
				System.out.println("--aaaaaa----asks is " + asks.toString());
				for(Response r : responses){
					ress = ress + "|" + r.getInstruction();
				}
				System.out.println("--------responses is " + ress);
				
			}
		}
		
		rules.append(";\n");
	}
	
	public void writeGrammar(){
		System.out.println(this.getClass().getResource("/"));
		System.out.println(System.getProperty("user.dir") + "/assets");
		String assetsPath = System.getProperty("user.dir") + "/assets/auto-grammar.bnf";
		File grammar = new File(assetsPath);
		
		try {
			grammars.append("#BNF+IAT 1.0 UTF-8;\n");
			grammars.append("!grammar sixshot;\n");
			grammars.append("\n");
			
	        if(!grammar.exists()){
	        	grammar.createNewFile();
	        }
	        FileOutputStream out=new FileOutputStream(grammar, false); //如果追加方式用true        
	        grammars.append(slots);
	        grammars.append("\n");
	        grammars.append(rules);
	        grammars.append("\n");
	        grammars.append(values);
	        out.write(grammars.toString().getBytes("utf-8"));//注意需要转换对应的字符集
	        out.close();
        } catch(IOException ex) {
            System.out.println(ex.getStackTrace());
        }
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String ...strings) throws InstantiationException, IllegalAccessException{
		T t = new T();
		List<Class> classes = t.getDialogClasses();
		t.analisys(classes);
		t.writeGrammar();
	}
	
	
	
}
