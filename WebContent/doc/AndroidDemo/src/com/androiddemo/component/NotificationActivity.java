package com.androiddemo.component;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
	int notification_id=19172439;
	NotificationManager nm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification_dmeo);
		// 获取系统的NotificationManager服务
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Button bt1 = (Button) findViewById(R.id.send);
		bt1.setOnClickListener(bt1lis);
		Button bt2 = (Button) findViewById(R.id.del);
		bt2.setOnClickListener(bt2lis);
	}

	OnClickListener bt1lis = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			showNotification(R.drawable.notify, "图标边的文字", "标题", "内容");
		}
	};
	
	OnClickListener bt2lis = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// showNotification(R.drawable.home,"图标边的文字","标题","内容");
			nm.cancel(notification_id);
		}
	};

	public void showNotification(int icon, String tickertext, String title,
			String content) {
		// 设置一个唯一的ID，随便设置
		// Notification管理器
		Notification notification = new Notification(icon, tickertext,
				System.currentTimeMillis());
		// 后面的参数分别是显示在顶部通知栏的小图标，小图标旁的文字（短暂显示，自动消失）系统当前时间（不明白这个有什么用）
		notification.defaults = Notification.DEFAULT_ALL;
		// 这是设置通知是否同时播放声音或振动，声音为Notification.DEFAULT_SOUND
		// 振动为Notification.DEFAULT_VIBRATE;
		// Light为Notification.DEFAULT_LIGHTS，在我的Milestone上好像没什么反应
		// 全部为Notification.DEFAULT_ALL
		// 如果是振动或者全部，必须在AndroidManifest.xml加入振动权限
		PendingIntent pt = PendingIntent.getActivity(this, 0, new Intent(this,
				OtherActivity.class), 0);
		// 点击通知后的动作，这里是转回main 这个Acticity
		notification.setLatestEventInfo(this, title, content, pt);
		nm.notify(notification_id, notification);
	}
}
