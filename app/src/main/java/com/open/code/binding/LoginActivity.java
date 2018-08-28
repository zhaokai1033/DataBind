package com.open.code.binding;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.ViewGroup;

import com.open.code.binding.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binder = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binder.setLogin(new ModelLogin());
        //延迟动画
        binder.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {

                ViewGroup root = (ViewGroup) binding.getRoot();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(root);
                }

                return true;
            }
        });
    }

    public interface loginFace {
        void onLoginClick(int type);
    }
}
