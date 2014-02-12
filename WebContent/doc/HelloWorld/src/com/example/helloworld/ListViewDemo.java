package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ListViewDemo extends Activity {

	private ListView lt;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewdemo);
		initView();
	}

	public void initView() {
		lt = (ListView) findViewById(R.id.listview);
	}
}
