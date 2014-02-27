package com.androiddemo.application;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Dail_List_Demo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.application_dail_demo);
	}

	// 直接拨号
	public void toCallIntent(View v) {
		Intent callIntent =new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345678"));
		startActivity(callIntent);
	}
	
	// 将号码存入拨号程序
	public void toDailIntent(View v) {
		Intent dailIntent =new Intent(Intent.ACTION_DIAL,Uri.parse("tel:12345678"));
		startActivity(dailIntent);
	}

	// 调用拨号程序
	public void toTouchDailerIntent(View v) {
		Intent touchDailerIntent =new Intent("com.android.photo.action.TOUCH_DAILER");
		startActivity(touchDailerIntent);
	}
	
	// 调用系统浏览器网页
	public void toWebIntent(View v) {
		Intent webIntent =new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
		startActivity(webIntent);
	}
	
	// 调用系统程序查看联系人
	public void toContactListIntent(View v) {
		Intent contactListIntent =new Intent("com.android.contacts.action.LIST_CONTACTS");
		startActivity(contactListIntent);
	}
	
	// 显示系统设置界面
	public void toSettingIntent(View v) {
		Intent settingIntent =new Intent("android.setting.SETTINGS");
		startActivity(settingIntent);
	}
	
	// 显示Wi-Fi设置界面
	public void toWifiSettingIntent(View v) {
		Intent wifiSettingIntent =new Intent("android.setting.WIFI_SETTINGS");
		startActivity(wifiSettingIntent);
	}
	
}
