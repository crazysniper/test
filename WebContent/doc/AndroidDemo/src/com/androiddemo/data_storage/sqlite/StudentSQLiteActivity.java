package com.androiddemo.data_storage.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.androiddemo.activity.R;

public class StudentSQLiteActivity extends Activity {
//	private StudentDao dao = new StudentDaoImpl();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_contentvalues_demo);
//		dao = new StudentDaoImpl(this);
	}

	/**
	 * 添加一条记录的按钮
	 * 
	 * @param view
	 */
	public void add(View view) {
//		dao.insert("张三", "xx科技公司", 1000);
	}

	/**
	 * 删除一条记录
	 * 
	 * @param view
	 */
	public void delete(View view) {
//		dao.delete(1);
	}

	/**
	 * 更新学生工资信息
	 * 
	 * @param view
	 */
	public void update(View view) {
//		dao.updateSalary(1, 9999);
	}

	/**
	 * 查询某个学生的信息
	 */
	public void query(View view) {
//		StudentInfoEntity info = dao.find(1);
//		System.out.println("学生的信息:" + info.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
}
