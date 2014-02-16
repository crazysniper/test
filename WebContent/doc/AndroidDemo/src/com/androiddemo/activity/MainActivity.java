package com.androiddemo.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import com.androiddemo.activity.layout.LayoutDemo;
import com.androiddemo.listview.AdapterAndListView;
import com.androiddemo.sdcard.SDCardActivity;
import com.androiddemo.servicedemo.ServiceActivity;

/**
 * 主界面
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
	public void toSDCard(View view){
		startActivity(new Intent(this,SDCardActivity.class));
	}

	public void toService(View view){
		startActivity(new Intent(this,ServiceActivity.class));
	}
	
	// Back返回键的处理
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			new AlertDialog.Builder(this)

					.setTitle("退出程序")
					.setMessage("是否要退出？")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									System.exit(0);
								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
								}
							}).create().show();
		}
		return super.onKeyDown(keyCode, event);
	}
}
