package com.androiddemo.application;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Androide Demo
 * @author Gao
 *
 */
public class ApplicationListDemoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.application_list_demo);
	}

	public void to_GetWeather(View v) {
		startActivity(new Intent(this, Weather_Get_Demo.class));
	}
	
	public void to_PostWeather(View v) {
		startActivity(new Intent(this, Weather_Get_Demo.class));
	}

	public void to_imageOnline(View v) {
		startActivity(new Intent(this, ImageOnlineActivity.class));
	}
}
