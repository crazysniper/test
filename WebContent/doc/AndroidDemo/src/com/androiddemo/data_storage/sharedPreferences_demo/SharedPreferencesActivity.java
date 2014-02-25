package com.androiddemo.data_storage.sharedPreferences_demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androiddemo.activity.R;

/**
 * SharedPreferences
 * 应用程序在运行的时候，可能会随着用户的使用而保持该用户的配置信息，如上次播放时的eq设置，音量设置，上网的cookies信息等等，
 * 这些小量 的信息可以通过SharedPreferences来保持，通过SharedPreferences保持的数据为一个XML文件，位于应用程序的私有文件夹。
 * 
 * 
 * 
 * 1.创建一个SharedPreferences 
 * 2.初始化SharedPreferences 参数1 sp的文件名称 参数2 sp的保存模式
 * 3.向sp里面保存数据 首先 获取一个文本编辑器 Editor 
 * 4.存储完毕数据记得执行commint（）保存数据 
 * 5.读取数据  sp.getString() sp.getInt();
 */
public class SharedPreferencesActivity extends Activity {

	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences_demo);

		// SharedPreferences本身是一个接口，程序无法直接创建SharedPreferences实例，
		// 只能通过Context提供的getSharedPreferences(String name,int mode)方法来获取SharedPreferences实例
		// Contex.MODE_PRIVATE:指定该SharedPreferences数据只能被本应用程序读、写
		// 第一个参数是保存的文件名，数据保存在/data/data/包名/shared_prefs目录下
		// 总是以xml格式保存
		sharedPreferences = getSharedPreferences("androiddemo", Context.MODE_PRIVATE);
		editor = sharedPreferences.edit();
	}

	public void initView(){
		et=(EditText)findViewById(R.id.et_sharedPreferences);
	}
	
	public void read_SharedPreferences(View view) {
		// 默认为null,如果取不到，则返回null
		String time = sharedPreferences.getString("time", null);
		// 默认为0,如果取不到，则返回0
		int randNum = sharedPreferences.getInt("random", 0);
		String result = time == null ? "暂时没有写入数据" : "写入时间为:" + time + "\n 上次生成的随机数是:" + randNum;
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

	}

	public void write_SharedPreferences(View view) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日   hh:mm:ss");
		// 存入当前时间
		editor.putString("time", sdf.format(new Date()));
//		// 存入一个随机数
//		editor.putInt("random", (int) (Math.random() * 100));
//		editor.putString("random", arg1)
		// 提交所有存入的数据
		editor.commit();
	}
}
