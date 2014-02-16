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
		setContentView(R.layout.adapterandlistview);
	}
	
	public void toArrayAdapter(View view){
		startActivity(new Intent(this,ArrayAdapterDemo.class));
	}
	
	public void toSimpleAdapter(View view){
		startActivity(new Intent(this,SimpleAdapteDemo.class));
	}
}
