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
	private String[] password = { "����1", "����2" };

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
		 * SimpleAdapter �ڶ����������б���ֵ
		 * �����ݲ�����item�Ļ��沼��id
		 * ���ĸ�������String[]���͵Ĳ������ò���������Щkey���ڵ�value�������б���
		 * �����������int[]���͵Ĳ������ò������������Щ���
		 */
		SimpleAdapter sa = new SimpleAdapter(this, listItem,
				R.layout.simpleadapteritem, new String[] { "name", "desc",
						"password" }, new int[] { R.id.name, R.id.desc,
						R.id.password });
		// ΪListView����adapter
		simpleadapterlist.setAdapter(sa);
	}
}
