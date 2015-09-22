package com.jk.sixshot.motion;

public class Motion
{
	public Motion(){
		initMotion();
	}
    private void initMotion() {
        init();
//        forward();
//        backward();
//        left();
//        right();
//        stop();
    }

    public native void  init();
    
    public native void  forward();
    public native void  backward();
    public native void  left();
    public native void  right();
    public native void  stop();

    static {
        System.loadLibrary("motion");
    }
}
