package com.androiddemo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androiddemo.activity.R;
import com.androiddemo.entity.BookEntity_Parcelable;
import com.androiddemo.entity.TeacherEntity_Serializable;

public class IntentActivity extends Activity {

	/**
	 * android 中自定义的对象序列化的问题有两个选择一个是Parcelable，另外一个是Serializable。 
	 * 
	 * 一 序列化原因：
	 * 1.永久性保存对象，保存对象的字节序列到本地文件中；
	 * 2.通过序列化对象在网络中传递对象； 
	 * 3.通过序列化在进程间传递对象。
	 * 
	 * 二 至于选取哪种可参考下面的原则：
	 * 
	 * 1.在使用内存的时候，Parcelable 类比Serializable性能高，所以推荐使用Parcelable类。
	 * 2.Serializable在序列化的时候会产生大量的临时变量，从而引起频繁的GC。
	 * 3.Parcelable不能使用在要将数据存储在磁盘上的情况， 因为Parcelable不能很好的保证数据的持续性在外界有变化的情况下。
	 * 
	 * 尽管Serializable效率低点,也不提倡用，但在这种情况下，还是建议你用Serializable 。
	 * 
	 * 实现： 
	 * 1、 Serializable 的实现，只需要继承 implements Serializable  即可。这只是给对象打了一个标记，系统会自动将其序列化。
	 * 2、 Parcelabel 的实现，需要在类中添加一个静态成员变量 CREATOR，这个变量需要继承 Parcelable.Creator 接口。
	 */
	private final String TAG = "IntentActivity";
	public final static String SER_KEY = "toSerializable";
	public final static String PAR_KEY = "toParcelable";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent_demo);
	}

	// Serializeable传递对象的方法  
	public void toSerializable(View v) {
		Log.i(TAG, "toSerializable");
		TeacherEntity_Serializable te = new TeacherEntity_Serializable();
		te.setTecId(1);
		te.setTecName("Li");
		te.setTecAge(13);
		Intent intent = new Intent(this, SerializableActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable(SER_KEY, te);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	
	// Pacelable传递对象方法 
	public void toParcelable(View v) {
		Log.i(TAG, "toParcelable");
		BookEntity_Parcelable be = new BookEntity_Parcelable();
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
