package com.androiddemo.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.androiddemo.activity.R;
import com.androiddemo.entity.TeacherEntity_Serializable;

public class SerializableActivity extends Activity {

	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.serializable_demo);
		initView();
	}

	public void initView() {
		tv = (TextView) findViewById(R.id.tv_serializable);
		TeacherEntity_Serializable te = getIntentData();
		tv.setText("id is:" + te.getTecId() + "\nname is:" + te.getTecName()
				+ "\nage is:" + te.getTecAge());

	}

	public TeacherEntity_Serializable getIntentData() {
		TeacherEntity_Serializable te = (TeacherEntity_Serializable) getIntent().getSerializableExtra(
				IntentActivity.SER_KEY);
		return te;
	}
}
