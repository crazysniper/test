package com.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.androiddemo.activity.layout.LayoutDemo;
import com.androiddemo.listview.AdapterAndListView;

/**
 * Ö÷½çÃæ
 * @author Gao
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void toLayout(View view){
		startActivity(new Intent(this,LayoutDemo.class));
	}
	public void toAdapterAndListView(View view){
		startActivity(new Intent(this,AdapterAndListView.class));
	}
}
