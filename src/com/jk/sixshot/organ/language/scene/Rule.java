package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	
	private List<RuleSlot> ruleSlots  = new ArrayList<RuleSlot>();
	

	public List<RuleSlot> getRuleSlots() {
		return ruleSlots;
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
			rule = rule + "-" + rs.getSlot().getName();
		}
		return rule;
	}

}
