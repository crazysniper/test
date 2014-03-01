package com.androiddemo.component;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ComponentActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.component);
	}

	// 下拉列表
	public void toSpinner(View view) {
		startActivity(new Intent(this, SpinnerDemo.class));
	}

	// Tab选项卡
	public void toTab(View view) {
		startActivity(new Intent(this, Tab_Demo.class));
	}

	// DatePicker
	public void toDatePickerAndTimePicker(View view) {
		startActivity(new Intent(this, DatePicker_And_TimePicker_Demo.class));
	}

	// AlertDialogActivity
	public void toAlertDialogActivity(View view) {
		startActivity(new Intent(this, AlertDialogActivity.class));
	}
	
	// AlertDialogActivity
	public void toNotification(View v){
		startActivity(new Intent(this, NotificationActivity.class));
	}
	
	// toExpandableListView
	public void toExpandableListView(View v){
		startActivity(new Intent(this, ExpandableListViewTest.class));
	}
}
