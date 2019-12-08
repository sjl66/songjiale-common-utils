package com.bawei.commons.utils;

import java.util.Random;

/**
 * 随机生成类
 * @author 77028
 *
 */
public class RandomUtil {

	/**
	 * 获得最小数和最大数之间的随机数   
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min, int max) {
		// TODO Auto-generated method stub
		Random random=new Random();
		return min+random.nextInt(max-min+1);
	}
	
	/**
	 * 获得最小数和最大数之间的多个随机数
	 * @return
	 */
	public static int[] random(int min,int max,int num) {
		int[] array=new int[num];
		for (int i = 0; i < num; i++) {
			array[i]=random(min,max);
		}
		return array;
	}
}
