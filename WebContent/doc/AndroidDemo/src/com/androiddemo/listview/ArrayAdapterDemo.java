package com.androiddemo.listview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androiddemo.activity.R;

public class ArrayAdapterDemo extends Activity {

	private ListView list1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.array_listviewdemo);
		initView();
	}

	public void initView() {
		list1 = (ListView) findViewById(R.id.list1);
		String[] arr1 = { "孙悟空", "猪八戒", "沙和尚" };
		// 第二个参数是列表项组件
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				R.layout.array_item, arr1);
		list1.setAdapter(adapter1);
	}
}
