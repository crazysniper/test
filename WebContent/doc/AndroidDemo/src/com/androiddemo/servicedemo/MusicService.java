package com.androiddemo.servicedemo;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MusicService extends Service {

	private static final String TAG = "MusicService";
	private MediaPlayer mediaPlayer;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	/**
	 * onCreate()， 创建mediaPlayer
	 */
	@Override
	public void onCreate() {
		Log.v(TAG, "onCreate");
		Toast.makeText(this, "show mdeia payer", Toast.LENGTH_SHORT).show();
		if (mediaPlayer == null) {
			// 在res文件夹下创建raw文件夹，之后，将视频或者音频文件拷贝到raw文件夹中，
			// 在程序中引用的时候就可以写成R.raw.xxx(xxx：视频或音频的名称)
//			mediaPlayer = MediaPlayer.create(this, R.raw.tmp);
			mediaPlayer.setLooping(false);
		}
	}

	/**
	 * 停止并释放mediaPlayer音乐资源，如果当执行context.stopService()时调用此方法
	 */
	@Override
	public void onDestroy() {
		Log.v(TAG, "onDestroy");
		Toast.makeText(this, "stop media player", Toast.LENGTH_SHORT).show();
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
	}

	/**
	 * onStart()， 通过获取Bundle bundle = intent.getExtras();， 
	 * 提取int op = bundle.getInt("op");
	 * 然后执行响应的音乐播放操作
	 */
	@Override
	public void onStart(Intent intent, int startId) {
		Log.v(TAG, "onStart");
		if (intent != null) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				int op = bundle.getInt("op");
				switch (op) {
				case 1:
					play();
					break;
				case 2:
					stop();
					break;
				case 3:
					pause();
					break;
				}
			}
		}
	}

	public void play() {
		if (!mediaPlayer.isPlaying()) {
			mediaPlayer.start();
		}
	}

	public void pause() {
		if (mediaPlayer != null && mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
		}
	}

	public void stop() {
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			try {
				// 在调用stop后如果需要再次通过start进行播放,需要之前调用prepare函数
				mediaPlayer.prepare();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
