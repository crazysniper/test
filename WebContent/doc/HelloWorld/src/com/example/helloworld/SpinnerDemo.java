package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerDemo extends Activity {

	private TextView tv,receivedata1,receivedata2;
	private Spinner sp;
	private ArrayAdapter<String> adapter;
	private static final String[] m={"A型","B型","O型","AB型","其他"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinnerdemo);
		initView();
		getData();
	}
	
	public void initView(){
		tv = (TextView) findViewById(R.id.tv);
		receivedata1 =(TextView)findViewById(R.id.receivedata1);
		receivedata2 =(TextView)findViewById(R.id.receivedata2);
		sp = (Spinner) findViewById(R.id.sp);
		adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, m);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	// 设置列表项的显示风格
		sp.setAdapter(adapter); // 设置显示信息
		sp.setOnItemSelectedListener(new SpinnerSelectedListener());
		sp.setVisibility(View.VISIBLE);
	}
	
	public void getData(){
		Intent intent=getIntent();
//		Bundle bundle=intent.getBundleExtra("key");
		Bundle bundle=intent.getExtras();
		receivedata1.setText(String.valueOf(bundle.getInt("id")));
		receivedata2.setText(bundle.getString("name"));
	}
	
	class SpinnerSelectedListener implements OnItemSelectedListener{
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			tv.setText("血型是："+m[arg2]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
		
	}
}
