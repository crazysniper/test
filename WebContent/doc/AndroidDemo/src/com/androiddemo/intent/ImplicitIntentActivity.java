package com.androiddemo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androiddemo.activity.R;

/**
 * 隐式Intent
 * 显式Intent直接用组件的名称定义目标组件，这种方式很直接。显式Intent更多用于在应用程序内部传递消息
 * 隐式Intent恰恰相反，它不会用组件名称定义需要激活的目标组件，它更广泛地用于在不同应用程序之间传递消息。
 * <category android:name="android.intent.category.DEFAULT"/>    <!--此句一般都要加 --> 
 * @author gaofeng2
 *
 */
public class ImplicitIntentActivity extends Activity {

	/**
	 * 对于显示Intent，Android不需要再去做解析，因为目标组件很明确。
	 * Android需要解析的是隐式Intent，通过解析，将Intent映射给可以处理该Intent的Activity，Service等。
	 * Intent的解析机制主要是通过查找已经注册在AndroidManifest.xml中的所有IntentFilter以及其中定义的Intent，最终找到匹配的Intent
	 * 
	 * 
	 * Intent定义：Intent是一种在不同组件之间传递的请求消息，是应用程序发出的请求和意图。作为一个完整的消息传递机制，Intent不仅需要发送端，还需要接收端。
	 * 显式Intent定义：对于明确指出了目标组件名称的Intent，我们称之为显式Intent。 
	 * 隐式Intent定义：对于没有明确指出目标组件名称的Intent，则称之为隐式Intent。 
	 * 说明：Android系统使用IntentFilter 来寻找与隐式Intent相关的对象。
	 * 
	 * 详细解释：
	 * 显式Intent直接用组件的名称定义目标组件，这种方式很直接。但是由于开发人员往往并不清楚别的应用程序的组件名称，因此，
	 * 显式Intent更多用于在应用程序内部传递消息。比如在某应用程序内，一个Activity启动一个Service。
	 * 隐式Intent恰恰相反，它不会用组件名称定义需要激活的目标组件，它更广泛地用于在不同应用程序之间传递消息。
	 * 在显式Intent消息中，决定目标组件的唯一要素就是组件名称，因此，如果你的Intent中已经明确定义了目标组件的名称，那么你就完全不用再定义其他Intent内容。
	 * 而对于隐式Intent则不同，由于没有明确的目标组件名称，所以必须由Android系统帮助应用程序寻找与Intent请求意图最匹配的组件。
	 * 
	 * 
	 * Android系统寻找与Intent请求意图最匹配的组件具体的选择方法 是：Android将Intent的请求内容和一个叫做IntentFilter的过滤器比较，IntentFilter中包含系统中所有可能的待选组件。
	 * 如果IntentFilter中某一组件匹配隐式Intent请求的内容，那么Android就选择该组件作为该隐式Intent的目标组件。
	 * 
	 * Android如何知道应用程序能够处理某种类型的Intent请求呢？这需要应用程序在Android-Manifest.xml中声明自己所含组件的过滤器（即可以匹配哪些Intent请求）。
	 * 一个没有声明Intent-Filter的组件只能响应指明自己名字的显式Intent请求，而无法响应隐式Intent请求。
	 * 而一个声明了IntentFilter的组件既可以响应显式Intent请求，也可以响应隐式Intent请求。在通过和 IntentFilter比较来解析隐式Intent请求时，Android将以下三个因素作为选择的参考标准
	 * Action Data Category 而Extra和Flag在解析收到Intent时是并不起作用的。
	 * 
	 * intent到底发给哪个activity，需要进行三个匹配，一个是action，一个是category，一个是data。
	 * 理论上来说，如果intent不指定category，那么无论intent filter的内容是什么都应该是匹配的。但是，如果是implicit intent，android默认给加上一个CATEGORY_DEFAULT，
	 * 这样的话如果intent filter中没有android.intent.category.DEFAULT这个category的话，匹配测试就会失败。
	 * 所以，如果你的 activity支持接收implicit intent的话就一定要在intent filter中加入android.intent.category.DEFAULT。
	 * 例外情况是：android.intent.category.MAIN和android.intent.category.LAUNCHER的filter中没有必要加入android.intent.category.DEFAULT，当然加入也没有问题。
	 * 我们定义的activity如果接受implicit intent的话，intent filer就一定要加上android.intent.category.DEFAULT这个category。
	 *  我的问题就是出现在这里。忘记在intent-filter中加上了<category android:name="android.intent.category.DEFAULT" />了这个。
	 */
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.implicit_intent);
	}
	
	public void toImplicitIntent(View v){
		startActivity(new Intent(this,IntentActivity.class));
	}
}
