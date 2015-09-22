package com.jk.sixshot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.jk.sixshot.motion.Motion;
import com.jk.sixshot.organ.auditory.XListener;
import com.jk.sixshot.organ.language.Speaker;
import com.jk.sixshot.organ.language.StatementAnalyzer;
import com.jk.sixshot.util.ShellUtils;
import com.jk.sixshot.util.ShellUtils.CommandResult;
import com.sinovoice.hcicloudsdk.api.HciCloudSys;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import com.sinovoice.hcicloudsdk.common.InitParam;

public class Sixshot extends Activity {

	public static Configuration config = null;
	
	private XListener  listener = null;
	private StatementAnalyzer analyzer = new StatementAnalyzer();
	private Speaker speaker = null;
	
	private boolean listenerIdle = true;
	
	private Motion motion = null;
	
	public Sixshot(){
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// 设置你申请的应用appid
		StringBuffer param = new StringBuffer();
		param.append("appid=5423b564");
		param.append(",");
		// 设置使用v5+
		param.append(SpeechConstant.ENGINE_MODE+"="+SpeechConstant.MODE_MSC);
		SpeechUtility.createUtility(this, param.toString());
		
		super.onCreate(savedInstanceState);
		init();
		try{
			 Timer timer = new Timer();  
		     // 在1秒后执行此任务,每次间隔2秒,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.  
		     timer.schedule(new Task(this), 1000, 1500);
		}catch(Exception e){
			e.printStackTrace();
			if(e.getMessage().equals("什么也没说")){
				System.out.println("---engine, 什么也没说，重新唤醒" );
				this.weakup();
			}
		}
	}
	private void init() {
		
		config = new Configuration(this);
		initView();
		initEngine();
		auth();
		initMotionSystem();
		initListener();
		initSpeaker();
	}
	
	private void initMotionSystem(){
		motion = new Motion();
		motion.forward();
		motion.backward();
		motion.left();
		motion.right();
		motion.stop();
		
	}
	
	private void run(){
		System.out.println("------to running............");
		String dir = "/sys/class/gpio/gpio97";
		String command = " echo 1 > value ";
		
//		exe(dir, command);

//		List<String> commands = new ArrayList<String>();
//		commands.add("echo 1 > sys/class/gpio/gpio97/value ");
//		CommandResult result =  ShellUtils.execCommand(commands, true);
//		System.out.println("----result.errorMsg:" + result.errorMsg + "----result.successMsg:" + result.successMsg);
		 DataOutputStream os = null;
	        try {
//	        	Process process = Runtime.getRuntime().exec(new String[]{"su", "echo 1 > sys/class/gpio/gpio97/value"});
//	        	Process process = Runtime.getRuntime().exec(new String[]{"su", "ls"});
//	        	Process process = Runtime.getRuntime().exec(new String[]{"ls"});
	        	Process process = Runtime.getRuntime().exec("su -c 'echo $PATH'", null, new File("sys/class/gpio/gpio97"));
//	            os = new DataOutputStream(process.getOutputStream());
//	            os.write("ls".getBytes());
//	            os.writeBytes("\n");
//	            os.flush();
//	            
//	            os.writeBytes("exit\n");
//	            os.flush();
	            
	        	int waitfor = process.waitFor();
	        	System.out.println("----shell waitfor:" + waitfor);
	            BufferedReader success_in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            StringBuffer successBuffer = new StringBuffer();
	            String line = null;
	            while ((line = success_in.readLine()) != null) {
	                successBuffer.append(line+"-");
	            }
	            
	            BufferedReader error_in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	            StringBuffer errorBuffer = new StringBuffer();
	            while ((line = error_in.readLine()) != null) {
	            	errorBuffer.append(line+"-");
	            }
	            
	            System.out.println("----shell result:" + successBuffer.toString());
	            
	            System.out.println("----shell error:" + errorBuffer.toString());
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	}
	
	private void stop(){
		System.out.println("------to stop............");
		String dir = "/sys/class/gpio/gpio97";
		String command = " echo 0 > value ";
		
//		exe(dir, command);
		
		 DataOutputStream os = null;
	        try {
//	        	Process process = Runtime.getRuntime().exec(new String[]{"su", "echo 0 > sys/class/gpio/gpio97/value"});
	        	Process process = Runtime.getRuntime().exec("su -c 'echo 0 > value'", null, new File("sys/class/gpio/gpio97"));
	            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	            StringBuffer stringBuffer = new StringBuffer();
	            String line = null;
	            while ((line = in.readLine()) != null) {
	                stringBuffer.append(line+"-");
	            }
	            System.out.println("----shell result:" + stringBuffer.toString());
	        }catch(Exception e){
	        	e.printStackTrace();
	        }
	}
	
	private void exe(String dir, String ...command){
        Runtime runtime = Runtime.getRuntime();
        Process proc = null;

        File directory = new File(dir);
        String commands[] = new String[command.length + 3];
//        String[] cmdline = { "sh", "-c", "echo $BOOTCLASSPATH" }; 
        commands[0] = " su ";
        commands[1] = " sh ";
        commands[2] = " -c ";
        
        StringBuilder cmds = new StringBuilder();
        
        for(int i = 0; i < command.length; i++){
        	commands[i + 3] = " \"" + command[i] + "\"";
        }
        
        for(int i = 0; i < commands.length; i++){
        	cmds.append(commands[i]);
//        	cmds.append("\n");
        }
        try {
        	System.out.println("------execute command is : " + cmds.toString());
        	proc = runtime.exec(commands, null, directory);
            if (proc.waitFor() != 0) {
                System.err.println("exit value = " + proc.exitValue());
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = in.readLine()) != null) {
                stringBuffer.append(line+"-");
            }
            System.out.println("----shell result:" + stringBuffer.toString());
        } catch (Exception e) {
            System.err.println(e);
        }
	}
	
	private void initView(){
		setContentView(R.layout.main);
	}
	

	private void initEngine(){

		 String authDirPath = this.getFilesDir().getAbsolutePath();

	        // 前置条件：无
	        InitParam initparam = new InitParam();

	        // 授权文件所在路径，此项必填
	        initparam.addParam(InitParam.PARAM_KEY_AUTH_PATH, authDirPath);

	        // 是否自动访问云授权,详见 获取授权/更新授权文件处注释
	        initparam.addParam(InitParam.PARAM_KEY_AUTO_CLOUD_AUTH, "no");

	        // 灵云云服务的接口地址，此项必填
	        initparam.addParam(InitParam.PARAM_KEY_CLOUD_URL, config.getVoice().getCloudUrl());

	        // 开发者Key，此项必填，由捷通华声提供
	        initparam.addParam(InitParam.PARAM_KEY_DEVELOPER_KEY, config.getVoice().getDeveloperKey());

	        // 应用Key，此项必填，由捷通华声提供
	        initparam.addParam(InitParam.PARAM_KEY_APP_KEY, config.getVoice().getAppKey());

	        // 配置日志参数
	        String sdcardState = Environment.getExternalStorageState();
	        if (Environment.MEDIA_MOUNTED.equals(sdcardState)) {
	            String sdPath = Environment.getExternalStorageDirectory()
	                    .getAbsolutePath();
	            String packageName = this.getPackageName();

	            String logPath = sdPath + File.separator + "sinovoice"
	                    + File.separator + packageName + File.separator + "log"
	                    + File.separator;

	            // 日志文件地址
	            File fileDir = new File(logPath);
	            if (!fileDir.exists()) {
	                fileDir.mkdirs();
	            }

	            // 日志的路径，可选，如果不传或者为空则不生成日志
	            initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_PATH, logPath);

	            // 日志数目，默认保留多少个日志文件，超过则覆盖最旧的日志
	            initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_COUNT, "5");

	            // 日志大小，默认一个日志文件写多大，单位为K
	            initparam.addParam(InitParam.PARAM_KEY_LOG_FILE_SIZE, "1024");

	            // 日志等级，0=无，1=错误，2=警告，3=信息，4=细节，5=调试，SDK将输出小于等于logLevel的日志信息
	            initparam.addParam(InitParam.PARAM_KEY_LOG_LEVEL, "5");
	        }

		// 初始化System
		System.out.println("---engine, initParam: " + initparam.getStringConfig());
		int errorCode = HciCloudSys.hciInit(initparam.getStringConfig(), this);
		if(errorCode == HciErrorCode.HCI_ERR_NONE){
			System.out.println("---engine, init success!");
		}else{
			System.out.println("---engine, init error: " + errorCode);
		}

	}
	
	
	private void auth() {
		if(config.getSystem().isNeedAuth()){
			System.out.println("---engine,  获取授权信息...");
			int result = HciCloudSys.hciCheckAuth();
			if(result != HciErrorCode.HCI_ERR_NONE){
				System.out.println("---engine, check auth failed : " + result);
				HciCloudSys.hciRelease();
			}
		}
	}
	private void initListener(){
//		
		listener = new XListener(this);
	}
	
	private void initSpeaker(){
		speaker = new Speaker(this);
	}
	
	
	
	/**
	 * 说话
	 * @param statement 语句
	 */
	private void speak(String statement){
		speaker.speak(statement);
	}
	public void analyze(String statement){
		List<Instruction> instructions = analyzer.analyze(statement);
		execute(instructions);
	}
	
	private void execute(List<Instruction> instructions){
		for(Instruction instruction:instructions){
			if(instruction.getType().equals(Instruction.INSTRUCTION_TYPE_SPEAK)){
				speak(instruction.getInstruction());
			}else{
				
			}
		}
	}
	
	public void weakup(){
		try{
			setListenerIdle(false);
			listener.listen();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public boolean isListenerIdle() {
		return listenerIdle;
	}
	public void setListenerIdle(boolean listenerIdle) {
		this.listenerIdle = listenerIdle;
	}
	
    static class Task extends java.util.TimerTask {
    	private Sixshot brain = null;
    	
    	public Task(Sixshot brain){
    		this.brain = brain;
    	}
        @Override  
        public void run() {  
            if(brain.isListenerIdle()){
            	brain.weakup();
            }
        }  
    } 
    
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onStop() {
		super.onStop();
//		recorder.release();
//		help.release();	
	}
	
// 背诗
// 儿歌
// 算数
// 唱歌
// 教英语
	
//	android update project -p . --target android-19 -s
//	ndk-build
	
	/**
	 * 1. 词典
	 * 2. 整合本地识别
	 * 3. 喇叭
	 * 4. 组装、运动控制
	 * 5. 声纹识别
	 * 6. 人脸识别
	 * 7. 避障
	 */
}
