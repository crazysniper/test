package com.androiddemo.servicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.androiddemo.activity.R;

/**
 * 通过重写OnClickListener 接口onClick()方法实现对播放音乐的控制，
 * 把音乐各种操作用数字通过Intent传递给service
 * @author gaofeng2
 * 
 */
public class PlayMusicActivity extends Activity implements OnClickListener {

	private Button playBtn, stopBtn, pauseBtn, exitBtn, closeBtn;
	private Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_service);
		initView();
	}

	public void initView() {
		playBtn = (Button) findViewById(R.id.play);
		stopBtn = (Button) findViewById(R.id.stop);
		pauseBtn = (Button) findViewById(R.id.pause);
		exitBtn = (Button) findViewById(R.id.exit);
		closeBtn = (Button) findViewById(R.id.close);

		playBtn.setOnClickListener(this);
		stopBtn.setOnClickListener(this);
		pauseBtn.setOnClickListener(this);
		exitBtn.setOnClickListener(this);
		closeBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int op = -1;
		// 构造一个Intent ， intent = new Intent("com.homer.service.musicService");
		// 其中，com.homer.service.musicService是 AndroidManifest.xml
		// 对service的定义，即上面“注册service”
		intent = new Intent("com.androiddemo.musicservice");

		switch (v.getId()) {
		case R.id.play: // play music
			op = 1;
			break;
		case R.id.stop: // stop music
			op = 2;
			break;
		case R.id.pause: // pause music
			op = 3;
			break;
		case R.id.close: // close activity
			// 只是执行了this.finish(); 关闭了本Activity窗体，
			// service并没有被关掉，音乐依然会继续在后台播放
			this.finish();
			break;
		case R.id.exit: // stopService
			op = 4;
			// 先调用了stopService(intent); 关闭了service服务，
			// 在Service中会调用3中的onDestroy()停止并释放音乐资源，
			// 然后才执行this.finish(); 关闭了本Activity窗体
			stopService(intent);
			this.finish();
			break;
		}

		// 利用Bundle绑定数字op后，通过 startService(intent); 服务后发送出去
		Bundle bundle = new Bundle();
		bundle.putInt("op", op);
		intent.putExtras(bundle);
		startService(intent); // startService
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (intent != null) {
			stopService(intent);
		}
	}
}
