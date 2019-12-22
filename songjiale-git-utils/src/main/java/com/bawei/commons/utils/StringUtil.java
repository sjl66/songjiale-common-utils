package com.bawei.commons.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 判断是否字符串是否为空
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isBlank(String string) {
		if (string == null) {
			System.out.println(string);
			return true;
		}
		// 去空格
		string = string.trim();
		// 判断字符串的长度是否0
		if (string.length() == 0) {
			return true;
		}
		return false;
	}
	public static boolean isNumber(String num) {
		String regex="[0-9]+";
		boolean matches = Pattern.matches(regex,num);
		return matches;
	}

	/**
	 * 判断字符串不为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String string) {
		return !isBlank(string);
	}

	/**
	 * 判断手机号是否正确
	 * 
	 * @param args
	 */
	public static boolean isPhoneNum(String phoneNum) {
//		String regex="1[3578]\\d{9}";
//		return phoneNum.matches(regex);

		// 这种方法是把所有的开头两个数字定死
//		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		String regex = "^1((3[0-9])|(5[0-9])|(7[0-9])|(8[0-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(phoneNum);
		boolean isMatch = m.matches();
		return isMatch;
	}
	

	/**
	 * 判断email是否正确
	 * 
	 * @param args
	 */
	public static boolean isEmailPath(String emailPath) {
		String regex = "[A-z0-9]+@[A-z0-9]+.(com|cn)";
		return emailPath.matches(regex);
	}

	/**
	 * 判断字符串是否全为字母
	 * 
	 * @param args
	 */
	public static boolean isLetter(String str) {
		if (isBlank(str)) {
			str = str.toLowerCase();
			String regex = "[a-z]+";
			return str.matches(regex);
		}
		return false;
	}

	/**
	 * 获取随机字符串
	 * 
	 * @param args
	 */
	public static char getRandom() {
		// 生成随机类
		Random random = new Random();
		// 第一种方式
		// 开始字符在acsii码
		int startChar = 'a' + 0;
		// 生成随机字符
		char newChar = (char) (startChar + random.nextInt(26));
		return newChar;
	}
	
	/**
	 * 获取随机字符串
	 * 
	 * @param args
	 */
	public static char getBigRandom() {
		// 生成随机类
		Random random = new Random();
		// 第一种方式
		// 开始字符在acsii码
		int startChar = 'A' + 0;
		// 生成随机字符
		char newChar = (char) (startChar + random.nextInt(26));
		return newChar;
	}
	
	/**
	 * 生成数字随机数小写
	 * 
	 * @param num
	 * @return
	 */
	public static String getRandomLetter(int num) {
		// 保存生成胡字符
		StringBuffer sb = new StringBuffer();
		// 生成随机字符
		for (int i = 0; i < num; i++) {
			char random = getRandom();
			sb.append(random);
		}

		return sb.toString();
	}
	
	/**
	 * 生成数字随机数大小写都可以的样子
	 * @param num
	 * @return
	 */
	public static String getRandomBigAndLittleLetter(int num) {
		// 保存生成胡字符
		StringBuffer sb = new StringBuffer();
		// 大小写都可以生成的方式
		for(int i=0;i<num;i++)
		{
			//52个字母与6个大小写字母间的符号；范围为91~96
			int value = (int)(Math.random()*58+65);
			while(value>=91 && value<=96)
				value = (int)(Math.random()*58+65);	
			sb.append((char)value);
		}

		return sb.toString();
	}
	
	/**
	 * 生成数字随机数大写
	 * @param num
	 * @return
	 */
	public static String getRandomBigLetter(int num) {
		// 保存生成胡字符
		StringBuffer sb = new StringBuffer();
		// 生成随机字符
		for (int i = 0; i < num; i++) {
			char random = getBigRandom();
			sb.append(random);
		}

		return sb.toString();
	}

	/**
	 * 生成随机的数字
	 * 
	 * @param args
	 */
	public static char getNumLetter() {
		// 生成随机类
		Random random = new Random();
		// 第一种方式
		// 开始字符在acsii码
		int startChar = '0' + 0;
		// 生成随机字符
		char newChar = (char) (startChar + random.nextInt(10));
		return newChar;
	}

	/**
	 * 生成随机的小写和数字验证码
	 * @param num
	 * @return
	 */
	public static String getNumAndLittleLetter(int num) {
		// 保存生成胡字符
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		// 生成随机字符
		for (int i = 0; i < num; i++) {
			if (random.nextInt(36) > 10) {
				sb.append(getRandom());
			} else {
				sb.append(getNumLetter());
			}
		}
		return sb.toString();
	}
	
	/**
	 * 生成随机的大写和数字验证码
	 * @param num
	 * @return
	 */
	public static String getNumAndBigLetter(int num) {
		// 保存生成胡字符
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		// 生成随机字符
		for (int i = 0; i < num; i++) {
			if (random.nextInt(36) > 10) {
				sb.append(getBigRandom());
			} else {
				sb.append(getNumLetter());
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * 生成随机的大写和小写和数字验证码
	 * @param num
	 * @return
	 */
	public static String getNumAndBigAndLittleLetter(int num) {
		// 保存生成胡字符
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		
		// 生成随机字符
		for (int i = 0; i < num; i++) {
			if (random.nextInt(36) > 10) {
				//52个字母与6个大小写字母间的符号；范围为91~96
				int value = (int)(Math.random()*58+65);
				while(value>=91 && value<=96)
					value = (int)(Math.random()*58+65);	
				sb.append((char)value);
			} else {
				sb.append(getNumLetter());
			}
		}
		return sb.toString();
	}

	/**
	 * 返回一个中文文字//GB2312中文简体  
	 * @return
	 */
	public static String randomChineseString() {
		String str=null;
		int higePos,lowPos;
		Random random=new Random();
		// 区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
		higePos=(176 + Math.abs(random.nextInt(39)));
		// 位码，0xA0打头，范围第1~94列
		lowPos=161 + Math.abs(random.nextInt(39));
		byte[] bArr=new byte[2];
		bArr[0]=(new Integer(higePos)).byteValue();
		bArr[1]=(new Integer(lowPos)).byteValue();
		try {
			str =new String(bArr,"GB2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 返回参数length个中文汉字字符串，字符集必须在GB2312(相当于中文简体)范围内   
	 * 中文繁体是GB2312,中文繁体是BIG5,中文可以直接使用GBK,中文还可以使用GB18030,解决了中文、日文、朝鲜语等的编码，兼容GBK。
	 * @param length
	 * @return
	 */
	public static String randomChineseString(int length) {
		String str="";
		for(int i=0;i<length;i++) {
			str+=randomChineseString();
		}
		return str;
	}
	
	/**
	 * 返回中文姓名，必须以真实姓开头
	 * @return
	 */
	public static String randomStringChineseName() {
		String[] surname={ "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦",
				"尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦",
				"章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
				"酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐",
				"于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
				"湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
				"屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
				"梅", "盛", "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝",
				"管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸",
				"左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "于", "惠", "甄", "曲", "家",
				"封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷",
				"车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖",
				"武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰",
				"从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党",
				"翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却", "璩", "桑", "桂", "濮", "牛", "寿", "通",
				"边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾",
				"鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文",
				"寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融",
				"冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查",
				"后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉", "督", "岳", "帅", "缑", "亢", "况", "郈", "有",
				"琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "篁",
				"年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭",
				"舜", "楼", "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽",
				"来", "綦", "召", "仪", "风", "介", "巨", "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过",
				"竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾", "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳",
				"夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正", "濮阳", "淳于", "单于", "太叔", "申屠",
				"公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇", "南门", "呼延", "子车",
				"颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生", "梁丘",
				"左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖",
				"雍门", "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙" };
		//随机获取一个姓
		String familyName=surname[RandomUtil.random(0,surname.length-1)];
		//随机获得一个或者两个字组成名字
		String givenName=randomChineseString(RandomUtil.random(1, 2));
		
		return familyName+givenName;
	}
	
	/**
	 * 验证是否是URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
}
