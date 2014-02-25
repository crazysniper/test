package com.androiddemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BookEntity implements Parcelable {

	private String bookName;
	private String author;
	private int publishTime;

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int arg1) {
		parcel.writeString(bookName);
		parcel.writeString(author);
		parcel.writeInt(publishTime);
	}

	public static final Parcelable.Creator<BookEntity> CREATOR = new Creator<BookEntity>() {
		public BookEntity createFromParcel(Parcel source) {
			BookEntity mBook = new BookEntity();
			mBook.bookName = source.readString();
			mBook.author = source.readString();
			mBook.publishTime = source.readInt();
			return mBook;
		}

		public BookEntity[] newArray(int size) {
			return new BookEntity[size];
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
