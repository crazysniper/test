package com.androiddemo.servicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import com.androiddemo.activity.R;

/**
 * http://blog.csdn.net/jiahui524/article/details/6965440
 * @author Gao
 *
 */
public class ServiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicedemo);
	}

	public void toStartFirstService(View view) {
		Intent firstServiceIntent = new Intent(ServiceActivity.this,
				FirstService.class);
		// 停止Service
		this.stopService(firstServiceIntent);
		// 启动Service 用startService()启动Service
		this.startService(firstServiceIntent);
	}

	public void toStopFirstService(View view) {
		Intent firstServiceIntent = new Intent(ServiceActivity.this,
				FirstService.class);
		this.stopService(firstServiceIntent);
	}

	public void toStartSecondService(View view) {
		Intent secondServiceIntent = new Intent(ServiceActivity.this,
				SecondService.class);
		secondServiceIntent.setAction("com.androirdemo.secondservice");
		// 停止Service
		// this.stopService(serviceIntent);
		// 启动Service
		this.startService(secondServiceIntent);
	}

	public void toStopSecondService(View view) {
		Intent secondServiceIntent = new Intent(ServiceActivity.this,
				SecondService.class);
		secondServiceIntent.setAction("com.androirdemo.secondservice");
		this.stopService(secondServiceIntent);
	}

	public void toBindThirdService(View view) {
		Intent thirdServiceIntent = new Intent(ServiceActivity.this, ThirdService.class);
		// 绑定Service  
        bindService(thirdServiceIntent, conn, BIND_AUTO_CREATE); 
	}
	
	
	public void toUnBindThirdService(View view) {
		// 解绑Service  
        unbindService(conn); 
	}

	// 获取第三个Service允许状态
	public void toGetThirdServiceStatus(View view){
		Toast.makeText(this, "Service的count值是："+binder.getCount(), Toast.LENGTH_LONG).show();
	}
	
	// 保持所启动的Service的IBinder对象
	ThirdService.MyBinder binder;
	// 定义一个ServiceConnection对象
	private ServiceConnection conn = new ServiceConnection() {
		// 当客户端与Service建立连接时，回调该方法
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("---onServiceConnected----");
			// 获取Service的onBind方法所返回的MyBinder对象
			binder = (ThirdService.MyBinder) service;
		}

		// 当客户端与Service断开连接时，回调该方法
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("---onServiceDisconnected----");
		}
	};
}
