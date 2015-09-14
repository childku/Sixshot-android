package com.jk.sixshot.gpio;

import android.os.Bundle;

import android.app.Activity;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

public class GPIOActivity extends Activity implements View.OnClickListener {

	TextView gpio_name;

	TextView direction;

	TextView value;

	Button set;

	Button led_on;

	Button led_off;

	Button led_flash;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// setContentView(R.layout.activity_main);

		// gpio_name = (TextView) findViewById(R.id.editText1);
		//
		// direction = (TextView) findViewById(R.id.editText2);
		//
		// value = (TextView) findViewById(R.id.editText3);
		//
		// Button set = (Button)findViewById(R.id.button1);
		//
		// Button led_on = (Button)findViewById(R.id.button2);
		//
		// Button led_off = (Button)findViewById(R.id.button3);
		//
		// Button led_flash = (Button)findViewById(R.id.button4);

		LED.setLed();

		set.setOnClickListener(this);

		led_on.setOnClickListener(this);

		led_off.setOnClickListener(this);

		led_flash.setOnClickListener(this);

	}

	public void onClick(View v) {

		switch (v.getId()) {

		// case R.id.button1:
		case 1:

			System.out.println("gpio crtl");

			String gp = gpio_name.getText().toString();

			String dir = direction.getText().toString();

			int val = Integer.valueOf(value.getText().toString());

			GPIO.gpio_crtl(gp, dir, val);

			break;

		case 2:
			// case R.id.button2:

			System.out.println("led on");

			LED.cmdLedOn();

			break;

		case 3:
			// case R.id.button3:

			System.out.println("led off");

			LED.cmdLedOff();

			break;

		// case R.id.button4:
		case 4:

			System.out.println("led flash");

			LED.ledFlash();

			break;

		default:

			System.out.println("no opreate!");

			break;

		}

	}

}
