package com.androiddemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BookEntity_Parcelable implements Parcelable {

	private String bookName;
	private String author;
	private int publishTime;

	@Override
	public int describeContents() {
		return 0;
	}

	// 写数据进行保存
	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(bookName);
		parcel.writeString(author);
		parcel.writeInt(publishTime);
	}

	// 用来创建自定义的Parcelable的对象
	public static final Parcelable.Creator<BookEntity_Parcelable> CREATOR = new Creator<BookEntity_Parcelable>() {
		public BookEntity_Parcelable createFromParcel(Parcel source) {
			BookEntity_Parcelable mBook = new BookEntity_Parcelable();
			mBook.bookName = source.readString();
			mBook.author = source.readString();
			mBook.publishTime = source.readInt();
			return mBook;
		}

		public BookEntity_Parcelable[] newArray(int size) {
			return new BookEntity_Parcelable[size];
		}
	};

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(int publishTime) {
		this.publishTime = publishTime;
	}

}
