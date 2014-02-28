package com.androiddemo.component;

import android.app.Activity;

/**
 * http://www.cnblogs.com/plokmju/p/android_dialog.html
 * @author gaofeng2
 *
 */
public class Dialog extends Activity {

	/**
	 * 有4种常用的对话框
	 * AlertDialog： 警告对话框，使用最广泛功能最丰富的一个对话框。
	 * ProgressDialog：进度条对话框，只是对进度进行简单的封装。
	 * DatePickerDialog：日期对话框
	 * TimePickerDialog：时间对话框
	 */
	
	/**
	 * AlertDialog继承自Dialog类，对于Android内置的AlertDialog，它可以包含一个标题、一个内容消息或者一个选择列表、最多三个按钮。
	 * 而创建AlertDialog推荐使用它的一个内部类AlertDialog.Builder创建。
	 * 使用Builder对象，可以设置AlertDialog的各种属性，最后通过Builder.create()就可以得到AlertDialog对象，
	 * 如果只是还需要显示这个AlertDialog，一般可以直接使用Builder.show()方法，它会返回一个AlertDialog对象，并且显示它。
	 * 如果仅仅是需要提示一段信息给用户，那么就可以直接使用AlertDialog的一些属性设置提示信息，涉及到的方法有：
	 * 
	 * AlertDialog create()：根据设置的属性，创建一个AlertDialog。
	 * AlertDialog show()：根据设置的属性，创建一个AlertDialog，并且显示在屏幕上。
	 * AlertDialog.Builder setTitle()：设置标题。
	 * AlertDialog.Builder setIcon()：设置标题的图标。
	 * AlertDialog.Builder setMessage()：设置标题的内容。
	 * AlertDialog.Builder setCancelable()：设置是否模态，一般设置为false，表示模态，要求用户必须采取行动才能继续进行剩下的操作。
	 * Tips：AlertDialog.Builder的很多设置属性的方法，返回的均是这个AlertDialog.Builder对象，所以可以使用链式方式编写代码，这样更方便。
	 * 当一个对话框调用了show()方法后，展示到屏幕上，如果需要消除它，可以使用DialogInterface接口声明的两个方法，cancel()和dismiss()使对话框取消或者消除，这两个方法的作用是一样的，
	 * 不过推荐使用dismiss()。Dialog和AlertDialog都实现了DialogInterface接口，所以只要是对话框，均可以使用这两个方法来消除对话框
	 */
	

	/**
	 * AlertDialog内置了三个按钮，可以直接使用setXxxButton()方法进行设置，对于一般的对话框，使用三个按钮基本上也够用了，下面是这三个方法的签名：
	 * AlertDialog.Builder setPositiveButton(CharSquence text , DialogInterFace.OnClickListener)：一个积极的按钮，一般用于“OK”或者“继续”等操作。
	 * AlertDialog.Builder setNegativeButton(CharSquence text , DialogInterFace.OnClickListener)：一个负面的按钮，一般用于“取消”操作。
	 * AlertDialog.Builder setNeutralButton(CharSquence text , DialogInterFace.OnClickListener)：一个比较中性的按钮，一般用于“忽略”、“以后提醒我”等操作。
	 * 上面介绍的DialogInterface接口，还提供了一系列的事件响应，这三个按钮均需要传递一个DialogInterFace.OnClickListener接口对象，实现其点击事件的触发，
	 * 在这个接口中需要实现一个onClick(DialogInterface dialog,int which)，dialog为当前触发事件的对话框对象接口，可以直接强制转换为AlertDialog进行操作；which为点击按钮的标识符，
	 * 是一个整形的数据，对于这三个按钮而言，每个按钮使用不同的int类型数据进行标识：Positive（-1）、Negative(-2)、Neutral(-3)。
	 * 而除了专门为按钮点击实现的DialogInterFace.OnClickListener事件外，DialogInterface还提供了一些其他的事件，供Dialog对象响应，这些事件只是对Dialog声明周期各个状态的响应，
	 * 一看就明白了，就不再详细讲解了，下面是这几个事件的说明：
	 * interface DialogInterface.OnCancelListener：当对话框调用cancel()方法的时候触发。
	 * interface DialogInterface.OnDismissListener：当对话框调用dismiss()方法的时候触发。
	 * interface DialogInterface.OnShowListener：当对话框调用show()方法的时候触发。
	 * interface DialogInterface.OnMultiChoiceListener：当对话框使用多选列表，并且选中的时候触发。
	 */
	
	
	/**
	 * AlertDialog除了展示一些提示信息，还可以展示一种列表的形式，
	 * 需要使用到Builder.setItems(CharSequence[] items,DialogInterface.OnClickListener listener)方法进行设置，
	 * 它需要传递一个CharSequenece类型的数组，以绑定列表的数据，它同样需要传递一个DialogInterface.OnClickListener接口，
	 * 以响应列表项的点击，而这个接口中onClick方法的which参数，为当前点击触发项的items中的下标。
	 */
	
	
	/**
	 * AlertDialog还可以使用一种单选的列表样式，
	 * 使用Builder.setSingleChoiceItems(CharSequenece[] items,int checkedItem,DialogInterface.OnClickListener listener)，
	 * 这个方法具有多项重载，主要是为了应对不同的数据源，items为列表项数组，checkedItem为初始选项，listener为点击响应事件。
	 * 有时候并不一定需要选中之后就关闭对话框，可以设置两个按钮，用于确定选择。
	 */
	
	
	/**
	 * AlertDialog除了单选列表，还有多选的列表。
	 * 可以使用Builder.setMultiChoiceItems(CharSequence[] items,boolean[] checkedItems,DialogInterface.OnMultiChoiceClickListener listener)，
	 * 这个方法也同样具有多样重载，对于这个方法，items以一个数组为数据源；checkedItems是默认的选项，因为是多选列表，所以如果设置需要全部设置，如果没有默认选中，
	 * 则传Null；listener为多选项点击触发事件。
	 */

}
