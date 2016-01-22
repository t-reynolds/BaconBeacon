package com.xanderfehsenfeld.baconbeacon;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by Xander on 1/21/16.
 */
public class MyServiceConnection implements ServiceConnection {



    @Override
    public void onServiceConnected(ComponentName name, IBinder _service) {
        System.out.println("service bound!");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        System.out.println("service unbound!");

    }
}
