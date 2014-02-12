package com.example.helloworld;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabDemo extends TabActivity {

	private TabHost tab;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabdemo);
		tab=getTabHost();
		
		tab.addTab(tab.newTabSpec("home")
				.setIndicator("主页", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.img));
		
		tab.addTab(tab.newTabSpec("home")
				.setIndicator("时间", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.time));
		tab.addTab(tab.newTabSpec("home")
				.setIndicator("联系人", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.personlist));
		tab.addTab(tab.newTabSpec("home")
				.setIndicator("搜索", getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.search));
		
		tab.setCurrentTab(1);
	}
}
