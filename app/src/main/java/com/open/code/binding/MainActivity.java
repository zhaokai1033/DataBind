package com.open.code.binding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.open.code.binding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public ObservableField<String> content = new ObservableField<>();
    public String title = "基本用法";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(this);
        binding.setVariable(BR.model,this);
    }

    public void change() {
        content.set(System.currentTimeMillis() + "");
    }

    public void gotoLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
