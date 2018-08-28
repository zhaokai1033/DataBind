package com.open.code.binding;

import android.databinding.ObservableField;
import android.databinding.adapters.TextViewBindingAdapter;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.widget.CompoundButton;

/**
 * ========================================
 * Created by zhaokai on 2018/8/26.
 * Email zhaokai1033@126.com
 * des:
 * ========================================
 */

public class ModelLogin implements LoginActivity.loginFace {

    public static final int NONE = 0;
    public static final int PHONE = 1;
    public static final int USER = 2;

    public String phone = "";

    public String code = "";

    public String user = "";

    public String btName = "登录";

    //是否满足登录条件
    public ObservableField<Boolean> isMatch = new ObservableField<>(false);

    //当前选择的登录项
    public ObservableField<Integer> loginType = new ObservableField<>(PHONE);

    //成功图片
    public ObservableField<String> imageUrl = new ObservableField<>();

    public TextViewBindingAdapter.AfterTextChanged textChanged = new TextViewBindingAdapter.AfterTextChanged() {
        @Override
        public void afterTextChanged(Editable s) {
            Util.log("1 " + (phone.length() == 11 && code.length() == 4));
            Util.log("2 " + (user.length() > 2));
            isMatch.set((phone.length() == 11 && code.length() == 4) || user.length() > 2);
        }
    };

    public CompoundButton.OnCheckedChangeListener checkChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (!isChecked) return;
            loginType.set(NONE);
            int id = buttonView.getId();
            switch (id) {
                case R.id.checkboxPhone:
                    loginType.set(PHONE);
                    break;
                case R.id.checkboxUser:
                    loginType.set(USER);
                    break;
            }
        }
    };

    @Override
    public void onLoginClick(int type) {
        Util.hideSoftKeBoard();
        if (type == 1) {//phone
            Util.showMsg("phone:" + phone + "\ncode:" + code);
        } else if (type == 2) {//user
            Util.showMsg("user:" + user);
        }
        imageUrl.set("https://img.zcool.cn/community/01b3085a5d5c15a80120121f44e934.gif");
    }
}
