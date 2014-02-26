package com.androiddemo.application;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androiddemo.activity.R;

/**
 * 网络图片查看器
 * @author Gao
 *
 */
public class ImageOnlineActivity extends Activity {
	
	protected static final int SHOW_IMAGE =1;	//显示图片
	protected static final int SERVER_ERROR = 2;	// 服务器错误
	protected static final int URL_ERROR =3;	// url错误
	protected static final int NETWORK_ERROR = 4;	// 网络错误
	private EditText et_path;
	private ImageView iv_result;
	
	/**
	 * 创建消息处理器
	 */
	private Handler handler = new Handler(){
		// 子类对象通过该方法接收信息
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SHOW_IMAGE:
				Bitmap bitmap = (Bitmap) msg.obj;
				iv_result.setImageBitmap(bitmap);
				break;

			case SERVER_ERROR:
				Toast.makeText(getApplicationContext(), "服务器返回状态码错误", Toast.LENGTH_SHORT).show();
				break;
			case URL_ERROR:
				Toast.makeText(getApplicationContext(), "图片路径错误", Toast.LENGTH_SHORT).show();
				break;
			case NETWORK_ERROR:
				Toast.makeText(getApplicationContext(), "网络错误", Toast.LENGTH_SHORT).show();
				break;
			}
			
		};
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_imageonline_demo);
        //获取关心的控件
        et_path = (EditText) findViewById(R.id.et_path);
        iv_result = (ImageView) findViewById(R.id.iv_result);
    }

    public void toVisitImg(View view){
    	final String path = et_path.getText().toString().trim();
    	if(TextUtils.isEmpty(path)){
    		Toast.makeText(this, "请输入图片的路径", Toast.LENGTH_SHORT).show();
    	}else{
    		//定义一个URL 表示访问网络图片的路径
    		new Thread(){
    			public void run() {
    				try {
    					URL url = new URL(path);
    					//得到与服务器的连接对象
    					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    					//设置请求方式为Http请求的GET
    					conn.setRequestMethod("GET");
    					//指定连接超时时间
    					conn.setConnectTimeout(5000);
    					//得到服务器端返回的状态码
    					int code = conn.getResponseCode();
    					if(code == 200){//请求成功
    						InputStream is = conn.getInputStream();
    						Bitmap bitmap = BitmapFactory.decodeStream(is);
    						//设置图片内容的代码 修改ui操作 
    						//iv_result.setImageBitmap(bitmap);
    						Message msg = Message.obtain();
    						msg.what = SHOW_IMAGE;
    						msg.obj = bitmap;
    						handler.sendMessage(msg);
    					}else{
    						//Toast.makeText(MainActivity.this, "服务器返回状态码错误", 0).show();
    						Message msg = Message.obtain();
    						msg.what = SERVER_ERROR;
    						handler.sendMessage(msg);
    					}
    					
    				} catch (MalformedURLException e) {
    					e.printStackTrace();
    					//Toast.makeText(MainActivity.this, "图片路径错误。", 0).show();
    					Message msg = Message.obtain();
						msg.what = URL_ERROR;
						handler.sendMessage(msg);
    				} catch (IOException e) {
    					//Toast.makeText(MainActivity.this, "访问网络错误。", 0).show();
    					e.printStackTrace();
    					Message msg = Message.obtain();
						msg.what = NETWORK_ERROR;
						handler.sendMessage(msg);
    				}
    			};
    		}.start();
    	}
    }
}
