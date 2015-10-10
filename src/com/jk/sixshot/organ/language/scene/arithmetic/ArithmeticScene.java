package com.jk.sixshot.organ.language.scene.arithmetic;

import java.util.List;

import com.jk.sixshot.organ.language.scene.AbstractDialog;
import com.jk.sixshot.organ.language.scene.Rule;
import com.jk.sixshot.organ.language.scene.Scene;

public class ArithmeticScene extends AbstractDialog{

	protected String SLOT_NAME_CACULATE_CMD = "ca_cmd";
	
	protected String SLOT_NAME_CACULATE_NUMBER = "ca_number";
	
	protected String SLOT_NAME_CACULATE_RESULT = "ca_result";
	
	
	public ArithmeticScene(){
		addSlot(SLOT_NAME_CACULATE_CMD);
		addSlot(SLOT_NAME_CACULATE_NUMBER);
		addSlot(SLOT_NAME_CACULATE_RESULT);
		
	}
	
	@Override
	public String getSceneName() {
		return Scene.SCENE_ARITHMETIC;
	}

	@Override
	protected void setAsks() {
		addValue(SLOT_NAME_CACULATE_CMD, "加");
		addValue(SLOT_NAME_CACULATE_CMD, "加上");
		addValue(SLOT_NAME_CACULATE_CMD, "减");
		addValue(SLOT_NAME_CACULATE_CMD, "减去");
		addValue(SLOT_NAME_CACULATE_CMD, "乘");
		addValue(SLOT_NAME_CACULATE_CMD, "乘以");
		addValue(SLOT_NAME_CACULATE_CMD, "除");
		addValue(SLOT_NAME_CACULATE_CMD, "除以");
		
		
		addValue(SLOT_NAME_CACULATE_RESULT, "等于");
		addValue(SLOT_NAME_CACULATE_RESULT, "得");
		
		addValue(SLOT_NAME_CACULATE_NUMBER, "1");
		addValue(SLOT_NAME_CACULATE_NUMBER, "2");
		addValue(SLOT_NAME_CACULATE_NUMBER, "3");
		addValue(SLOT_NAME_CACULATE_NUMBER, "4");
		addValue(SLOT_NAME_CACULATE_NUMBER, "5");
		addValue(SLOT_NAME_CACULATE_NUMBER, "6");
		addValue(SLOT_NAME_CACULATE_NUMBER, "7");
		addValue(SLOT_NAME_CACULATE_NUMBER, "8");
		addValue(SLOT_NAME_CACULATE_NUMBER, "9");
		addValue(SLOT_NAME_CACULATE_NUMBER, "10");
		addValue(SLOT_NAME_CACULATE_NUMBER, "11");
		addValue(SLOT_NAME_CACULATE_NUMBER, "12");
		addValue(SLOT_NAME_CACULATE_NUMBER, "13");
		addValue(SLOT_NAME_CACULATE_NUMBER, "14");
		addValue(SLOT_NAME_CACULATE_NUMBER, "15");
		addValue(SLOT_NAME_CACULATE_NUMBER, "16");
		addValue(SLOT_NAME_CACULATE_NUMBER, "17");
		addValue(SLOT_NAME_CACULATE_NUMBER, "18");
		addValue(SLOT_NAME_CACULATE_NUMBER, "19");
		addValue(SLOT_NAME_CACULATE_NUMBER, "20");
		addValue(SLOT_NAME_CACULATE_NUMBER, "21");
		addValue(SLOT_NAME_CACULATE_NUMBER, "22");
		addValue(SLOT_NAME_CACULATE_NUMBER, "23");
		addValue(SLOT_NAME_CACULATE_NUMBER, "24");
		addValue(SLOT_NAME_CACULATE_NUMBER, "25");
		addValue(SLOT_NAME_CACULATE_NUMBER, "26");
		addValue(SLOT_NAME_CACULATE_NUMBER, "27");
		addValue(SLOT_NAME_CACULATE_NUMBER, "28");
		addValue(SLOT_NAME_CACULATE_NUMBER, "29");
		addValue(SLOT_NAME_CACULATE_NUMBER, "30");
		addValue(SLOT_NAME_CACULATE_NUMBER, "31");
		addValue(SLOT_NAME_CACULATE_NUMBER, "32");
		addValue(SLOT_NAME_CACULATE_NUMBER, "33");
		addValue(SLOT_NAME_CACULATE_NUMBER, "34");
		addValue(SLOT_NAME_CACULATE_NUMBER, "35");
		addValue(SLOT_NAME_CACULATE_NUMBER, "36");
		addValue(SLOT_NAME_CACULATE_NUMBER, "37");
		addValue(SLOT_NAME_CACULATE_NUMBER, "38");
		addValue(SLOT_NAME_CACULATE_NUMBER, "39");
		addValue(SLOT_NAME_CACULATE_NUMBER, "40");
		addValue(SLOT_NAME_CACULATE_NUMBER, "41");
		addValue(SLOT_NAME_CACULATE_NUMBER, "42");
		addValue(SLOT_NAME_CACULATE_NUMBER, "43");
		addValue(SLOT_NAME_CACULATE_NUMBER, "44");
		addValue(SLOT_NAME_CACULATE_NUMBER, "45");
		addValue(SLOT_NAME_CACULATE_NUMBER, "46");
		addValue(SLOT_NAME_CACULATE_NUMBER, "47");
		addValue(SLOT_NAME_CACULATE_NUMBER, "48");
		addValue(SLOT_NAME_CACULATE_NUMBER, "49");
		addValue(SLOT_NAME_CACULATE_NUMBER, "50");
		addValue(SLOT_NAME_CACULATE_NUMBER, "51");
		addValue(SLOT_NAME_CACULATE_NUMBER, "52");
		addValue(SLOT_NAME_CACULATE_NUMBER, "53");
		addValue(SLOT_NAME_CACULATE_NUMBER, "54");
		addValue(SLOT_NAME_CACULATE_NUMBER, "55");
		addValue(SLOT_NAME_CACULATE_NUMBER, "56");
		addValue(SLOT_NAME_CACULATE_NUMBER, "57");
		addValue(SLOT_NAME_CACULATE_NUMBER, "58");
		addValue(SLOT_NAME_CACULATE_NUMBER, "59");
		addValue(SLOT_NAME_CACULATE_NUMBER, "60");
		addValue(SLOT_NAME_CACULATE_NUMBER, "61");
		addValue(SLOT_NAME_CACULATE_NUMBER, "62");
		addValue(SLOT_NAME_CACULATE_NUMBER, "63");
		addValue(SLOT_NAME_CACULATE_NUMBER, "64");
		addValue(SLOT_NAME_CACULATE_NUMBER, "65");
		addValue(SLOT_NAME_CACULATE_NUMBER, "66");
		addValue(SLOT_NAME_CACULATE_NUMBER, "67");
		addValue(SLOT_NAME_CACULATE_NUMBER, "68");
		addValue(SLOT_NAME_CACULATE_NUMBER, "69");
		addValue(SLOT_NAME_CACULATE_NUMBER, "70");
		addValue(SLOT_NAME_CACULATE_NUMBER, "71");
		addValue(SLOT_NAME_CACULATE_NUMBER, "72");
		addValue(SLOT_NAME_CACULATE_NUMBER, "73");
		addValue(SLOT_NAME_CACULATE_NUMBER, "74");
		addValue(SLOT_NAME_CACULATE_NUMBER, "75");
		addValue(SLOT_NAME_CACULATE_NUMBER, "76");
		addValue(SLOT_NAME_CACULATE_NUMBER, "77");
		addValue(SLOT_NAME_CACULATE_NUMBER, "78");
		addValue(SLOT_NAME_CACULATE_NUMBER, "79");
		addValue(SLOT_NAME_CACULATE_NUMBER, "80");
		addValue(SLOT_NAME_CACULATE_NUMBER, "81");
		addValue(SLOT_NAME_CACULATE_NUMBER, "82");
		addValue(SLOT_NAME_CACULATE_NUMBER, "83");
		addValue(SLOT_NAME_CACULATE_NUMBER, "84");
		addValue(SLOT_NAME_CACULATE_NUMBER, "85");
		addValue(SLOT_NAME_CACULATE_NUMBER, "86");
		addValue(SLOT_NAME_CACULATE_NUMBER, "87");
		addValue(SLOT_NAME_CACULATE_NUMBER, "88");
		addValue(SLOT_NAME_CACULATE_NUMBER, "89");
		addValue(SLOT_NAME_CACULATE_NUMBER, "90");
		addValue(SLOT_NAME_CACULATE_NUMBER, "91");
		addValue(SLOT_NAME_CACULATE_NUMBER, "92");
		addValue(SLOT_NAME_CACULATE_NUMBER, "93");
		addValue(SLOT_NAME_CACULATE_NUMBER, "94");
		addValue(SLOT_NAME_CACULATE_NUMBER, "95");
		addValue(SLOT_NAME_CACULATE_NUMBER, "96");
		addValue(SLOT_NAME_CACULATE_NUMBER, "97");
		addValue(SLOT_NAME_CACULATE_NUMBER, "98");
		addValue(SLOT_NAME_CACULATE_NUMBER, "99");
		addValue(SLOT_NAME_CACULATE_NUMBER, "100");
	}
	
	protected void setAnswers() {
		
	}
	
	public List<String> getAnswers(String statement){
		//TODO 运算逻辑
		return null;
	}

	@Override
	public Rule generateRule() {
		Rule rule = new Rule();
		rule.setRule("<" + SLOT_NAME_CACULATE_NUMBER  + "><" + SLOT_NAME_CACULATE_CMD + "><" + SLOT_NAME_CACULATE_NUMBER + "><" + SLOT_NAME_CACULATE_RESULT + ">");
		return rule;
	}
}