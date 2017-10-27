package com.android.aidl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class AIDLService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyServiceAidl();
    }
}
