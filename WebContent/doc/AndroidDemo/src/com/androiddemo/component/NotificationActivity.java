package com.androiddemo.component;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.androiddemo.activity.R;

public class NotificationActivity extends Activity {

	/**
	 * 通知，是一种让你的应用程序在不使用Activity的情况下警示用户。 它是看不见的程序组件(Broadcast
	 * Receiver，Service和不活跃的Activity)警示用户有需要注意的事件发生的最好途径。 Notification
	 * 是由NotificationManager(系统服务)统一管理的。
	 * 
	 * 一般来说， 一个Notification应该传送的消息包括： 1 、一个状态条图标
	 * 2、在拉伸的状态栏窗口中显示额外的信息和启动一个Application的Intent 3、闪灯或LED 4、电话震动
	 * 
	 * 在状态栏(Status Bar)中，通知主要有两类(使用FLAG_标记，后面讲解到)：
	 * 
	 * 1、正在运行的事件 2、通知事件
	 */
	static final int NOTIFICATION_ID = 0x123;
	NotificationManager nm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_dmeo);

		// 获取系统的NotificationManager服务
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
	}

//	// 为发送通知的按钮的点击事件定义事件处理方法
//	public void send(View source) {
//		// 创建一个启动其他Activity的Intent
//		Intent intent = new Intent(this, OtherActivity.class);
//		PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
//		Notification notify = new Notification.Builder(this)
//				// 设置打开该通知，该通知自动消失
//				.setAutoCancel(true)
//				// 设置显示在状态栏的通知提示信息
//				.setTicker("有新消息")
//				// 设置通知的图标
//				.setSmallIcon(R.drawable.ic_launcher)
//				// 设置通知内容的标题
//				.setContentTitle("一条新通知")
//				// 设置通知内容
//				.setContentText("恭喜你，您加薪了，工资增加20%!")
//				// // 设置使用系统默认的声音、默认LED灯
//				// .setDefaults(Notification.DEFAULT_SOUND |Notification.DEFAULT_LIGHTS)
//				// 设置通知的自定义声音
//				.setSound(Uri.parse("android.resource://com.androiddemo.activity/" + R.raw.msg))
//				.setWhen(System.currentTimeMillis())
//				// 设改通知将要启动程序的Intent
//				.setContentIntent(pi).build();
//		// 发送通知
//		nm.notify(NOTIFICATION_ID, notify);
//	}

	// 为删除通知的按钮的点击事件定义事件处理方法
	public void del(View v) {
		// 取消通知
		nm.cancel(NOTIFICATION_ID);
	}
}
