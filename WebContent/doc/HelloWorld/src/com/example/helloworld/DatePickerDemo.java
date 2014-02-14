package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TimePicker;

public class DatePickerDemo extends Activity {

	TimePicker tp2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datepickerdemo);
		initView();
	}

	public void initView() {
		tp2 = (TimePicker) findViewById(R.id.timepicker2);// 获取时间选择器
		tp2.setIs24HourView(true); // 设置为24小时制
		tp2.setCurrentHour(12);// 设置当前时针
		tp2.setCurrentMinute(30);// 设置当前分针
	}
}
