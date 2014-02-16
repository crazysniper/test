package com.androiddemo.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androiddemo.activity.R;

public class ServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicedemo);
	}

	public void toStartFirstService(View view) {
		Intent firstServiceIntent = new Intent(ServiceActivity.this, FirstService.class);
		// ֹͣService
		this.stopService(firstServiceIntent);
		// ����Service ��startService()����Service
		this.startService(firstServiceIntent);
	}

	public void toStopFirstService(View view) {
		Intent firstServiceIntent = new Intent(ServiceActivity.this, FirstService.class);
		this.stopService(firstServiceIntent);
	}

	public void toStartSecondService(View view) {
		Intent secondServiceIntent = new Intent(ServiceActivity.this, SecondService.class);
		secondServiceIntent.setAction("com.androirdemo.secondservice");  
		// ֹͣService
//		this.stopService(serviceIntent);
		// ����Service
		this.startService(secondServiceIntent);
	}

	public void toStopSecondService(View view) {
		Intent secondServiceIntent = new Intent(ServiceActivity.this, SecondService.class);
		secondServiceIntent.setAction("com.androirdemo.secondservice");  
		this.stopService(secondServiceIntent);
	}
}
