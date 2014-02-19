package com.androiddemo.component;

import android.app.Activity;
import android.os.Bundle;

/**
 * 对话框
 * http://blog.csdn.net/ameyume/article/details/6138488
 * @author gaofeng2
 * 
 */
public class AlertDialogActivity extends Activity {

	/**
	 * 一个对话框一般是一个出现在当前Activity之上的一个小窗口. 处于下面的Activity失去焦点, 对话框接受所有的用户交互.
	 * 对话框一般用于提示信息和与当前应用程序直接相关的小功能
	 */

	/**
	 * 　Android API 支持下列类型的对话框对象: 　　
	 * 警告对话框 AlertDialog: 一个可以有0到3个按钮,一个单选框或复选框的列表的对话框. 警告对话框可以创建大多数的交互界面, 是推荐的类型. 　　
	 * 进度对话框 ProgressDialog: 显示一个进度环或者一个进度条. 由于它是AlertDialog的扩展, 所以它也支持按钮. 　　
	 * 日期选择对话框 DatePickerDialog: 让用户选择一个日期. 　　时间选择对话框 TimePickerDialog: 让用户选择一个时间. 　　
	 * 如果你希望自定义你的对话框, 可以扩展Dialog类. 　　
	 * Showing a Dialog 显示对话框
	 */

	/**
	 * 要创建一个AlertDialog, 使用AlertDialog.Builder子类. 使用AlertDialog.Builder(Context)来得到一个Builder,
	 *  然后使用该类的公有方法来定义AlertDialog的属性. 设定好以后, 使用create()方法来获得AlertDialog对象.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
