package com.duan.common.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @className: SystemTool
 * @description: 与系统相关的一些常用工具方法. 目前实现的有：获取MAC地址、IP地址、主机名
 * @author: 笑遍世界
 * @createTime: 2010-11-13 下午08:03:44
 */
public class SystemTool {

	/**
	 * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
	 */
	public static String getOSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	/**
	 * 获取unix网卡的mac地址. 非windows的系统默认调用本方法获取.如果有特殊系统请继续扩充新的取mac地址方法.
	 * 
	 * @return mac地址
	 */
	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ifconfig eth0");// linux下的命令，一般取eth0作为本地主网卡
																	// 显示信息中包含有mac地址信息
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("hwaddr");// 寻找标示字符串[hwaddr]
				if (index >= 0) {// 找到了
					mac = line.substring(index + "hwaddr".length() + 1).trim();// 取出mac地址并去除2边空格
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * 获取widnows网卡的mac地址.
	 * 
	 * @return mac地址
	 */
	public static String getWindowsMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("ipconfig /all");// windows下的命令，显示信息中包含有mac地址信息
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line.toLowerCase());
				index = line.toLowerCase().indexOf("physical address");// 寻找标示字符串[physical // address]
				if(index==-1){
					index = line.toLowerCase().indexOf("物理地址");// 寻找标示字符串[physical // address]
				}			
				
				if (index >= 0) {// 找到了
					index = line.indexOf(":");// 寻找":"的位置
					if (index >= 0) {
						mac = line.substring(index + 1).trim();// 取出mac地址并去除2边空格
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * @return 本机主机名
	 */
	public static String getHostName() {
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ia == null) {
			return "some error..";
		} else
			return ia.getHostName();
	}

	/**
	 * @return 本机IP 地址
	 */
	public static String getIPAddress() {
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ia == null) {
			return "some error..";
		} else
			return ia.getHostAddress();
	}
	
	
	/**
	 * @return 本机MAC 地址
	 */
	public static String getMACAddress() {
		String mac=null;
		String os = getOSName();
		if (os.startsWith("windows")) {
			// 本地是windows
			mac = getWindowsMACAddress();
		} else {
			// 本地是非windows系统 一般就是unix
			mac = getUnixMACAddress();
		}
		return mac;
	}
	
	/**
	 * 测试用的main方法.
	 * @param args 运行参数.
	 */
	public static void main(String[] args) {
		String os = getOSName();
		System.out.println("OS Type:"+os);
		
		if (os.startsWith("windows")) {
			// 本地是windows
			String mac = getWindowsMACAddress();
			System.out.println("MAC Address:" + mac);
		} else {
			// 本地是非windows系统 一般就是unix
			String mac = getUnixMACAddress();
			System.out.println(mac);
		}
	}

}