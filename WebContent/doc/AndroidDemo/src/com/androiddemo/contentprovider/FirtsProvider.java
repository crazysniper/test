package com.androiddemo.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class FirtsProvider extends ContentProvider {

	/**
	 * �÷�����ContentProvider������ᱻ���á�
	 * ������application��һ�η���ContentProviderʱ����ContentProvider�ᱻ��������
	 * ���������ø�onCreate()����
	 */
	@Override
	public boolean onCreate() {
		return false;
	}

	/**
	 * ����Uri��ѯ��select������ƥ���ȫ����¼������projection��һ�������б�����ֻ��ѡ���ָ����������
	 * ���ز�ѯ�õ���Cursor
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		return null;
	}

	/**
	 * ���ظ�ContentProvider���ṩ���ݵ�MIME����
	 */
	@Override
	public String getType(Uri uri) {
		return null;
	}
	
	/**
	 * ���ݸ�Uri����values��Ӧ������
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	/**
	 * ����Uriɾ��select������ƥ���ȫ����¼
	 * ���ر�ɾ���ļ�¼����
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	/**
	 * ����Uri�޸�select������ƥ���ȫ����¼
	 * ���ظ��µļ�¼����
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		return 0;
	}
}
