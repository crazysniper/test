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
	// ����onBinder���������صĶ���
	private MyBinder binder = new MyBinder();

	/**
	 * ͨ���̳�Binder��ʵ��IBinder
	 * �½�һ��Binder���������ṩ���ͻ���
	 */
	public class MyBinder extends Binder {
		public int getCount() {
			return count;
		}
	}

	/**
	 * �÷�����Service�������ʵ�ֵķ��� ����һ��IBinder����Ӧ�ó������ͨ���ö�����Service���ͨ��
	 */
	@Override
	public IBinder onBind(Intent intent) {
		// ���ظ��ͻ���һ��Binder����
		Log.e(TAG, "on bind");
		return binder;
	}

	@Override
	public void onCreate() {
		System.out.println("----onCreate-----");
		// ����һ���̣߳���̬�޸�count״ֵ̬
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
	 * Service���Ͽ�����ʱ�ص��÷���
	 */
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("----onUnbind-----");
		return super.onUnbind(intent);
	}

	/**
	 * Service���ر�֮ǰ�ص��÷���
	 */
	@Override
	public void onDestroy() {
		this.quit = true;
		System.out.println("----onDestory-----");
		super.onDestroy();
	}

}
