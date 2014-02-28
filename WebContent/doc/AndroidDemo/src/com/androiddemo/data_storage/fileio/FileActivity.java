package com.androiddemo.data_storage.fileio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androiddemo.activity.R;

public class FileActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_demo);
	}

	// sd卡
	public void toSDCard(View view) {
		startActivity(new Intent(this, SDCardActivity.class));
	}

	// File存储
	public void toFileIO(View view) {
		startActivity(new Intent(this, FileIOActivity.class));
	}

}
