package com.androiddemo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androiddemo.activity.R;

public class NextActivity extends Activity {

	private TextView tv;
	private Button toStartAtivityForResult1;
	private EditText et_y;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_next);
		Intent intent = getIntent();
		String b = intent.getStringExtra("one");

		tv = (TextView) findViewById(R.id.tv_y);
		toStartAtivityForResult1 = (Button) findViewById(R.id.toStartAtivityForResult1);
		et_y = (EditText)findViewById(R.id.et_y);
		
		tv.setText(b);
		toStartAtivityForResult1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 新声明一个Intent用于存放放回的数据
				Intent i = new Intent();
				String result = et_y.getText().toString();
				i.putExtra("three", result);
				setResult(2, i);// 设置resultCode，onActivityResult()中能获取到
				finish();// 使用完成后结束当前Activity的生命周期
			}
		});
	}
}
