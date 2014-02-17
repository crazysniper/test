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
		// ֹͣService
		this.stopService(firstServiceIntent);
		// ����Service ��startService()����Service
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
		// ֹͣService
		// this.stopService(serviceIntent);
		// ����Service
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
		// ��Service  
        bindService(thirdServiceIntent, conn, BIND_AUTO_CREATE); 
	}
	
	
	public void toUnBindThirdService(View view) {
		// ���Service  
        unbindService(conn); 
	}

	// ��ȡ�����Service����״̬
	public void toGetThirdServiceStatus(View view){
		Toast.makeText(this, "Service��countֵ�ǣ�"+binder.getCount(), Toast.LENGTH_LONG).show();
	}
	
	// ������������Service��IBinder����
	ThirdService.MyBinder binder;
	// ����һ��ServiceConnection����
	private ServiceConnection conn = new ServiceConnection() {
		// ���ͻ�����Service��������ʱ���ص��÷���
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("---onServiceConnected----");
			// ��ȡService��onBind������ص�MyBinder����
			binder = (ThirdService.MyBinder) service;
		}

		// ���ͻ�����Service�Ͽ�����ʱ���ص��÷���
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("---onServiceDisconnected----");
		}
	};
	
	public void toMusic(View view){
		startActivity(new Intent(this, PlayMusicActivity.class));
	}
}
