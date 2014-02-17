package com.androiddemo.activity.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.androiddemo.activity.R;

/**
 * DatePickerAndTimePicker
 * DatePicker是FrameLayout的子类。内部使用框架布局
 * TimePicker也是FrameLayout的子类
 * @author gaofeng2
 *
 */
public class DatePickerAndTimePickerDemo extends Activity {
	
	private DatePicker datePicker2;
	private TimePicker timePicker;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datepicker_and_timepickerdemo);
	}
	
	// 定义了一个日期选择器DatePicker，仅仅设置了高度和宽度两个属性，直接运行代码

	public void initView() {
		datePicker2=(DatePicker)findViewById(R.id.datepicker2);
		// 自定义开始显示日期，说明在月份的设置上，显示的值实际比我们设置的值自动加了1。
		datePicker2.updateDate(2014, 02, 17);	
		
		
		//  默认显示是12小时制，中文显示上午/下午，英文环境显示AM/PM
		timePicker = (TimePicker) findViewById(R.id.timepicker);// 获取时间选择器
		timePicker.setIs24HourView(true); // 设置为24小时制
		timePicker.setCurrentHour(11);		// 设置小时
		timePicker.setCurrentMinute(56);	// 设置分钟
	}
}
