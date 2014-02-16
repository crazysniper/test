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
		// ��ȡ�ļ�Ĭ�ϴ洢λ�õľ���·��
		File fileDir = this.getFilesDir();
		Log.i("�ļ�·��", fileDir.getPath());
		result += "�ļ�·�� \n fileDir.getPath():" + fileDir.getPath();
		result += "\n fileDir.getAbsolutePath()��" + fileDir.getAbsolutePath();
		result += "\n fileDir.getName():" + fileDir.getName();

		// ��ȡ�ⲿ�洢�豸�ĵ�ǰ״̬
		String externalStorageState = Environment.getExternalStorageState();
		// Environment.MEDIA_MOUNTED�������ⲿ�洢�豸���ڣ������ǿɶ�д��
		if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
			// getExternalStorageDirectory��ȡ�ⲿ�洢�豸��·��
			Log.i("SDcard·��", Environment.getExternalStorageDirectory().getAbsolutePath());
			File file = new File(Environment.getExternalStorageDirectory(), "chenzheng_java.txt");
			result += "   sdcard����·����" + Environment.getExternalStorageDirectory().getAbsolutePath();
			result += " \n  sdcard·����" + Environment.getExternalStorageDirectory().getPath();
			if (!file.exists()) {
				try {
					file.createNewFile();
					Log.i("���", "�����ɹ���");
				} catch (IOException e) {
					Log.i("���", "����û�ɹ���");
					e.printStackTrace();
				}
			}
		}
		TextView textView = (TextView) findViewById(R.id.textView);
		textView.setText(result);
	}

}
