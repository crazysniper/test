package com.androiddemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActivityOne extends Activity {

	private static final String TAG = "ActivityOne";

	/**
	 * 当 activity 第一次创建时会被调用
	 * 调用该方法后一般会调用 onStart() 方法。
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		Log.i(TAG, "onCreate");
	}

	/**
	 * 当 activity 对于用户可见前即调用这个方法。
	 * 如果 activity回到前台则接着调用 onResume() ，如果 activity 隐藏则调用onStop()
	 */
	@Override
	protected void onStart() {
		Log.i(TAG, "onStart");
		super.onStart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, "onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, "onStop");
		super.onStop();
	}

	/**
	 * 在 activity 被停止后重新启动时会调用该方法。其后续会调用 onStart 方法。
	 */
	@Override
	protected void onRestart() {
		Log.i(TAG, "onRestart");
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	}

}