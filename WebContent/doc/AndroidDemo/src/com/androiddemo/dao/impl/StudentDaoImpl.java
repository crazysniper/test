package com.androiddemo.dao.impl;

import com.androiddemo.dao.StudentDao;
import com.androiddemo.data_storage.sqlite.StudentInfoOpenHelper;
import com.androiddemo.entity.StudentInfoEntity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentDaoImpl implements StudentDao {
	private Context context;
	private StudentInfoOpenHelper helper;

	/**
	 * 在构造方法里面必须传递进来一个上下文对象
	 * 
	 * @param context
	 */
	public StudentDaoImpl(Context context) {
		this.context = context;
		// 构造方法实例化数据库打开的帮助类
		helper = new StudentInfoOpenHelper(context);
	}

	/* (non-Javadoc)
	 * @see com.androiddemo.dao.StudentDao#insert(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void insert(String name, String company, int salary) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(
				"insert into salaryinfo (name,company,salary) values (?,?,?)",
				new Object[] { name, company, salary });
		// 节约资源。关闭数据库
		db.close();
	}

	/* (non-Javadoc)
	 * @see com.androiddemo.dao.StudentDao#delete(int)
	 */
	@Override
	public void delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from salaryinfo where _id=?", new Object[] { id });
		db.close();
	}

	/* (non-Javadoc)
	 * @see com.androiddemo.dao.StudentDao#updateSalary(int, int)
	 */
	@Override
	public void updateSalary(int id, int newsalary) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("update salaryinfo set salary=? where _id=?", new Object[] {
				newsalary, id });
		db.close();
	}

	/* (non-Javadoc)
	 * @see com.androiddemo.dao.StudentDao#find(int)
	 */
	@Override
	public StudentInfoEntity find(int id) {
		// 获取到一个可读的数据库
		SQLiteDatabase db = helper.getReadableDatabase();
		// 结果集的游标。
		Cursor cursor = db.rawQuery("select * from salaryinfo where _id=?",
				new String[] { String.valueOf(id) });
		// 首先把游标移动到数据的位置。
		boolean result = cursor.moveToNext();
		StudentInfoEntity studentInfo = null;
		if (result) {// 查询到了具体的数据
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String company = cursor.getString(cursor.getColumnIndex("company"));
			int salary = cursor.getInt(cursor.getColumnIndex("salary"));
//			studentInfo = new StudentInfoEntity();
//			studentInfo.setCompany(company);
//			studentInfo.setName(name);
//			studentInfo.setSalary(salary);
			studentInfo.setId(id);
		}
		cursor.close();
		db.close();
		return studentInfo;
	}
}
