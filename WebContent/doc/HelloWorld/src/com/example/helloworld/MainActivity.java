package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv;
	private EditText et1, et2, et3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	public void initView() {
		tv = (TextView) findViewById(R.id.showinput);
		et1 = (EditText) findViewById(R.id.et1);
		et2 = (EditText) findViewById(R.id.et2);
		et3 = (EditText) findViewById(R.id.et3);
	}

	public void showInput(View view) {
		tv.setText(et1.getText().toString());
	}

	public void toTab(View view) {
		// 黑色的，任何消息都会输出，这里的v代表verbose啰嗦的意思，平时使用就是Log.v("","");
		Log.v("vvv", "vvvvv");
		// 蓝色的，仅输出debug调试的意思，但他会输出上层的信息，过滤起来可以通过DDMS的Logcat标签来选择.
		Log.d("ddd", "ddddd");
		// 绿色，一般提示性的消息information，它不会输出Log.v和Log.d的信息，但会显示i、w和e的信息
		Log.i("iii", "iiiii");
		// 橙色，可以看作为warning警告，一般需要我们注意优化Android代码，同时选择它后还会输出Log.e的信息。
		Log.w("www", "wwwww");
		// 红色，可以想到error错误，这里仅显示红色的错误信息，这些错误就需要我们认真的分析，查看栈的信息了。
		Log.e("eee", "eeeee");
		Intent intent = new Intent(this, TabDemo.class);
		startActivity(intent);
//		finish();
	}

	public void toSpinner(View view) {
		Intent intent = new Intent(this, SpinnerDemo.class);
		Bundle bundle = new Bundle();
		int i = Integer.valueOf(et2.getText().toString());
		String name = et3.getText().toString();
		bundle.putInt("id", i);
		bundle.putString("name", name);
		// intent.putExtra("key",bundle);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	public void toListView(View view) {
		Intent intent = new Intent(this, ListViewDemo.class);
		Bundle bundle = new Bundle();
		for (int i = 0; i < 10; i++) {
			bundle.putString("name" + i, "name" + i);
		}
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
