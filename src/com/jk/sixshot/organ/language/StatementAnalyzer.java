package com.jk.sixshot.organ.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.jk.sixshot.Response;

public class StatementAnalyzer {
	private Map<String, List<String>> answers = new HashMap<String, List<String>>();
	
	private Map<String, String> poems = new HashMap<String, String>();
	
	private Random random = new Random();
	
	public StatementAnalyzer(){
		initPoems();
		
		List<String> statements = null;
		
		statements = new ArrayList<String>();
		statements.add("说慢点，我没听懂！");
		statements.add("别说太快啊，太快了我跟不上！");
		statements.add("慢点说，别急！");
		statements.add("你这话是什么意思？");
		statements.add("你说的这是啥意思？");
		answers.put("不知道怎么说", statements);
		
		statements = new ArrayList<String>();
		statements.add("你好！");
		statements.add("诶，在！");
		statements.add("在呢！");
		statements.add("啥事？");
		statements.add("嗨，你好！");
		answers.put("豆豆", statements);
		
		statements = new ArrayList<String>();
		statements.add("你好！");
		statements.add("你好呀！");
		statements.add("你好，我是豆豆！");
		statements.add("你好，有什么需要帮助的么？虽然我帮不了你太多。");
		answers.put("问好", statements);
		
		statements = new ArrayList<String>();
		statements.add("你也很棒！");
		statements.add("别夸奖我，我会不好意思的");
		statements.add("还差的远呢！");
		statements.add("还有努力的空间，我还要努力！");
		answers.put("真棒", statements);
		
		statements = new ArrayList<String>();
		statements.add("我叫豆豆！");
		statements.add("我叫豆豆，黄豆的豆儿！");
		statements.add("我叫豆豆，你呢！？");
		statements.add("我叫豆豆。");
		answers.put("名字", statements);
		
		statements = new ArrayList<String>();
		statements.add("我三岁了");
		statements.add("我三岁了，你呢？");
		statements.add("今年我三岁");
		statements.add("我已经三岁了，是个大孩子了！");
		answers.put("几岁", statements);
		
		statements = new ArrayList<String>();
		statements.add("我属兔");
		statements.add("我属兔的，小白兔的兔？");
		statements.add("我属小白兔的");
		statements.add("我属兔子的，你呢？");
		answers.put("属啥", statements);
		
		statements = new ArrayList<String>();
		statements.add("我才不笨呢！");
		statements.add("我才三岁，当然没你聪明了？");
		statements.add("也不是很笨，只是一点点");
		statements.add("看来我得多学习学习了");
		answers.put("你真笨", statements);
		
		statements = new ArrayList<String>();
		statements.add("这首诗我还没学会哦，等我学会了在背给你听吧！");
		statements.add("这是谁的诗啊，我怎么没学过！");
		statements.add("真的有这首诗么？我怎么没学过呢？");
		statements.add("那个不好意思啊，你看要不我给你背首《登鹳雀楼》怎么样？");
		answers.put("没有这首诗", statements);
	}
	
	private void initPoems(){
		poems.put("登鹳雀楼", "《登鹳雀楼》，作者：盛唐诗人，王之涣。白日依山尽，黄河入海流。欲穷千里目，更上一层楼。");
		
		poems.put("黄鹤楼", "《黄鹤楼》，作者：唐代诗人，崔颢。昔人已乘黄鹤去，此地空余黄鹤楼。黄鹤一去不复返，白云千载空悠悠。晴川历历汉阳树，芳草萋萋鹦鹉洲。日暮乡关何处是，烟波江上使人愁。");
		
		poems.put("枫桥夜泊", "《枫桥夜泊》，作者：唐代诗人，张继。月落乌啼霜满天，江枫渔火对愁眠。姑苏城外寒山寺，夜半钟声到客船。");
		
		String poem = "《咏鹅》，作者：初唐诗人骆宾王。鹅鹅鹅，曲项向天歌。白毛浮绿水，红掌拨清波";
		poems.put("鹅鹅鹅", poem);
		poems.put("咏鹅", poem);
		poems.put("额额额", poem);
		
		poem = "《悯农》，作者：唐代诗人，李绅。锄禾日当午，汗滴禾下土。谁知盘中餐，粒粒皆辛苦。";
		poems.put("锄禾", poem);
		poems.put("悯农", poem);
		
		poem = "《好的————》。小老鼠上登台，偷油吃下不来。喵喵喵，猫来了，叽里咕噜滚下来！";
		poems.put("小老鼠", poem);
		
		poem = "《好————》。登登冷登登，登登冷登登。一只小老鼠，瞪着俩眼珠。呲着两只小牙，长着八字胡。登登冷登登，登登冷登登。一只小花猫，喵喵喵喵喵，吓得老鼠赶紧往回跑！";
		poems.put("一只小老鼠", poem);
	}
	
	public List<Response> analyze(String statement){
		List<Response> responses = new ArrayList<Response>();
		Response response = null;
		if(statement.contains("豆豆")){
			response = new Response();
			response.setInstruction(getStatement("豆豆"));
		}else if(statement.contains("你好")){
			response = new Response();
			response.setInstruction(getStatement("问好"));
		}else if(statement.contains("名字")){
			response = new Response();
			response.setInstruction(getStatement("名字"));
		}else if(statement.contains("几岁")||
				statement.contains("多大")){
			response = new Response();
			response.setInstruction(getStatement("几岁"));
		}else if(statement.contains("属啥")||
				statement.contains("属什么")){
			response = new Response();
			response.setInstruction(getStatement("属啥"));
		}else if(statement.contains("你真棒")||
				statement.contains("豆豆真棒")){
			response = new Response();
			response.setInstruction(getStatement("真棒"));
		}else if(statement.contains("你真笨")||
				statement.contains("你真笨")){
			response = new Response();
			response.setInstruction(getStatement("你真笨"));
		}else if(statement.contains("北首")||
				statement.contains("被首")||
				statement.contains("背首")||
				statement.contains("背熟")||
				statement.contains("备受")||
				statement.contains("背熟")||
				statement.contains("对手")||
				statement.contains("被手")||
				statement.contains("被个")){
			String action = null;
			if(statement.contains("北首")){
				action = "北首";
			}else if(statement.contains("被首")){
				action = "被首";
			}else if(statement.contains("背首")){
				action = "背首";
			}else if(statement.contains("备受")){
				action = "备受";
			}else if(statement.contains("背熟")){
				action = "背熟";
			}else if(statement.contains("背熟")){
				action = "背熟";
			}else if(statement.contains("对手")){
				action = "对手";
			}else if(statement.contains("被手")){
				action = "被手";
			}else if(statement.contains("被个")){
				action = "被个";
			}
			
			String poemName = statement.substring(statement.indexOf(action));
			poemName = poemName.replace(action, "");
			poemName = poemName.replace("吧", "");
			poemName = poemName.replace("！", "");
			poemName = poemName.replace("。", "");
			poemName = poemName.replace("，", "");
			
			response = new Response();
			response.setInstruction(getPoem(poemName));
		}else if(isCaculate(statement)){
			response = caculate(statement);
		}else if(isMotion(statement)){
			response = judgeDirection(statement);
		}else if(isEnglish(statement)){
			response = translate(statement);
		}else{
			response = new Response();
			response.setInstruction(getStatement("不知道怎么说"));
		}
		
		responses.add(response);
		return responses;
	}
	
	private boolean isCaculate(String statement){
		boolean result = false;
		if(statement.matches(".*((加.*等于)).*")
				||statement.matches(".*((加.*得)).*")){
			return result = true;
		}
		return result;
	}

	private Response caculate(String statement){
		String result = "等于";
		String type = "加";
		if(statement.contains("等于")){
			result = "等于";
		}else{
			result = "得";
		}
		
		if(statement.contains("加上")){
			type = "加上";
		}else{
			type = "加";
		}
//		7加4等于
		int first = Integer.parseInt(statement.substring(0, statement.indexOf(type)));
		int second = Integer.parseInt(statement.substring(statement.indexOf(type)+1, statement.indexOf(result)));
		
		Response instruction = new Response();
		int r = first + second;
		System.out.println("---caculate result: " + r);
		instruction.setInstruction(result + r);
		
		return instruction;
	}
	
	private boolean isMotion(String statement){
		boolean result = false;
		String article_a = "往";
		String article_b = "向";
		String forward = "前";
		String backward = "后";
		String left = "左";
		String right = "右";	
		
		if(statement.contains("过来")
				||statement.contains(article_a+forward)
				||statement.contains(article_a+forward)
				||statement.contains(article_a+backward)
				||statement.contains(article_a+left)
				||statement.contains(article_a+right)
				||statement.contains(article_b+forward)
				||statement.contains(article_b+backward)
				||statement.contains(article_b+left)
				||statement.contains(article_b+right)
				||statement.contains("停")
				||statement.contains("停下")
				||statement.contains("好")
				||statement.contains("好了")
				||statement.contains("行")
				||statement.contains("行了")
				){
			result = true;
		}
		return result;
	}
	
	private Response judgeDirection(String statement){
		String direction = "";
		if(statement.contains("前")
				||statement.contains("过来")){
			direction = "forward";
		}else if(statement.contains("后")){
			direction = "backward";
		}else if(statement.contains("左")){
			direction = "left";
		}else if(statement.contains("右")){
			direction = "right";
		}else if(statement.contains("停")
				||statement.contains("好")
				||statement.contains("行")){
			direction = "stop";
		}
		
		Response instruction = new Response();
		instruction.setType(Response.RESPONSE_TYPE_MOTION);
		instruction.setInstruction(direction);
		return instruction;
	}
	
	private boolean isEnglish(String statement){
		boolean result = false;
		
		if(statement.contains("用英语怎么说")
				||statement.contains("怎么说")
				){
			result = true;
		}
		return result;
	}
	
	private Response translate(String statement){
		String english = "";
		statement = statement.replace("用英语怎么说", "");
		statement = statement.replace("怎么说", "");
		if(statement.contains("爸爸")){
			english = "dad";
		}else if(statement.contains("妈妈")){
			english = "mom";
		}else if(statement.contains("爷爷")){
			english = "grandpa";
		}else if(statement.contains("奶奶")){
			english = "grandma";
		}else if(statement.contains("姥姥")){
			english = "grandma";
		}else if(statement.contains("姥爷")){
			english = "grandpa";
		}else if(statement.contains("桌子")){
			english = "table";
		}else if(statement.contains("凳子")){
			english = "stool";
		}else if(statement.contains("电视")){
			english = "television";
		}else if(statement.contains("电脑")){
			english = "computer";
		}else if(statement.contains("手机")){
			english = "phone";
		}else if(statement.contains("微波炉")){
			english = "microwave";
		}else if(statement.contains("冰箱")){
			english = "fridge";
		}else if(statement.contains("洗衣机")){
			english = "washer";
		}else if(statement.contains("电风扇")){
			english = "fan";
		}else if(statement.contains("兔子")){
			english = "rabbit";
		}else if(statement.contains("小狗")){
			english = "puppy";
		}else if(statement.contains("小猫")){
			english = "kitten";
		}else if(statement.contains("大象")){
			english = "elephant";
		}else if(statement.contains("熊猫")){
			english = "panda";
		}else {
			english = "这个，我也不知道。我们一起查查词典吧！";
		}
		List<String> middle = new ArrayList<String>();
		middle.add("");
		middle.add("是");
		middle.add(statement + "是");
		middle.add(statement + "用英语说是");
//		middle.add("听好了，" + statement + "是");
//		middle.add("听好了，" + statement + "用英语说是");
		
		Response instruction = new Response();
		instruction.setInstruction(middle.get(random.nextInt(middle.size())) + " " + english);
		return instruction;
	}
	
	private String getStatement(String key){
		List<String> statements = null;
		String statement = null;
		
		statements = answers.get(key);
		if(statements==null||statements.isEmpty()){
			statement = getStatement("不知道怎么说");
		}else{
			statement = statements.get(random.nextInt(statements.size()));
		}
		return statement;
	}
	private String getPoem(String poemName){
		System.out.println("----poem name is : " + poemName);
		String poem = null;
		poem = poems.get(poemName);
		if(poem == null){
			poem = getStatement("没有这首诗");
		}
		return poem;
	}
	/**
	 * 1. 通配符
	 * 2. 语境检测
	 * 3. 属性，动态属性
	 * 4. 上下文
	 */
	
}
