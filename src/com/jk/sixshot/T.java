package com.jk.sixshot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import com.jk.sixshot.organ.language.scene.I;

public class T {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String ...strings) throws InstantiationException, IllegalAccessException{

		Reflections reflections = new Reflections("com.jk.sixshot");
		
		Set clazzes = reflections.getSubTypesOf(I.class);
		System.out.println(" clazzes length :" + clazzes.size());
		Iterator<Class> it = clazzes.iterator();  
		while (it.hasNext()) {  
		  Class c = it.next();  
		  System.out.println(" class is :" + c.getName());
//		  Class[] is = c.getInterfaces();
//		  if(gg(c.getInterfaces())){
//			  System.out.println(" class is :" + c.getName());
//		  }
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean gg(Class[] interfaces){
		String interfaceName = I.class.getName();
//		System.out.println("--interfaceName is " + interfaceName);
		for(Class i : interfaces){
//			System.out.println("--inner interfaceName is " + i.getName());
			if(i.getName().equals(interfaceName)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取所有的对话
	 * 
	 * @return
	 */
	public List<Class> getDialogClasses(){
		Reflections reflections = new Reflections("com.jk.sixshot");
		
		Set clazzes = reflections.getSubTypesOf(I.class);
		
		List<Class> classes = new ArrayList<Class>(clazzes);
		return classes;
	}
}
