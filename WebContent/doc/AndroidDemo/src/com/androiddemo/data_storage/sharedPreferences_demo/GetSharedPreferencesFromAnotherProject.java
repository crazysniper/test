package com.androiddemo.data_storage.sharedPreferences_demo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.androiddemo.activity.R;

public class GetSharedPreferencesFromAnotherProject extends Activity {

	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getsharedpreferences_from_anotherproject);
		initView();
	}

	public void initView() {
		tv = (TextView) findViewById(R.id.textView);

	}

	public void to_Get_SharedPreferences(View v) {

		Context firstAppContext = null;
		try {
			firstAppContext = createPackageContext("com.example.androidetest",
					Context.CONTEXT_IGNORE_SECURITY);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		SharedPreferences sharedPreferences = firstAppContext
				.getSharedPreferences("android_test",
						Context.MODE_WORLD_READABLE);
		String name = sharedPreferences.getString("name", "");
		tv.setText(name);
	}
}
