package com.androiddemo.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {

	private static final String TAG = "FirstService";
	
	/**
	 * �÷�����Service�������ʵ�ֵķ���
	 * ����һ��IBinder����Ӧ�ó������ͨ���ö�����Service���ͨ��
	 */
	@Override
	public IBinder onBind(Intent intent) {
		Log.e(TAG, "on bind");
		return null;
	}
	
	/**
	 * ���Service��û�����У����ȵ���onCreate()��Ȼ�����onStartCommand�����ɰ汾����onStart()
	 * ����Ѿ����У���ֻҪ����onStartCommand�����ɰ汾����onStart()
	 * ����һ��Service��onStart()���ܻ��ظ����ö��
	 */
	@Override
	public void onCreate() {
		System.out.println("----onCreate-----");  
		Log.e(TAG, "on creat");
		super.onCreate();
	}
	
	/**
	 * �÷�������汾��onStart(Intent intent, int startId)
	 * ÿ�οͻ��˵���startService(intent)����������Serviceʱ������ص��η���
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
