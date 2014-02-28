package com.androiddemo.application;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.androiddemo.activity.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Get方式获取天气预报
 * @author Gao
 *
 */
public class Weather_Get_Demo extends Activity {

	protected static final int SUCCESS = 1;
	protected static final int ERROR = 2;
	private EditText et_cityname;
	private TextView tv_info;
	private String basePath = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx/getWeatherbyCityName?theCityName=";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.application_weather_demo);
        et_cityname = (EditText) findViewById(R.id.et_cityname);
        tv_info = (TextView) findViewById(R.id.tv_info);
	}

	/**
	 * 查询按钮的点击事件
	 * 
	 * @param view
	 */
	public void toGetWeather(View view) {
		String cityname = et_cityname.getText().toString().trim();
		if (TextUtils.isEmpty(cityname)) {
			Toast.makeText(this, "城市名称不能为空", Toast.LENGTH_SHORT).show();
		} else {
			// 北京
			final String path = basePath + URLEncoder.encode(cityname);
			new Thread() {
				public void run() {
					try {
						URL url = new URL(path);
						// 得到与服务器的连接对象
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						// 设置请求方式为Http请求的GET
						conn.setRequestMethod("GET");
						// 指定连接超时时间
						conn.setConnectTimeout(5000);
						// 得到服务器端返回的状态码
						int code = conn.getResponseCode();
						if (code == 200) {
							InputStream is = conn.getInputStream();
							// 创建xml文件的解析器
							XmlPullParser parser = Xml.newPullParser();
							// 初始化xml解析器
							parser.setInput(is, "UTF-8");
							int type = parser.getEventType();
							// 集合存放的是所有的天气信息
							List<String> infos = new ArrayList<String>();
							while (type != XmlPullParser.END_DOCUMENT) {
								if (type == XmlPullParser.START_TAG) {
									if ("string".equals(parser.getName())) {
										String str = parser.nextText();
										infos.add(str);
									}
								}
								type = parser.next();// 只要没有解析到文档的末尾就不停的向下解析
							}
							Message msg = Message.obtain();
							msg.what = SUCCESS;
							msg.obj = infos;
							handler.sendMessage(msg);
						}
					} catch (Exception e) {
						e.printStackTrace();
						Message msg = Message.obtain();
						msg.what = ERROR;
						handler.sendMessage(msg);
					}
				};
			}.start();
		}
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case SUCCESS:
				List<String> infos = (List<String>) msg.obj;
				tv_info.setText("城市名称：" + infos.get(1) + "\n" + "城市温度："
						+ infos.get(5) + "\n" + "天气状况：" + infos.get(6) + "\n"
						+ "穿衣指数：" + infos.get(11) + "\n");
				break;
			case ERROR:
				Toast.makeText(getApplicationContext(), "获取天气信息失败", 0).show();
				break;
			}
		};
	};
}
