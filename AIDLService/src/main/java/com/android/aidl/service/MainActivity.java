package com.android.aidl.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.aidl.client.IServiceAidlInterface;

public class MainActivity extends AppCompatActivity implements IShowDataInterface {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        new MyServiceAidl().setiShowDataInterface(this);
        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setAction("com.android.aidl.client.AIDLService");
        boolean b = bindService(intent, con, Context.BIND_AUTO_CREATE);
        if (b) {
            Log.d("service", "成功");
        } else {
            Log.d("service", "失败");
        }
    }

    private IServiceAidlInterface serviceManager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 10; k++) {
                        try {
                            serviceManager.setData("服务器第" + k + "次推送消息");
                            Log.d("service", "服务器第" + k + "次推送消息");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    };

    private ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceManager = IServiceAidlInterface.Stub.asInterface(service);
            if (null != serviceManager) handler.sendMessage(new Message());
            try {
                String s = serviceManager.getData();
                tv.setText(s);
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
        if (null != data && !"".equals(data)) {
            Log.d("service", data);
            bindService();
        }
    }
}
