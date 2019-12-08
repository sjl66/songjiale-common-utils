package com.bawei.commons.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * 流工具类
 * @author 77028
 *
 */
public class StreamUtil {

	/**
	 * 关闭流的方法
	 * @param autoCloseables
	 */
	public static void closeStream(AutoCloseable ...autoCloseables) {
		if(autoCloseables!=null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 根据io流读取文件内容
	 * @param file
	 * @return
	 */
	public static String readTextFile(File file) {
		InputStream inputStream=null;
		try {
			inputStream=new FileInputStream(file);
			byte[] b=new byte[1024];
			String str="";
			while(inputStream.read(b)!=-1) {
				str+=new String(b);
			}
			return str;
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			closeStream(inputStream);
		}
	}
	
	/**
	 * 根据输入的字符串路径
	 * @param filePath
	 * @return
	 */
	public static String readTextFile(String filePath) {
		return readTextFile(new File(filePath));
	}
	
	/**
	 * 写入文件
	 * @param filePath
	 */
	public static void writeTextFile(String content,File filePath,boolean append) {
		BufferedWriter 	bw=null;
		
		try {
			//判断文件夹是否存在
			String parent = filePath.getParent();
			File parentFile=new File(parent);
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			
			//写文件
			bw=new BufferedWriter(new FileWriter(filePath, append));
			bw.write(content);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeStream(bw);
		}
	}
	
	/**
	 * 字符串写入文件
	 * @param args
	 */
	public static void writeTextFile(String content,String filePath,boolean append) {
		writeTextFile(content, new File(filePath), append);
	}
	
}
