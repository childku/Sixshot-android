package com.jk.sixshot.motion;

import com.jk.sixshot.Sixshot;

public class Motion
{
	private Sixshot brain;
	public Motion(Sixshot brain){
		this.brain = brain;
		initMotion();
	}
    private void initMotion() {
        init();
    }

    public native void  init();
    
    public native void  forward();
    public native void  backward();
    public native void  left();
    public native void  right();
    public native void  stop();
    
    public void move(String direction){
    	if("forward".equals(direction)){
    		forward();
    	}else if("backward".equals(direction)){
    		backward();
    	}else if("left".equals(direction)){
    		left();
    		try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		forward();
    	}else if("right".equals(direction)){
    		right();
    		try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		forward();
    	}else if("stop".equals(direction)){
    		stop();
    	}else{
    		throw new IllegalArgumentException("不支持此种运动方式【" + direction+ "】");
    	}
    	brain.setListenerIdle(true);
    }

    static {
        System.loadLibrary("motion");
    }
}
