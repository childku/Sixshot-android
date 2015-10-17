package com.jk.sixshot.organ.language.scene;

import java.util.List;

/**
 * 对话
 * 
 * @author child
 *
 */
public interface Dialog<T> {

	/**
	 * 获取对话所属的情景
	 * 
	 * @return
	 */
	public T getScene();
	
	/**
	 * 获取问题
	 * 
	 * @return
	 */
	public List<String> getAsks();
	
	
}
