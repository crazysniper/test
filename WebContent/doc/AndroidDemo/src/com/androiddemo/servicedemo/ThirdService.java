package com.androiddemo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ThirdService extends Service {

	private int count;
	private boolean quit;
	private static final String TAG = "ThirdService";
	// 定义onBinder方法所返回的对象
	private MyBinder binder = new MyBinder();

	/**
	 * 通过继承Binder来实现IBinder
	 * 新建一个Binder对象用于提供给客户端
	 */
	public class MyBinder extends Binder {
		public int getCount() {
			return count;
		}
	}

	/**
	 * 该方法是Service子类必须实现的方法 返回一个IBinder对象，应用程序可以通过该对象与Service组件通信
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// 返回给客户端一个Binder对象
		Log.e(TAG, "on bind");
		return binder;
	}

	@Override
	public void onCreate() {
		System.out.println("----onCreate-----");
		// 启动一条线程，动态修改count状态值
		new Thread() {
			@Override
			public void run() {
				while (!quit) {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
					count++;
				}
			}
		}.start();
	}

	/**
	 * Service被断开连接时回调该方法
	 */
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("----onUnbind-----");
		return super.onUnbind(intent);
	}

	/**
	 * Service被关闭之前回调该方法
	 */
	@Override
	public void onDestroy() {
		this.quit = true;
		System.out.println("----onDestory-----");
		super.onDestroy();
	}

}
