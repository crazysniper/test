package com.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 开机欢迎界面
 * @author Gao
 *
 */
public class StartActivity extends Activity implements Runnable {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		new Thread(this).start();
	}
	
	public void run() {
		try {
			// 1秒后跳转到主界面
			Thread.sleep(500);
			startActivity(new Intent(this, MainActivity.class));
			finish();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
