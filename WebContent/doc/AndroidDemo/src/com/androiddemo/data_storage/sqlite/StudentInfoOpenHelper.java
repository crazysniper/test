package com.androiddemo.data_storage.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class StudentInfoOpenHelper extends SQLiteOpenHelper {

	private static final String TAG = "StudentInfoOpenHelper";
	private static final String dbname = "studentinfo.db";
	private static final int dbversion = 1;

	// 实现一个默认的构造方法
	public StudentInfoOpenHelper(Context context) {
		// 数据库连接的初始化，中间的那个null，是一个CursorFactory参数，没有仔细研究这个参数，暂时置空吧。
		super(context, dbname, null, dbversion);
	}

	/**
	 * 这里面的onCreate是指数据库onCreate时，而不是DatabaseHelper的onCreate。 也就是说，如果已经指定
	 * database已经存在，那么在重新运行程序的时候，就不会执行这个方法了。 要不然，岂不是每次重新启动程序都要重新创建一次数据库了！
	 * 在这个方法中，完成了数据库的创建工作。也就是那个execSQL()方法
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d(TAG, "onCreate");
		String sql = "create table if not exists student (_id integer primary key autoincrement,name varhcar(10) not null,age integer);";
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(TAG, "onUpgrade");
	}

}
