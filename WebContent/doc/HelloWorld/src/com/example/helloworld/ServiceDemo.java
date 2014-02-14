package com.example.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceDemo extends Service {

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	@Override
	public void onCreate() {

	}

	@Override
	public void onDestroy() {

	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return startId;
	}
	
}
