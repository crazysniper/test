package com.androiddemo.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

public class ActivityOne extends Activity {

	private static final String TAG = "ActivityOne";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		Log.i(TAG, "onCreate");
	}

	public void toActivityTwo(View v) {
		startActivity(new Intent(this, ActivityTwo.class));
	}

	@Override
	protected void onStart() {
		Log.i(TAG, "onStart");
		super.onStart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, "onResume");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, "onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, "onStop");
		super.onStop();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, "onRestart");
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		Log.i(TAG, "onDestroy");
		super.onDestroy();
	}

	// 创建普通的对话框
	public void btnGeneral(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示"); // 设置标题
		builder.setMessage("这是一个普通的对话框"); // 设置提示消息
		builder.setIcon(R.drawable.ic_launcher);
		builder.setCancelable(false);
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				dialog.cancel();
			}
		});
		builder.create().show();
	}

	public void pop(View v) {
		// 弹出菜单是停靠在一个View上的一个模式菜单。如果View对象下方有空间，那么弹出菜单将显示在停靠对象的下方，否则会显示在上方。
		/**
		 * 用它的构造器实例化一个PopupMenu对象，它需要当前应用程序的Context和菜单要停靠的那个View两个对象作为参数。
		 * 使用MenuInflater对象把你的菜单资源装载到由PopupMenu.getMenu()方法返回的Menu对象中。 在API 级别
		 * 14以上的版本，你能够使用PopupMenu.inflate()方法来替代。 调用PopupMenu.show()方法来显示弹出菜单。
		 */
		final PopupMenu popupMenu = new PopupMenu(this, v);
		MenuInflater menuInflater = new MenuInflater(this);
		menuInflater.inflate(R.menu.context, popupMenu.getMenu());
		popupMenu.show();
		popupMenu
				.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.context1:
							Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
							startActivity(intent);
							finish();
							break;
						case R.id.context2:
							break;
						case R.id.context3:
							break;
						case R.id.context4:
							break;
						// 群发短信
						case R.id.context5:
							break;
						// json导入数据
						case R.id.context6:
							break;
						default:
							break;
						}
						return false;
					}
				});
	}
}
