package com.open.code.binding;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.InverseBindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * ========================================
 * Created by zhaokai on 2018/8/26.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public class Adapter {

    //DataBindingComponent
    @BindingAdapter(value = {"com:url"}, requireAll = false)
    public static void loadImage(ImageView view, String url) {
        Util.log("url:"+url);
        if (TextUtils.isEmpty(url)) return;
        Glide.with(view.getContext()).load(url).into(view);
    }

    //转化器，当xml 设置的属性不适合 则调用
    //Converters
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static String getTextString(TextView view) {
        Util.log(view.getText().toString());
        return view.getText().toString();
    }
}
