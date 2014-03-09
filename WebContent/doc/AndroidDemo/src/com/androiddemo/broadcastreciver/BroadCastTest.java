package com.androiddemo.broadcastreciver;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BroadCastTest extends Activity {

	// 该receiver在Manifest.xml中注册
	private static final String MY_ACTION="org.hualang.broadcast.action.MY_ACTION";  
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcastreciver_demo1);
	}
	
	public void toSendBroadCast(View v) {
		Intent intent = new Intent();
		intent.setAction(MY_ACTION);
		intent.putExtra("msg", "这是普通广播");
		sendBroadcast(intent);
	}
	
	public void btnBasicSendOrdered(View v){
		Intent intent = new Intent(MY_ACTION);
		intent.putExtra("msg", "这是有序广播");
		sendOrderedBroadcast(intent, null);
	}
}
