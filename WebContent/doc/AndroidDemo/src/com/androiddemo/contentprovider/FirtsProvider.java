package com.androiddemo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class FirtsProvider extends ContentProvider {

	/**
	 * 该方法在ContentProvider创建后会被调用。
	 * 当其他application第一次访问ContentProvider时，该ContentProvider会被创建出来
	 * 并立即调用该onCreate()方法
	 */
	@Override
	public boolean onCreate() {
		return false;
	}

	/**
	 * 根据Uri查询出select条件所匹配的全部记录，其中projection是一个列名列表，表明只会选择出指定的数据列
	 * 返回查询得到的Cursor
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return null;
	}

	/**
	 * 返回该ContentProvider所提供数据的MIME类型
	 */
	@Override
	public String getType(Uri uri) {
		return null;
	}
	
	/**
	 * 根据该Uri插入values对应的数据
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	/**
	 * 根据Uri删除select条件所匹配的全部记录
	 * 返回被删除的记录条数
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	/**
	 * 根据Uri修改select条件所匹配的全部记录
	 * 返回更新的记录条数
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}
}
