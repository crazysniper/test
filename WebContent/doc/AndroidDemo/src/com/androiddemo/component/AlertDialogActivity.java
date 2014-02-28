package com.androiddemo.component;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.androiddemo.activity.R;

/**
 * 对话框 http://blog.csdn.net/ameyume/article/details/6138488
 * 
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
	 * 警告对话框 AlertDialog:  一个可以有0到3个按钮,一个单选框或复选框的列表的对话框. 警告对话框可以创建大多数的交互界面, 是推荐的类型. 　　 
	 * 进度对话框ProgressDialog: 显示一个进度环或者一个进度条. 由于它是AlertDialog的扩展, 所以它也支持按钮. 　　
	 * 日期选择对话框  DatePickerDialog: 让用户选择一个日期. 　　
	 * 时间选择对话框 TimePickerDialog: 让用户选择一个时间. 　　
	 * 如果你希望自定义你的对话框, 可以扩展Dialog类. 　　 Showing a Dialog 显示对话框
	 */

	/**
	 * 要创建一个AlertDialog, 使用AlertDialog.Builder子类.
	 * 使用AlertDialog.Builder(Context)来得到一个Builder, 然后使用该类的公有方法来定义AlertDialog的属性.
	 * 设定好以后, 使用create()方法来获得AlertDialog对象.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_list);
	}

	// 创建普通的对话框
	public void btnGeneral(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");							// 设置标题
		builder.setMessage("这是一个普通的对话框");			// 设置提示消息
		builder.setIcon(R.drawable.ic_launcher);
		builder.setCancelable(false);
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int arg1) {
				dialog.cancel();
			}
		});
		builder.create().show();
	}

	// 创建多按钮普通的对话框
	public void btnButtons1(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("这是一个多按钮普通的对话框");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setPositiveButton("确定", new OnClickListener() {	// 设置确定的按键
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(AlertDialogActivity.this, "确定被点击", Toast.LENGTH_SHORT).show(); // 此处的makeText中第一个参数不可以直接写成this，而要写成类名.this
				dialog.dismiss(); // dismiss()方法是线程安全的
			}

		});
		builder.setNegativeButton("否定", new OnClickListener() {	// 设置取消按键
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(AlertDialogActivity.this, "否定被点击", Toast.LENGTH_SHORT).show(); // 此处的makeText中第一个参数不可以直接写成this，而要写成类名.this
				dialog.dismiss();
			}

		});
		builder.setNeutralButton("忽略", new OnClickListener() {		// 中立的，什么也不错
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(AlertDialogActivity.this, "忽略被点击", Toast.LENGTH_SHORT).show(); // 此处的makeText中第一个参数不可以直接写成this，而要写成类名.this
				dialog.cancel();
			}
		});
		builder.setCancelable(false);			// 设置按返回键是否响应返回，这是是不响应
		builder.show();
	}

	// 创建多按钮普通的对话框
	public void btnButtons2(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("简化代码");
		builder.setIcon(R.drawable.ic_launcher);
		builder.setPositiveButton("确定", dialog);
		builder.setNegativeButton("取消", dialog);
		builder.setNeutralButton("忽略", dialog);
	}
	
	/**
	 * 为了代码的简化，我们不再为每一个Button创建DialogInterface.OnClickListener()对象，
	 * 而是只创建一个DialogInterface.OnClickListener()对象来分别实现它们的点击事件。具体实现代码如下：
	 */
	DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			if(which == DialogInterface.BUTTON_POSITIVE){												// 确定按键的点击事件
				Toast.makeText(AlertDialogActivity.this, "确定被点击", Toast.LENGTH_SHORT).show();
			}
			if(which == DialogInterface.BUTTON_NEGATIVE){												// 取消按键的点击事件
				Toast.makeText(AlertDialogActivity.this, "否定被点击", Toast.LENGTH_SHORT).show();
			}
			if(which == DialogInterface.BUTTON_NEUTRAL){												// 忽略按键的点击事件
				Toast.makeText(AlertDialogActivity.this, "忽略被点击", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	
	// 创建列表形式的对话框
	public void btnListView(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请选择城市");
		final String[] items = { "北京", "上海", "南京" };			// 列表中显示的内容组成的数组
		builder.setItems(items, new OnClickListener() {				
			// 响应每一条的点击事件其中第一个参数是列表显示中的每一个条目的名称的数组，第二个是点击一个列表显示条目时的响应事件
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String select_item = items[which].toString();
				Toast.makeText(AlertDialogActivity.this, "选择的是" + select_item, Toast.LENGTH_SHORT).show();
			}
		});
		builder.show();
	}

	// 创建单选列表的对话框
	public void btnListViewSingle(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请选择一个城市");
		final String[] items = { "北京", "上海", "南京" };			// 列表中显示的内容组成的数组
		builder.setSingleChoiceItems(items, 1, new OnClickListener() { // 默认选择的是数组中下标是1的值
					@Override
					public void onClick(DialogInterface dialog, int which) {	
						String select_item = items[which].toString();
						Toast.makeText(AlertDialogActivity.this, "选择的是" + select_item, Toast.LENGTH_SHORT).show();
					}
				});
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}

	// 创建多选列表的对话框
	public void btnListViewMulti(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请选择多个城市");
		final String[] items = { "北京", "上海", "南京" };	// 列表中的值
		boolean[] checkedItems = { false, false, true };	// 默认选择哪个
		builder.setMultiChoiceItems(items, checkedItems,
				new OnMultiChoiceClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						String select_item = items[which].toString();
						Toast.makeText(AlertDialogActivity.this, "选择的是" + select_item, Toast.LENGTH_SHORT).show();
					}
				});
		builder.setPositiveButton("确定", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}
	
	// 滚动等待对话框
	/**
	 * 有些时候，只是需要提示用户等待，比如在执行耗时操作等的时候，可以使用进度对话框来显示一个进度信息，提示用户等待，
	 * 这个时候可以使用ProgressDialog。ProgressDialog的使用方式大部分可以参见ProgressBar，
	 * 其实就是一个封装了ProgressBar的对话框。
	 * @param v
	 */
	public void btnProgressDialog(View v){
		// 第一种方法，使用ProgressDialog构造函数
		final ProgressDialog progressDialog = new ProgressDialog(this);
		progressDialog.setIcon(R.drawable.ic_launcher);
		progressDialog.setTitle("等待");
		progressDialog.setMessage("正在加载...");
		progressDialog.show();
		// 第二张方法
//		progressDialog = ProgressDialog.show(this, "等待", "正在加载...", false, false);
		new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					Toast.makeText(AlertDialogActivity.this, "正在加载", Toast.LENGTH_SHORT).show();
				} finally {
					progressDialog.dismiss();
				}
			}
			
		}).start();
	}
	
	// 进度条对话框
	public void btnProgressDialogH(View v){
		
	}

	// 自定义Dialog
	public void btnCustomDialog(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.dialog_signin, null);
		Button btn = (Button)findViewById(R.id.btnCustom);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(AlertDialogActivity.this, "选择的是" , Toast.LENGTH_SHORT).show();
			}
		});
		builder.setView(view);
		builder.show();
	}

}
