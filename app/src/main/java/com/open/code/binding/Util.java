package com.open.code.binding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * ========================================
 * Created by zhaokai on 2018/8/26.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

class Util {

    private static Util util = new Util();

    private static WeakReference<Context> contextWeakReference;

    static void init(DemoApplication application) {
        contextWeakReference = new WeakReference<Context>(application);
    }

    private static Util getInstance() {
        return util;
    }

    private Toast toast;

    public static void showMsg(String msg) {
        getInstance().showMsgImpl(msg);
    }

    @SuppressLint("ShowToast")
    private void showMsgImpl(String msg) {

        if (toast == null) {
            toast = Toast.makeText(contextWeakReference.get(), "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void log(String s) {
        Log.d("binder", s);
    }

    public static void hideSoftKeBoard() {
        InputMethodManager imm = (InputMethodManager) contextWeakReference.get().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        if (imm.isActive()&&imm.isAcceptingText()) {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
