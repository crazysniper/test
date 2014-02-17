package com.androiddemo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	private static final String TAG = "FirstService";
	
	/**
	 * 该方法是Service子类必须实现的方法
	 * 返回一个IBinder对象，应用程序可以通过该对象与Service组件通信
	 */
	@Override
	public IBinder onBind(Intent intent) {
		Log.e(TAG, "on bind");
		return null;
	}
	
	/**
	 * 如果Service还没有运行，则先调用onCreate()，然后调用onStartCommand，，旧版本调用onStart()
	 * 如果已经运行，则只要调用onStartCommand，，旧版本调用onStart()
	 * 所有一个Service的onStart()可能会重复调用多次
	 */
	@Override
	public void onCreate() {
		System.out.println("----onCreate-----");  
		Log.e(TAG, "on creat");
		super.onCreate();
	}
	
	/**
	 * 该方法早起版本是onStart(Intent intent, int startId)
	 * 每次客户端调用startService(intent)方法启动该Service时，都会回调次方法
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("----onStartCommand-----");  
		Log.e(TAG, "on startCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		System.out.println("----onDestory-----");
		Log.e(TAG, "on destroy");
		super.onDestroy();
	}

}
