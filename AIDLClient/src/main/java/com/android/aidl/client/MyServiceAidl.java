package com.android.aidl.client;

import android.os.RemoteException;

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
        return "这个是client的返回值";
    }

    @Override
    public List getListData() throws RemoteException {
        return null;
    }

    @Override
    public Book getBook() throws RemoteException {
        return null;
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
