package com.androiddemo.listview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androiddemo.activity.R;

public class AdapterAndListView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adapter_and_listview);
	}

	public void toArrayAdapter(View view) {
		startActivity(new Intent(this, ArrayAdapterDemo.class));
	}

	public void toSimpleAdapter(View view) {
		startActivity(new Intent(this, SimpleAdapteDemo.class));
	}

	public void toBaseAdapter(View v) {
		startActivity(new Intent(this, BaseAdapterActivity.class));
	}

	public void toSelect(View v) {
		startActivity(new Intent(this, Ex_checkboxActivity.class));
	}
}
