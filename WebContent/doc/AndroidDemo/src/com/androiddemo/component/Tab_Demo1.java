package com.androiddemo.component;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.androiddemo.activity.R;

public class Tab_Demo1 extends TabActivity {
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_demo1);
		// 获取该Activity里面的TabHost组件
		@SuppressWarnings("deprecation")
		TabHost tabHost = getTabHost();
		// 创建第一个Tab页
		TabSpec tab1 = tabHost.newTabSpec("tab1")	// 创建选项卡
				.setIndicator("已接电话") // 设置标题
				.setContent(R.id.tab01); // 设置内容
		// 添加第一个标签页
		tabHost.addTab(tab1);
		
		TabSpec tab2 = tabHost.newTabSpec("tab2")
				// 在标签标题上放置图标
				.setIndicator("呼出电话",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02);
		// 添加第二个标签页
		tabHost.addTab(tab2);
		
		TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("未接电话")
				.setContent(R.id.tab03);
		// 添加第三个标签页
		tabHost.addTab(tab3);
		
		TabSpec tab4 = tabHost.newTabSpec("tab4")
				.setIndicator("跳转到其他activity")
				.setContent(new Intent(this,ComponentActivity.class));
		tabHost.addTab(tab4);
	}
}