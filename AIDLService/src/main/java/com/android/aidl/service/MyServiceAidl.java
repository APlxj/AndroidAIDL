package com.android.aidl.service;

import android.os.Parcel;
import android.os.RemoteException;

import com.android.aidl.client.Book;
import com.android.aidl.client.IServiceAidlInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MyServiceAidl extends IServiceAidlInterface.Stub {

    @Override
    public void setData(String data) throws RemoteException {
        if (null != iShowDataInterface) {
            iShowDataInterface.showData(data);
        }
    }

    @Override
    public void setBook(Book b) throws RemoteException {

    }

    @Override
    public String getData() throws RemoteException {
        return "这个是服务端的返回值";
    }

    @Override
    public List getListData() throws RemoteException {
        List<String> strings = new ArrayList<>();
        strings.add("service:数据1");
        strings.add("service:数据2");
        strings.add("service:数据3");
        strings.add("service:数据4");
        return strings;
    }

    @Override
    public Book getBook() throws RemoteException {
        Book book = new Book(/*"西游记","3本","吴承恩","神魔小说","1870","50.00"*/);
        book.setName("西游记");
        book.setNum("3本");
        book.setAuthor("吴承恩");
        book.setCls("神魔小说");
        book.setWritYear("1870");
        book.setPrice("50.00");
        return book;
    }

    @Override
    public List<Book> getBooks() throws RemoteException {
        return null;
    }

    private static IShowDataInterface iShowDataInterface;

    public void setiShowDataInterface(IShowDataInterface iShowDataInterface) {
        this.iShowDataInterface = iShowDataInterface;
    }
}
