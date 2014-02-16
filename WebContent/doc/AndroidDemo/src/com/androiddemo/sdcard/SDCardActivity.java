package com.androiddemo.sdcard;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.androiddemo.activity.R;

/**
 * sdcard
 * 
 * @author Gao
 * 
 */
public class SDCardActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sdcard);
		initView();
	}

	public void initView() {
		String result = "";
		// 获取文件默认存储位置的绝对路径
		File fileDir = this.getFilesDir();
		Log.i("文件路径", fileDir.getPath());
		result += "文件路径 \n fileDir.getPath():" + fileDir.getPath();
		result += "\n fileDir.getAbsolutePath()：" + fileDir.getAbsolutePath();
		result += "\n fileDir.getName():" + fileDir.getName();

		// 获取外部存储设备的当前状态
		String externalStorageState = Environment.getExternalStorageState();
		// Environment.MEDIA_MOUNTED代表着外部存储设备存在，并且是可读写的
		if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
			// getExternalStorageDirectory获取外部存储设备的路径
			Log.i("SDcard路径", Environment.getExternalStorageDirectory().getAbsolutePath());
			File file = new File(Environment.getExternalStorageDirectory(), "chenzheng_java.txt");
			result += "   sdcard绝对路径：" + Environment.getExternalStorageDirectory().getAbsolutePath();
			result += " \n  sdcard路径：" + Environment.getExternalStorageDirectory().getPath();
			if (!file.exists()) {
				try {
					file.createNewFile();
					Log.i("结果", "创建成功。");
				} catch (IOException e) {
					Log.i("结果", "创建没成功。");
					e.printStackTrace();
				}
			}
		}
		TextView textView = (TextView) findViewById(R.id.textView);
		textView.setText(result);
	}

}
