package com.android.aidl.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowDataInterface {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyServiceAidl().setiShowDataInterface(this);
        tv = (TextView) findViewById(R.id.tv);
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setAction("com.android.aidl.service.AIDLService");
        boolean b = bindService(intent, con, Context.BIND_AUTO_CREATE);
        if (b) {
            Log.d("client", "成功");
        } else {
            Log.d("client", "失败");
        }
    }

    private ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IServiceAidlInterface serviceManager = IServiceAidlInterface.Stub.asInterface(service);
            try {
                /*String s = serviceManager.getData();
                List<String> strings = serviceManager.getListData();
                StringBuffer buffer = new StringBuffer();
                buffer.append(s).append("==>>");
                for (String str : strings) {
                    buffer.append(str);
                }
                tv.setText(buffer);*/
                Book book = serviceManager.getBook();
                String str = book.toString();
                tv.setText(str);

                serviceManager.setData("客户端获取数据成功");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void showData(String data) {
        Log.d("client", "客户端接收："+data);
    }
}
