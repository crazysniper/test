package com.androiddemo.broadcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		String msg = arg1.getStringExtra("msg");
		// 此处的makeText中第一个参数不可以直接写成this，而要写成 Context的对象
		Toast.makeText(arg0, msg, Toast.LENGTH_SHORT).show();
	}
}
