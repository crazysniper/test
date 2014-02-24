package com.androiddemo.application;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Weather_Post_Demo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather_demo);
	}
	
	public void click(View v){
		startActivity(new Intent(this, Weather_Get_Demo.class));
	}
}
