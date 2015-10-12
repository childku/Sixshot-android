package com.jk.sixshot.organ.language.scene;

public class RuleSlot {
	
	/**
	 * 是否可选
	 */
	private boolean optional = false;
	
	private Slot slot;
	
	public RuleSlot(Slot slot){
		this.slot = slot;
	}
	
	public RuleSlot(boolean optional, Slot slot){
		this.optional = optional;
		this.slot = slot;
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	
}
