package com.jk.sixshot.organ.language.scene;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	
	private List<RuleSlot> slots  = new ArrayList<RuleSlot>();
	

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
		String rule = "";
		for(RuleSlot rs : slots){
			rule = rule + "-" + rs.getSlot().getName();
		}
		return rule;
	}

}
