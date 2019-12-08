package com.bawei.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author 77028
 *
 */

public class DateUtil {
	//定义常量
	private static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	@SuppressWarnings("unused")
	private static SimpleDateFormat dateTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * 根据生日判断年龄
	 * @param birthDate
	 * @return
	 */
	public static int getAge(Date birthDate) {
		//获得日历控件
		Calendar calendar=Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//设置日历控件为生日的时间
		calendar.setTime(birthDate);
		int birthYear = calendar.get(Calendar.YEAR);
		int birthMonth = calendar.get(Calendar.MONTH);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		//年龄
		int age = nowYear-birthYear;
		//如果生日的月份大于当前月份时，年龄-1
		if(birthMonth>nowMonth) {
			age--;
		}
		//如果月份相等，判断日期
		if(birthMonth==nowMonth && nowDay<birthDay) {
			age--;
		}
		return age;
	}
	
	/**
	 * 根据出生日期计算年龄
	 * @param args
	 */
	public static int getAge(String birthDateStr) {
		Date birthDate=null;
		//解析日期字符串为Date对象
		try {
			birthDate=new SimpleDateFormat("yyyy-MM-dd").parse(birthDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAge(birthDate);
	}
	
	/**
	 * 获取开始时间与结束时间之间有多少天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDayNum(Date date1,Date date2) {
		//一天有多少毫秒
		Long dateTime=1000*60*60*24L;
		String format1 = new SimpleDateFormat("yyyy-MM-dd").format(date1);
		String format2 = new SimpleDateFormat("yyyy-MM-dd").format(date2);
		String regex="\\d{4}-(0[0-9]|1[0-2])-((0|1|2)\\d|(3)[0-1])";
		Double dayNum=0.0;
		if(format1.matches(regex) && format2.matches(format2)) {
			long startTime = date1.getTime();
			long endTime = date2.getTime();
			dayNum=Math.abs(((endTime-startTime)/dateTime*1.0));
		}
		dayNum=Math.ceil(dayNum);
		return dayNum.intValue()+1;
	}
	
	/**
	 * 计算开始时间到今天,过去了多少天
	 * @param args
	 */
	public static int getDayNum(Date date) {
		Date date2=new Date();
		return getDayNum(date, date2);
	}
	
	/**
	 * 验证日期是否是今天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		Date nowDate=new Date();
		String format = dateFormat.format(date);
		String format2 = dateFormat.format(nowDate);
		return format.equals(format2);
	}
	
	/**
	 * 字符串验证是否是今天
	 * @param strDate
	 * @return
	 */
	public static boolean isToday(String strDate) {
		Date parse;
		try {
			parse = dateFormat.parse(strDate);
			return isToday(parse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断日期是否在本周
	 * @param args
	 */
	public static boolean dateIsInThisWeek(Date date) {
		Date nowDate=new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(nowDate);
		//本周的第几天
		int dayforwork = calendar.get(Calendar.DAY_OF_WEEK);
		//设置本周第一天的时间
		calendar.add(Calendar.DAY_OF_YEAR, 1-dayforwork);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date firstDate=calendar.getTime();
		//设置本周最后一天的时间
		calendar.add(Calendar.DAY_OF_YEAR, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date lastDate=calendar.getTime();
		calendar.setTime(date);
		return compareTime(date, firstDate)>=0 && compareTime(date, lastDate)<=0;
	}
	
	/**
	 * 判断日期是否在本周
	 * @param args
	 */
	public static boolean dateIsInThisWeek(String strDate) {
		Date parse;
		try {
			parse = dateFormat.parse(strDate);
			return dateIsInThisWeek(parse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获得每月的第一天
	 */
	public static Date getFirstMonthDay(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定日期的最后一天
	 * @param args
	 */
	public static Date lastMonthDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		//把获得的日期值放入日历中
		calendar.setTime(date);
		//获得月份值
		calendar.add(Calendar.MONTH, 1);
		//把获得月份值的日期放入获取指定日期月份的第一天的方法中
		Date date2 = getFirstMonthDay(calendar.getTime());
		calendar.setTime(date2);
		calendar.add(Calendar.MILLISECOND, -1);
		return calendar.getTime();
	}
	
	/**
	 * 描述方法的作用
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareTime(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2){
			return 1;
		}
		return -1;
	}
	
}
