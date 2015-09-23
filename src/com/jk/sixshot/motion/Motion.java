package com.jk.sixshot.motion;

public class Motion
{
	public Motion(){
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
    	}else if("right".equals(direction)){
    		right();
    	}else if("stop".equals(direction)){
    		stop();
    	}else{
    		throw new IllegalArgumentException("不支持此种运动方式【" + direction+ "】");
    	}
    }

    static {
        System.loadLibrary("motion");
    }
}
