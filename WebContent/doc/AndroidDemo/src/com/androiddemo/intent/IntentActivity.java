package com.androiddemo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androiddemo.activity.R;
import com.androiddemo.entity.BookEntity;
import com.androiddemo.entity.TeacherEntity;

public class IntentActivity extends Activity {

	private final String TAG = "IntentActivity";
	public final static String SER_KEY = "toSerializable";
	public final static String PAR_KEY = "toParcelable";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_demo);
	}

	public void toSerializable(View v) {
		Log.i(TAG, "toSerializable");
		TeacherEntity te = new TeacherEntity();
		te.setTecId(1);
		te.setTecName("Li");
		te.setTecAge(13);
		Intent intent = new Intent(this, SerializableActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable(SER_KEY, te);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	public void toParcelable(View v) {
		Log.i(TAG, "toParcelable");
		BookEntity be = new BookEntity();
		be.setBookName("Android Tutor");
		be.setAuthor("Frankie");
		be.setPublishTime(2010);
		Intent intent = new Intent(this, ParcelableActivity.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable(PAR_KEY, be);
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
