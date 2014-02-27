package com.androiddemo.data_storage.sqlite;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SQLiteActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_demo);
	}
	
	public void toContentValues(View v){
		startActivity(new Intent(this,StudentSQLiteActivity.class));
	}
}
