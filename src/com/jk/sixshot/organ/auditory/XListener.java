package com.jk.sixshot.organ.auditory;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.GrammarListener;
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
	private String grammarPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/msc/test";
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
		buildGrammar();
	}
	
	private void buildGrammar(){
		String originGrammar = readFile("grammar.bnf", "utf-8");
		String grammar = new String(originGrammar);
		recognizer.setParameter(SpeechConstant.PARAMS, null);
		// 设置文本编码格式
		recognizer.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
		// 设置引擎类型
		recognizer.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
		// 设置语法构建路径
		recognizer.setParameter(ResourceUtil.GRM_BUILD_PATH, grammarPath);
		// 设置资源路径
		recognizer.setParameter(ResourceUtil.ASR_RES_PATH, getResourcePath());
		int result = recognizer.buildGrammar("bnf", grammar, new GrammarListener() {
			@Override
			public void onBuildFinish(String grammarId, SpeechError error) {
				if(error==null){
					System.out.println("语法构建成功：" + grammarId);
				}else{
					System.out.println("语法构建失败,错误码：" + error.getErrorCode());
				}
			}
		});
		if(result != ErrorCode.SUCCESS){
			System.out.println("语法构建失败,错误码：" + result);
		}
	}
	
	private String readFile(String file,String code)
	{
		int len = 0;
		byte []buf = null;
		String result = "";
		try {
			InputStream in = brain.getAssets().open(file);			
			len  = in.available();
			buf = new byte[len];
			in.read(buf, 0, len);
			
			result = new String(buf,code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@SuppressWarnings("static-access")
	private String parseGrammarResult(String json) {
		
		StringBuffer tip = null;
		StringBuffer result = new StringBuffer();
//		置信度
		int sc = 0;
		JSONTokener tokener = null;
		JSONObject jsonResult = null; 
		JSONArray words = null;
		String word = "";
		
		try {
			tokener = new JSONTokener(json);
			jsonResult = new JSONObject(tokener);
//			words
			words= jsonResult.getJSONArray("ws");
			for (int i = 0; i < words.length(); i++) {
				JSONObject wordItems = words.getJSONObject(i);
				JSONArray items = wordItems.getJSONArray("cw");
				//本地多候选按照置信度高低排序，一般选取第一个结果即可
				JSONObject obj = items.getJSONObject(0);
				
				word = obj.getString("w");
				if(word.contains("nomatch"))
				{
					return "";
				}
				result.append(word);
			}
			
			sc = jsonResult.getInt("sc");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(brain.config.getSystem().isDebug()){
			tip = new StringBuffer();
			tip.append(result);
			tip.append("【置信度】");
			tip.append(sc);
			System.out.println(tip.toString());
		}
		
		if(sc<40){
			return "";
		}
		System.out.println("----statement:" + result.toString());
		return result.toString();
	}
	
	/**
     * 识别监听器。
     */
    private RecognizerListener recognizerListener = new RecognizerListener() {
        
        public void onVolumeChanged(int volume) {
//        	System.out.println("当前正在说话，音量大小：" + volume);
        }
        
		@Override
		public void onResult(final RecognizerResult result, boolean isLast) {
			if (null != result && !TextUtils.isEmpty(result.getResultString())) {
				Log.d(TAG, "recognizer result：" + result.getResultString());
				String text = parseGrammarResult(result.getResultString());
				if("".equals(text.trim())){
					brain.setListenerIdle(true);
				}else{
					brain.analyze(text);
				}
			} else {
				Log.d(TAG, "recognizer result : null");
				brain.setListenerIdle(true);
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
			brain.setListenerIdle(true);
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
		recognizer.setParameter(ResourceUtil.GRM_BUILD_PATH, grammarPath);
		//设置返回结果格式
		recognizer.setParameter(SpeechConstant.RESULT_TYPE, resultType);
		//设置本地识别使用语法id
		recognizer.setParameter(SpeechConstant.LOCAL_GRAMMAR, "sixshot");
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
