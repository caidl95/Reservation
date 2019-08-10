package com.example.demo.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  获取当前日期的几天前日期
 */
public class Tools {
	
	/**
	 * 获取当前日期几天之前的日期
	 * @param i 为天数
	 * @return yyyy-MM-dd 格式的日期
	 */
	public static String getDate(int i){
		//获取当前日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		String endDate = sdf.format(today);//当前日期
		//获取三十天前日期
		Calendar theCa = Calendar.getInstance();
		theCa.setTime(today);
		theCa.add(theCa.DATE, -i);//最后一个数字30可改，30天的意思
		Date start = theCa.getTime();
		String startDate = sdf.format(start);//三十天之前日期
		return startDate;
	}
	
	
	public static void main(String[] args) {
		System.out.println("date:"+getDate(2));
	}

}
