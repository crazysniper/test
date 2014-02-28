package com.androiddemo.broadcastreciver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androiddemo.activity.R;

public class BroadCastActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcastreciver_list);
	}

	public void toSendBroadCast(View v) {
		startActivity(new Intent(this, BroadCastTest.class));
	}
}
