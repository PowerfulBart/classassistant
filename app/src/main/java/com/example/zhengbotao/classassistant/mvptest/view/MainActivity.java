package com.example.zhengbotao.classassistant.mvptest.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhengbotao.classassistant.R;
import com.example.zhengbotao.classassistant.base.BaseActivity;
import com.example.zhengbotao.classassistant.mvptest.Presenter.MvpPresenter;

public class MainActivity extends BaseActivity implements IMvpView,View.OnClickListener{

    TextView textView;
    MvpPresenter presenter;
    private Button successBtn,failureBtn,errorBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
        presenter = new MvpPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showData(String param) {
        textView.setText(param);
    }

//    public void getSuccess(View view){
//    }
//
//    public void getFailure(View view){
//    }
//
//    public void getError(View view){
//        presenter.getData("error");
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.success_btn:
                presenter.getData("normal");
                break;
            case R.id.failure_btn:
                presenter.getData("failure");
                break;
            case R.id.error_btn:
                presenter.getData("error");
                break;
            default:
                break;
        }
    }

    private void initView() {
        successBtn = findViewById(R.id.success_btn);
        failureBtn = findViewById(R.id.failure_btn);
        errorBtn = findViewById(R.id.error_btn);
        textView = findViewById(R.id.show_tv);

        successBtn.setOnClickListener(this);
        failureBtn.setOnClickListener(this);
        errorBtn.setOnClickListener(this);
    }
}
