package com.androiddemo.component;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerDemo extends Activity {
	
	private TextView showchoosespinnner;
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private static final String[] m={"A型","B型","O型","AB型","其他"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinnerdemo);
		initView();
	}
	
	public void initView(){
		showchoosespinnner = (TextView) findViewById(R.id.showchoosespinnner);
		spinner = (Spinner) findViewById(R.id.spinner);
		adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, m);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	// 设置列表项的显示风格
		spinner.setAdapter(adapter); // 设置显示信息
		spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
		spinner.setVisibility(View.VISIBLE);
	}

	class SpinnerSelectedListener implements OnItemSelectedListener{
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			showchoosespinnner.setText(m[arg2]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			
		}
		
	}
}
