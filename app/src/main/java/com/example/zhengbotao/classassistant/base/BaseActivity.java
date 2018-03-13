package com.example.zhengbotao.classassistant.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by zhengbotao on 18-3-10.
 * BaseActivity主要是负责实现 BaseView 中通用的UI逻辑方法，
 * 这样这些通用的方法就不用每个Activity都要去实现一遍了。
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{

    private ProgressDialog dialog;

        @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
    }

    @Override
    public void showLoading() {
        if (!dialog.isShowing()){
            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }
}
