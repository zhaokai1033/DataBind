package com.open.code.binding;

import android.app.Application;

/**
 * ========================================
 * Created by zhaokai on 2018/8/26.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Util.init(this);
    }
}
