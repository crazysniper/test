package com.androiddemo.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.androiddemo.activity.R;

public class HandlerDemo extends Activity {

	private TextView tv;
	private MyHandler myHandler;
	private MyThread m = new MyThread();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handle_demo);
		initView();
	}

	public void initView() {
		tv = (TextView) findViewById(R.id.tv_handler);
	}

	public void startHandler(View v) {
		myHandler=new MyHandler();
		new Thread(m).start();
		System.out
		.println("主线程的id是：" + Thread.currentThread().getId());
	}

	class MyHandler extends Handler {
		public MyHandler() {
		}

		public MyHandler(Looper looper) {
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Bundle b = msg.getData();
			String aa = b.getString("textStr");
			tv.setText(aa);
		}
	}

	class MyThread implements Runnable {
		int i = 1;

		@Override
		public void run() {
			while (i < 10) {
				System.out
						.println("当前线程的id是：" + Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message msg = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("textStr", "线程运行" + i + "次");
				i++;
				msg.setData(bundle);
				myHandler.sendMessage(msg);			// 通过sendMessage向Handler发送更新UIde消息
			}
			i = 1;		// 下次启动线程时重新计数
		}
	}
}
