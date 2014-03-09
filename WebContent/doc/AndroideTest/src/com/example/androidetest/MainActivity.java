package com.example.androidetest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et;
	private SharedPreferences spf;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	public void initView() {
		et = (EditText) findViewById(R.id.input);
	}

	public void submit(View v) {
		String aa = et.getText().toString();
		TextUtils.isEmpty(aa);
		if ("".equals(aa)) {
			Toast.makeText(this, "不可为空", Toast.LENGTH_SHORT).show();
		} else {
			spf = this.getSharedPreferences("android_test",
					Context.MODE_WORLD_READABLE);
			editor = spf.edit();
			editor.putString("name", aa);
			editor.commit();
		}

	}
}
