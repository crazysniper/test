package com.androiddemo.component;

import com.androiddemo.activity.R;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

/**
 * 继承于TabActivity,其实，TabActivity是Activity的子类
 * @author gaofeng2
 *
 */
@SuppressWarnings("deprecation")
public class Tab_Demo extends TabActivity {

	private TabHost tabhost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_demo);
		initView();
	}

	public void initView() {
		tabhost = getTabHost();  // //从TabActivity上面获取放置Tab的TabHost
		tabhost.addTab(tabhost
				.newTabSpec("home")  // 制造一个新的标签TT
				.setIndicator("主页",   // 设置一下显示的标题为主页
						getResources().getDrawable(R.drawable.ic_launcher))  // 设置一下标签图标为ic_launcher
				.setContent(R.id.img));   //设置一下该标签页的布局内容为R.id.widget_layout_red，这是FrameLayout中的一个子Layout

		tabhost.addTab(tabhost
				.newTabSpec("home")
				.setIndicator("时间",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.time));
		tabhost.addTab(tabhost
				.newTabSpec("home")
				.setIndicator("联系人",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.personlist));
		tabhost.addTab(tabhost
				.newTabSpec("home")
				.setIndicator("搜索",
						getResources().getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.search));

		tabhost.setCurrentTab(1);		// 默认显示第二个标签，从0开始
		
		tabhost.setOnTabChangedListener(new OnTabChangeListener(){

			@Override
			public void onTabChanged(String tabId) {
			}
		});
	}
	
}
