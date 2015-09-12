package com.jk.sixshot.organ.auditory;

import java.io.IOException;
import java.io.InputStream;

import android.util.Log;

import com.jk.sixshot.Sixshot;
import com.sinovoice.hcicloudsdk.android.asr.recorder.ASRRecorder;
import com.sinovoice.hcicloudsdk.common.asr.AsrConfig;
import com.sinovoice.hcicloudsdk.common.asr.AsrGrammarId;
import com.sinovoice.hcicloudsdk.common.asr.AsrInitParam;
import com.sinovoice.hcicloudsdk.common.asr.AsrRecogItem;
import com.sinovoice.hcicloudsdk.common.asr.AsrRecogResult;
import com.sinovoice.hcicloudsdk.recorder.ASRCommonRecorder;
import com.sinovoice.hcicloudsdk.recorder.ASRCommonRecorder.RecorderEvent;
import com.sinovoice.hcicloudsdk.recorder.ASRRecorderListener;

public class JListener {
	private static final String TAG = "Listener";
	
	private ASRRecorder recorder = new ASRRecorder();
	
	private AsrConfig asrConfig = new AsrConfig();
	
	private String grammar = null;
	
	private Sixshot brain = null;
	
	public JListener(Sixshot brain){
		this.brain = brain;
		init();
	}
	
	private void init(){
		initRecorder();
	}
	
	
	private String loadGrammar(String fileName) {
		String grammar = "";
		try {
			InputStream is = null;
			try {
				is = brain.getAssets().open(fileName);
				byte[] data = new byte[is.available()];
				is.read(data);
				grammar = new String(data);
			} finally {
				is.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return grammar;
	}
	
    @SuppressWarnings("static-access")
	private void initRecorder(){
    	// 初始化录音机
		recorder = new ASRRecorder();

		// 配置初始化参数
		AsrInitParam asrInitParam = new AsrInitParam();
		String dataPath = brain.getFilesDir().getPath().replace("files", "lib");
		asrInitParam.addParam(AsrInitParam.PARAM_KEY_INIT_CAP_KEYS, Sixshot.config.getVoice().getAsrCapKey());
		asrInitParam.addParam(AsrInitParam.PARAM_KEY_DATA_PATH, dataPath);
		asrInitParam.addParam(AsrInitParam.PARAM_KEY_FILE_FLAG, "android_so");
		Log.v(TAG, "init parameters:" + asrInitParam.getStringConfig());

		// 设置初始化参数
		recorder.init(asrInitParam.getStringConfig(), new RecorderListener());

		// 配置识别参数
		// PARAM_KEY_CAP_KEY 设置使用的能力
		asrConfig.addParam(AsrConfig.PARAM_KEY_CAP_KEY, Sixshot.config.getVoice().getAsrCapKey());
		// PARAM_KEY_AUDIO_FORMAT 音频格式根据不同的能力使用不用的音频格式
		asrConfig.addParam(AsrConfig.PARAM_KEY_AUDIO_FORMAT, AsrConfig.HCI_ASR_AUDIO_FORMAT_PCM_16K16BIT);
		// PARAM_KEY_ENCODE 音频编码压缩格式，使用OPUS可以有效减小数据流量
		asrConfig.addParam(AsrConfig.PARAM_KEY_ENCODE, "opus");
		// 其他配置，此处可以全部选取缺省值
		asrConfig.addParam(AsrConfig.PARAM_KEY_CAND_NUM, "3");
		
		asrConfig.addParam(AsrConfig.PARAM_KEY_VAD_HEAD, "2000");
		
		if(recorder.getRecorderState() != ASRCommonRecorder.RECORDER_STATE_IDLE){
			System.out.println("---listener, 初始化失败了！");
    	}
		
		
		if (Sixshot.config.getVoice().getAsrCapKey().startsWith("asr.local.grammar")) {
			grammar = loadGrammar("words.txt");
			// 加载本地语法获取语法ID
			AsrGrammarId id = new AsrGrammarId();
			recorder.loadGrammar("grammarType=wordlist", grammar, id);
//			ASRRecorder.loadGrammar("path", grammar, id);

			// PARAM_KEY_GRAMMAR_TYPE 语法类型，使用自由说能力时，忽略以下此参数
			asrConfig.addParam(AsrConfig.PARAM_KEY_GRAMMAR_TYPE, AsrConfig.HCI_ASR_GRAMMAR_TYPE_ID);
			asrConfig.addParam(AsrConfig.PARAM_KEY_GRAMMAR_ID, id.getGrammarId() + "");
		}
		
    }
    
	
    public void listen(){
		listening();
    }
    
	
	private void listening(){
		System.out.println("---in listener， recorder state is : " + recorder.getRecorderState());
		if(recorder.getRecorderState() == ASRCommonRecorder.RECORDER_STATE_IDLE){
			try {
				recorder.start(asrConfig.getStringConfig(), null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			throw new RuntimeException("---listener, listener 忙");
		}
	}
	
	private class RecorderListener implements ASRRecorderListener{

		@Override
		public void onRecorderEventError(RecorderEvent recorderEvent, int errorCode) {
			System.out.println("---listener, 出现错误，错误码为" + errorCode);
		}

		//识别完成回调
		@Override
		public void onRecorderEventRecogFinsh(RecorderEvent event, AsrRecogResult result) {
			if(result == null){
				System.out.println("错误：返回结果集为空");	
				return;
			}
			
			String statements = "";
			//识别结果显示
			if(result.getRecogItemList().isEmpty()){
				System.out.println("识别结束,没有识别结果");
				brain.setListenerIdle(true);
				return;
			}else {
				System.out.println("----------识别结果-begin--------------------------------------");
				if(result.getRecogItemList().size()==1){
					statements = result.getRecogItemList().get(0).getRecogResult();
					if(statements.trim().equals("")){
						brain.setListenerIdle(true);
						return;
					}
				}else{
					for(AsrRecogItem item: result.getRecogItemList()){
						statements = statements + "-" + item.getRecogResult();
					}
				}
				System.out.println("----------识别结果: " + statements);
				brain.analyze(statements);
				System.out.println("----------识别结果-end----------------------------------------");
			}
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//状态改变回调
		@Override
		public void onRecorderEventStateChange(RecorderEvent event) {
//			System.out.println("---listener, event state ：" + event);
			try {
				if(event == RecorderEvent.RECORDER_EVENT_BEGIN_RECORD){
					Thread.sleep(500);
					System.out.println("开始录音");
				}else if(event == RecorderEvent.RECORDER_EVENT_BEGIN_RECOGNIZE){
					Thread.sleep(500);
					System.out.println("开始识别");
				}else if(event == RecorderEvent.RECORDER_EVENT_NO_VOICE_INPUT){
					Thread.sleep(100);
					System.out.println("无音频输入");
					brain.setListenerIdle(true);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void onRecorderRecording(byte[] volumedata ,int volume){
			
		}

		public void onRecorderEventRecogProcess(RecorderEvent arg0,	AsrRecogResult arg1) {
			
		}
	}

}