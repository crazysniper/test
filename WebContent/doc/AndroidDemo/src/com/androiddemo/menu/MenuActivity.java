package com.androiddemo.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.androiddemo.activity.MainActivity;
import com.androiddemo.activity.R;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_demo);
	}

	/**
	 * OptionMenu，选项菜单，必须设备具有菜单按钮才可以触发。因为屏幕的限制，最多只能展示六个菜单项，
	 * 如果定义的菜单项超出了六个，其他的菜单项将被隐藏，第六个菜单将会显示“更多”，点击展开更多的菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 直接Add菜单选项到Menu中
		menu.add(1000, 100, 0, "System menu");
		// 获取添加的菜单选项，然后设置其图标
		MenuItem menuItem2 = menu.add(1000, 101, 1, "User menu");
		menuItem2.setIcon(R.drawable.ic_launcher);
		// 获取添加的菜单选项，增加一个Intent，点击后转向MainActivity
		MenuItem menuItem3 = menu.add(1000, 102, 2, "Intent menu");
		menuItem3.setIcon(R.drawable.ic_launcher);
		Intent intent = new Intent(this, MainActivity.class);
		menuItem3.setIntent(intent);

		// 添加一个SubMenu，点击后弹出一个子菜单对话框
		SubMenu submenu = menu.addSubMenu(1000, 103, 3, "Sub menus");
		submenu.add(1000, 104, 4, "Sub ment1");
		submenu.add(1000, 105, 4, "Sub ment2");
		submenu.add(1000, 106, 4, "Sub ment3");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean flag = false;
		switch (item.getItemId()) {
		case 100:
			Toast.makeText(this, "selected System menu", Toast.LENGTH_SHORT).show();
			flag = true;
			break;
		case 101:
			Toast.makeText(this, "selected User menu", Toast.LENGTH_SHORT).show();
			flag = true;
			break;
		case 104:
			Toast.makeText(this, "selected Sub menus", Toast.LENGTH_SHORT).show();
			flag = true;
			break;
		default:
			flag = super.onOptionsItemSelected(item);
			break;
		}
		return flag;
	}
}
