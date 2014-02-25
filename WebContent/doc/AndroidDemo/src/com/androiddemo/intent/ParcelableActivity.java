package com.androiddemo.intent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.androiddemo.activity.R;
import com.androiddemo.entity.BookEntity;

public class ParcelableActivity extends Activity {

	private TextView tv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parcelable_demo);
		initView();
	}

	public void initView() {
		tv = (TextView) findViewById(R.id.tv_parcelable);
		BookEntity be = getIntentData();
		tv.setText("bookname is:" + be.getBookName() + "\nauthor is:"
				+ be.getAuthor() + "\npublishtime is:" + be.getPublishTime());
	}

	public BookEntity getIntentData() {
		BookEntity be = getIntent().getParcelableExtra(IntentActivity.PAR_KEY);
		return be;
	}
}
