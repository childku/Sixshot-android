package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rule {
	
	private List<RuleSlot> ruleSlots  = new ArrayList<RuleSlot>();
	

	public List<RuleSlot> getRuleSlots() {
		return ruleSlots;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RuleSlot> getDistinctedRuleSlots() {
		Map<String, RuleSlot> map = new HashMap<String, RuleSlot>();
		for(RuleSlot rs : ruleSlots){
			map.put(rs.getSlot().getName(), rs);
		}
		
		return new ArrayList(map.values());
	}

	public void setRuleSlots(List<RuleSlot> ruleSlots) {
		this.ruleSlots = ruleSlots;
	}
	
	public void addRuleSlot(RuleSlot ruleSlot){
		ruleSlots.add(ruleSlot);
	}

	public String getRule() {
		String rule = "";
		for(RuleSlot rs : ruleSlots){
			if(rs.isOptional()){
				rule = rule + "[<" + rs.getSlot().getName() + ">]";
			}else{
				rule = rule + "<" + rs.getSlot().getName() + ">";
			}
		}
		return rule;
	}

}
