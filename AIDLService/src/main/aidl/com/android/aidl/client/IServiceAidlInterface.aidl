// IServiceAidlInterface.aidl
package com.android.aidl.client;
import com.android.aidl.client.Book;

// Declare any non-default types here with import statements

interface IServiceAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */

    void setData(String data);
    void setBook(in Book b);
    /*void setListData( List<Strign> strs);*/



    String getData();
    List<String> getListData();
    Book getBook();
    List<Book> getBooks();
}
