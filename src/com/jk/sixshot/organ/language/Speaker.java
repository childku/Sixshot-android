package com.jk.sixshot.organ.language;

import com.jk.sixshot.Sixshot;
import com.sinovoice.hcicloudsdk.android.tts.player.TTSPlayer;
import com.sinovoice.hcicloudsdk.common.hwr.HwrInitParam;
import com.sinovoice.hcicloudsdk.common.tts.TtsConfig;
import com.sinovoice.hcicloudsdk.common.tts.TtsInitParam;
import com.sinovoice.hcicloudsdk.player.TTSCommonPlayer.PlayerEvent;
import com.sinovoice.hcicloudsdk.player.TTSPlayerListener;
public class Speaker {

	//TTS Player
	private TTSPlayer ttsPlayer = null;
	
	//TTS 配置
	private TtsConfig ttsConfig;
	
	private Sixshot brain = null;
	
	public Speaker(){
		init();
	}
	
	public Speaker(Sixshot brain){
		this.brain = brain;
		init();
	}

	private void init(){
		initTtsPlayer();
		initTtsConfig();
	}
	
	//TTS Player 初始化
	private  void  initTtsPlayer(){
		
		String dataPath = brain.getFilesDir().getAbsolutePath().replace("files", "lib");
		ttsPlayer =new TTSPlayer();
		TtsInitParam ttsInitParam = new TtsInitParam();
		//本地音库路径
    	ttsInitParam.addParam(TtsInitParam.PARAM_KEY_DATA_PATH, dataPath);
    	ttsInitParam.addParam(TtsInitParam.PARAM_KEY_INIT_CAP_KEYS, Sixshot.config.getVoice().getTtsCapKey());
    	ttsInitParam.addParam(HwrInitParam.PARAM_KEY_FILE_FLAG, "android_so");
    	//播放器初始化
    	ttsPlayer.init(ttsInitParam.getStringConfig(), new PlayerListener());
    	if(ttsPlayer.getPlayerState() != TTSPlayer.PLAYER_STATE_IDLE){
    		System.out.println("TTS Player 初始化失败！");
    	}
	}
	
	private void initTtsConfig(){
		ttsConfig = new TtsConfig();
		//音频格式
//		ttsConfig.addParam(TtsConfig.PARAM_KEY_ADUIO_FORMAT, "pcm16k16bit");
		ttsConfig.addParam(TtsConfig.PARAM_KEY_AUDIO_FORMAT, "pcm16k16bit");
		//tts.local.xixi.v6
		//所使用能力
		ttsConfig.addParam(TtsConfig.PARAM_KEY_CAP_KEY, Sixshot.config.getVoice().getTtsCapKey());
		
		//播放速度
		ttsConfig.addParam(TtsConfig.PARAM_KEY_SPEED, "1");
		//编码格式
		ttsConfig.addParam(TtsConfig.PARAM_KEY_ENCODE, "none");
		
		System.out.println("---speaker, ttsConfig: " + ttsConfig.getStringConfig());
	}
	
	public void speak(String text){
		try{
			ttsPlayer.play(text, ttsConfig.getStringConfig());
		}catch(IllegalStateException e){
			e.printStackTrace();
		}
	}
	
	//播放器回调接口
	private class PlayerListener implements TTSPlayerListener{

		//错误信息回调
		@Override
		public void onPlayerEventPlayerError(PlayerEvent playerEvent, int errorCode) {
			System.out.println(" speaker 程序已出错，错误码为" + errorCode);
		}

		//播放进度回调
		@Override
		public void onPlayerEventProgressChange(PlayerEvent playerEvent, int start, int end) {
		}
		
		//状态改变回调
		@Override
		public void onPlayerEventStateChange(PlayerEvent playerEvent) {
			if(playerEvent == PlayerEvent.PLAYER_EVENT_BEGIN){
				System.out.println("---in speaker , 开始说话 ");
			}else if(playerEvent == PlayerEvent.PLAYER_EVENT_END){
				System.out.println("---in speaker , 话已说完 ");
				brain.weakup();
			}		
		}		
	}
    
}
