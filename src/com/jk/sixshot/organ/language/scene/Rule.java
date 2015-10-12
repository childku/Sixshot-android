package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	
	private List<RuleSlot> slots  = new ArrayList<RuleSlot>();
	
	private String rule;

	public List<RuleSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<RuleSlot> slots) {
		this.slots = slots;
	}
	
	public void addSlot(RuleSlot slot){
		slots.add(slot);
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}
	

}
