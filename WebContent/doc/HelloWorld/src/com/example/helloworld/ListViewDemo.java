package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
	
//	public void setData(){
//		Intent intent=getIntent();
//		Bundle bundle=intent.getExtras();
//		SimpleAdapter adapter=new SimpleAdapter(this,bundle,R.layout.listviewitem,
//				new String{},
//				new int[]{R.id.tvid,R.id.tvname}
//				);
//		
//	}
}
