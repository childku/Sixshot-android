package com.jk.sixshot.organ.auditory;

import util.JsonParser;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.util.ResourceUtil;
import com.iflytek.cloud.util.ResourceUtil.RESOURCE_TYPE;
import com.jk.sixshot.Sixshot;

public class XListener {
	private static String TAG = "x-listener";
	
	// 本地语法构建路径	
	private String grmPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/msc/test";
	// 返回结果格式 json
	private String resultType = "json";
	
	// 语音识别对象
	private SpeechRecognizer recognizer;
	 
	private Sixshot brain = null;
	
	public  XListener(Sixshot brain){
		this.brain  = brain;
		initListener();
	}
	
	/**
     * 初始化监听器。
     */
    private InitListener initListener = new InitListener() {
		public void onInit(int code) {
			if (code != ErrorCode.SUCCESS) {
        		System.out.println("初始化失败,错误码："+code);
        	}
		}
    };
	private void initListener(){
		// 初始化识别对象
		recognizer = SpeechRecognizer.createRecognizer(brain, initListener);	
	}
	
	/**
     * 识别监听器。
     */
    private RecognizerListener recognizerListener = new RecognizerListener() {
        
        public void onVolumeChanged(int volume) {
        	System.out.println("当前正在说话，音量大小：" + volume);
        }
        
		@Override
		public void onResult(final RecognizerResult result, boolean isLast) {
			if (null != result && !TextUtils.isEmpty(result.getResultString())) {
				Log.d(TAG, "recognizer result：" + result.getResultString());
				String text = JsonParser.parseGrammarResult(result.getResultString(), SpeechConstant.TYPE_LOCAL);
				// 显示
//				((EditText) findViewById(R.id.isr_text)).setText(text);
				System.out.println("-----result = " + text);
				brain.analyze(text);
			} else {
				Log.d(TAG, "recognizer result : null");
			}
		}
        
        @Override
        public void onEndOfSpeech() {
        	System.out.println("结束说话");
        }
        
        @Override
        public void onBeginOfSpeech() {
        	System.out.println("开始说话");
        }

		@Override
		public void onError(SpeechError error) {
			System.out.println("onError Code："	+ error.getErrorCode());
		}

		@Override
		public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
			
		}
    };
	
	public void listen(){
		// 清空参数
		recognizer.setParameter(SpeechConstant.PARAMS, null);
		//设置识别引擎
		recognizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
		//设置本地识别资源
		recognizer.setParameter(ResourceUtil.ASR_RES_PATH, getResourcePath());
		//设置语法构建路径
		recognizer.setParameter(ResourceUtil.GRM_BUILD_PATH, grmPath);
		//设置返回结果格式
		recognizer.setParameter(SpeechConstant.RESULT_TYPE, resultType);
		//设置本地识别使用语法id
		recognizer.setParameter(SpeechConstant.LOCAL_GRAMMAR, "poem");
		//设置识别的门限值
		recognizer.setParameter(SpeechConstant.MIXED_THRESHOLD, "30");
		
		int ret = recognizer.startListening(recognizerListener);
		if (ret != ErrorCode.SUCCESS) {
			System.out.println("识别失败,错误码: " + ret);	
		}
	}
	
	//获取识别资源路径
	private String getResourcePath(){
		StringBuffer tempBuffer = new StringBuffer();
		//识别通用资源
		tempBuffer.append(ResourceUtil.generateResourcePath(brain, RESOURCE_TYPE.assets, "asr/common.jet"));
		return tempBuffer.toString();
	}
}
