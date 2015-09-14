package com.jk.sixshot.gpio;

import java.io.DataOutputStream;

import java.io.IOException;

public class LED {

	static Process process = null;

	public static void setLed() {

		DataOutputStream dos = null;

		try {

			process = Runtime.getRuntime().exec("su");

			dos = new DataOutputStream(process.getOutputStream());

			dos.writeBytes("echo 74 > /sys/class/gpio/export" + "\n");

			dos.flush();

			// 设置引脚功能为输出

			dos.writeBytes("echo out > /sys/class/gpio/gpio74/direction" + "\n");

			dos.flush();

			dos.close();

			System.out.println("echo 74 > /sys/class/gpio/export echo out > /sys/class/gpio/gpio74/direction");

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public static void cmdLedOff() {

		// TODO Auto-generated method stub

		DataOutputStream dos = null;

		try {

			process = Runtime.getRuntime().exec("su");

			dos = new DataOutputStream(process.getOutputStream());

			dos.writeBytes("echo 0 > /sys/class/gpio/gpio74/value" + "\n");

			dos.flush();

			dos.close();

			System.out.println("echo 0 > /sys/class/gpio/gpio74/value");

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	public static void cmdLedOn() {

		// TODO Auto-generated method stub

		DataOutputStream dos = null;

		try {

			process = Runtime.getRuntime().exec("su");

			dos = new DataOutputStream(process.getOutputStream());

			dos.writeBytes("echo 1 > /sys/class/gpio/gpio74/value" + "\n");

			dos.flush();

			dos.close();

			System.out.println("echo 1 > /sys/class/gpio/gpio74/value");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void ledFlash() {

		while (true) {

			cmdLedOn();

			try {

				Thread.sleep(500);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

			cmdLedOff();

			try {

				Thread.sleep(500);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

}