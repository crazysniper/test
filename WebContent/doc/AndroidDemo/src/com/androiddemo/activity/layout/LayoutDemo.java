package com.androiddemo.activity.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androiddemo.activity.R;

/**
 * 布局管理
 * 
 * @author Gao
 * 
 */
public class LayoutDemo extends Activity {

	private Button toRelativeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);
		initView();
	}

	public void initView() {
		toRelativeLayout = (Button) findViewById(R.id.toRelativeLayout);
		toRelativeLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Intent intent =new Intent();
				// intent.setClass(LayoutDemo.this, RelativeLayoutDemo.class);
				// startActivity(intent);
				startActivity(new Intent(LayoutDemo.this, RelativeLayoutDemo.class));
			}
		});
	}

	public void toLinearLayout(View view) {
		// startActivity(new Intent(LayoutDemo.this,LinearLayoutDemo.class));
		startActivity(new Intent(this, LinearLayoutDemo.class));
	}

	public void toTableLayout(View view) {
		startActivity(new Intent(this, TableLayoutDemo.class));
	}

	public void toFrameLayout(View view) {
		startActivity(new Intent(this, FrameLayoutDemo.class));
	}

	public void toShowToast(View view) {
		Toast.makeText(this, "显示提示信息", Toast.LENGTH_LONG).show();
	}

}
