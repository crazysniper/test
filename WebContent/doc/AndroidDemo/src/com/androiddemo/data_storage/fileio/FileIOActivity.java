package com.androiddemo.data_storage.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.androiddemo.activity.R;

public class FileIOActivity extends Activity {

	// 文件名称
	private static final String FILE_NAME = "temp.txt";
	private EditText writeEdit;
	private EditText readEdit;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_io);
		initView();
	}

	public void initView() {
		writeEdit = (EditText) findViewById(R.id.write_edit);
		readEdit = (EditText) findViewById(R.id.read_edit);
	}

	// 保存
	public void writeFile(View v) {
		write(writeEdit.getText().toString());
	}

	// 读
	public void readFile(View v) {
		readEdit.setText(read());
	}

	private void write(String content) {
		try {
			FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
			fos.write(content.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String read() {
		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			byte[] bytes = new byte[1024];
			fis.read(bytes);
			return new String(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
