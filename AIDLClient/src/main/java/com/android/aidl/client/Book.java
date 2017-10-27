package com.android.aidl.client;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 类描述：书的实体类
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class Book implements Parcelable {

    //书名
    private String name;
    //类别
    private String cls;
    //作者
    private String author;
    //价格
    private String price;
    //数量
    private String num;
    //创作年代
    private String writYear;

    protected Book(Parcel in) {
        name = in.readString();
        cls = in.readString();
        author = in.readString();
        price = in.readString();
        num = in.readString();
        writYear = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWritYear() {
        return writYear;
    }

    public void setWritYear(String writYear) {
        this.writYear = writYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", cls='" + cls + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", num='" + num + '\'' +
                ", writYear='" + writYear + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cls);
        dest.writeString(author);
        dest.writeString(price);
        dest.writeString(num);
        dest.writeString(writYear);
    }
}
