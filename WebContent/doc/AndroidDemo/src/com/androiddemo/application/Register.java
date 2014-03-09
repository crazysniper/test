package com.androiddemo.application;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androiddemo.activity.R;
import com.androiddemo.util.HttpUtil;

public class Register extends Activity {

	private EditText et_qq;
	private EditText et_password;
	private  String qq, password;
	private static final int REGISTER_SUCCESS = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		initView();
	}

	public void initView() {
		et_qq = (EditText) findViewById(R.id.et_qq);
		et_password = (EditText) findViewById(R.id.et_password);
	}

	public void bt_register(View v) {
		if (validate()) {
			new Thread(runnable).start();
		}
	}

	public boolean validate() {
		qq = et_qq.getText().toString();
		password = et_password.getText().toString();
		if (TextUtils.isEmpty(password) || TextUtils.isEmpty(qq)) {
			Toast.makeText(this, "不可为空", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			String aaaa = null;
			qq = et_qq.getText().toString();
			password = et_password.getText().toString();
			aaaa = login(qq, password);
			registerHandler.obtainMessage(REGISTER_SUCCESS, aaaa)
					.sendToTarget();
		}
	};

	@SuppressLint("HandlerLeak")
	private Handler registerHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what != REGISTER_SUCCESS) {
				Toast.makeText(Register.this, "成功失败", Toast.LENGTH_SHORT)
						.show();
			} else if (msg.obj.equals("OK")) {
				Toast.makeText(Register.this, "成功注册", Toast.LENGTH_SHORT)
						.show();
			} else {
				Toast.makeText(Register.this, "成功失败", Toast.LENGTH_SHORT)
				.show();
			}
		}
	};

	// 根据用户名称密码查询
	private String login(String account, String password) {
		// 查询参数
		String queryString = "username=" + account + "&pass=" + password;
		// url
		String url = HttpUtil.BASE_URL + "login?" + queryString;
		// 查询返回结果
		String result = HttpUtil.login(url);
		Log.i("aaaaa", result);
		return result;
	}
}
