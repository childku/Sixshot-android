package com.jk.sixshot.gpio;

import java.io.DataOutputStream;

import java.io.IOException;

public class GPIO {

	/**
	 * 
	 * @param args
	 */

	private static int num, gpio_number;

	private static String gpio_num = null;

	private static String exportPath;

	private static String directionPath;

	private static String valuePath;

	static Process process = null;

	static DataOutputStream dos = null;

	public static int gpio_crtl(String gpio, String direction, int level) {

		if (gpio.length() != 4) {

			System.out.println("input gpio error!");

			return 0;

		}

		gpio_num = gpio.substring(2, 4); // 从String gpio（如PC20）中提取出String 20；

		num = Integer.parseInt(gpio_num);// 将String 20转化为int 20；

		System.out.println("num:" + num + "\n");

		if ((gpio.indexOf("pa") >= 0) || (gpio.indexOf("PA") >= 0)) {

			gpio_number = num;

		} else if ((gpio.indexOf("pb") >= 0) || (gpio.indexOf("PB") >= 0)) {

			gpio_number = num + 24;

		} else if ((gpio.indexOf("pc") >= 0) || (gpio.indexOf("PC") >= 0)) {

			gpio_number = num + 54;

		} else if ((gpio.indexOf("pd") >= 0) || (gpio.indexOf("PD") >= 0)) {

			gpio_number = num + 85;

		} else if ((gpio.indexOf("pe") >= 0) || (gpio.indexOf("PE") >= 0)) {

			gpio_number = num + 119;

		} else if ((gpio.indexOf("pf") >= 0) || (gpio.indexOf("PF") >= 0)) {

			gpio_number = num + 137;

		} else if ((gpio.indexOf("pg") >= 0) || (gpio.indexOf("PG") >= 0)) {

			gpio_number = num + 149;

		} else if ((gpio.indexOf("ph") >= 0) || (gpio.indexOf("PH") >= 0)) {

			gpio_number = num + 167;

		} else if ((gpio.indexOf("pi") >= 0) || (gpio.indexOf("PI") >= 0)) {

			gpio_number = num + 201;

		}

		exportPath = "echo " + gpio_number + " > /sys/class/gpio/export";

		directionPath = "echo out > " + " /sys/class/gpio/gpio" + gpio_number
				+ "/direction";

		valuePath = "echo " + level + " > /sys/class/gpio/gpio" + gpio_number
				+ "/value";

		System.out.printf(exportPath + "\n" + directionPath + "\n" + valuePath
				+ "\n");

		try {

			process = Runtime.getRuntime().exec("su");

			dos = new DataOutputStream(process.getOutputStream());

			dos.writeBytes(exportPath + "\n");

			dos.flush();

			dos.writeBytes(directionPath + "\n");

			dos.flush();

			dos.writeBytes(valuePath + "\n");

			dos.flush();

			dos.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return 0;

	}

}