package com.bawei.commons.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具类
 * @author 77028
 *
 */
public class FileUtil {
	/**
	 * 根据文件获取扩展名
	 * @param fileName
	 * @return
	 */
	public static String getExtName(String fileName) {
		//判断文件名是否为空
		if(fileName==null || "".equals(fileName)) {
			throw new RuntimeException("错误,文件名不存在");
		}
		if (fileName.indexOf(".")<=-1) {
			throw new RuntimeException(fileName+"该文件没有扩展名");
		}
		String extName=fileName.substring(fileName.lastIndexOf("."));
		return extName;
	}
	
	/**
	 * 操作系统临时目录
	 * @return
	 */
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	
	/**
	 * 读取文件内容
	 * @param filePath
	 * @return
	 */
	public static String readTextFileByLine(String filePath) {
		BufferedReader br=null;
		StringBuffer sb=new StringBuffer();
		String str=null;
		try {
			br=new BufferedReader(new FileReader(new File(filePath)));
			while((str=br.readLine())!=null) {
				sb.append(str);
				sb.append("\r\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			StreamUtil.closeStream(br);
		}
		return sb.toString();
	}
	
	/**
	 * 按行读取内容到list集合中
	 * @return
	 */
	public static List<String> readTextFileOfList(String filePath) {
		BufferedReader br=null;
		List<String> strList=new ArrayList<String>();
		String str=null;
		try {
			br=new BufferedReader(new FileReader(new File(filePath)));
			while((str=br.readLine())!=null) {
				strList.add(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			StreamUtil.closeStream(br);
		}
		return strList;
	}
	
	/**
	 * 递归删除文件,如果是文件删除文件,如果是文件夹删除文件夹
	 * @param file
	 * @return
	 */
	public static void deleteFile(File file) {
		if(file.isDirectory()) {
			File[] listFiles=file.listFiles();
			for (File file2 : listFiles) {
				deleteFile(file2);
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	
	/**
	 * 获得文件的大小,可以定义小数点后几位
	 *返回文件以指定格式
	 * @param file
	 * @return
	 */
	public static String getFileSize(File file,Integer num) {
		long length=file.length();
		double len=length/1024.0;
		if(num==null || num==0) {
			return Math.ceil((length/1024.0))+"kb";
		}else {
			return String.format("%."+num+"f", len)+"kb";
		}	
	}
	
	/**
	 * 获得文件的大小,可以定义小数点后几位
	 *返回文件以指定格式
	 * @param file
	 * @return
	 */
	public static String getFileSize(File file) {
		long length=file.length();
		return Math.ceil((length/1024.0))+"kb";
	}
	
	/**
	 * 获得文件的大小
	 *返回文件以指定格式
	 * @param file
	 * @return
	 */
	public static String getFileSize(String fileName) {
		return getFileSize(new File(fileName));
	}
	
	
	/**
	 * 获得文件的大小,可指定小数点后几位
	 *返回文件以指定格式
	 * @param file
	 * @return
	 */
	public static String getFileSize(String fileName,Integer num) {
		return getFileSize(new File(fileName),num);
	}
}
