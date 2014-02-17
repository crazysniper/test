package com.androiddemo.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.androiddemo.activity.R;

public class SimpleAdapteDemo extends Activity {

	private ListView simpleadapterlist;
	private String[] names = { "Gao", "Li" };
	private String[] desc = { "1111", "2222" };
	private String[] password = { "密码1", "密码2" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simpleadapter);
		initView();
	}

	public void initView() {
		simpleadapterlist = (ListView) findViewById(R.id.simpleadapterlist);
		List<Map<String, Object>> listItem = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		int length = names.length;
		for (int i = 0; i < length; i++) {
			map = new HashMap<String, Object>();
			map.put("name", names[i]);
			map.put("desc", desc[i]);
			map.put("password", password[i]);
			listItem.add(map);
		}
		/**
		 * SimpleAdapter 第二个参数是列表项值
		 * 第三份参数是item的画面布局id
		 * 第四个参数是String[]类型的参数，该参数决定哪些key对于的value来生成列表项
		 * 第五个参数是int[]类型的参数，该参数决定填充哪些组件
		 */
		SimpleAdapter sa = new SimpleAdapter(this, listItem,
				R.layout.simpleadapteritem, new String[] { "name", "desc",
						"password" }, new int[] { R.id.name, R.id.desc,
						R.id.password });
		// 为ListView设置adapter
		simpleadapterlist.setAdapter(sa);
	}
}
