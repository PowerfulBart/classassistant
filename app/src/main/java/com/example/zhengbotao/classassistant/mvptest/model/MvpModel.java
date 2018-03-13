package com.example.zhengbotao.classassistant.mvptest.model;

import android.os.Handler;

import com.example.zhengbotao.classassistant.mvptest.MvpCallback;

/**
 * Created by zhengbotao on 18-3-9.
 */

public class MvpModel implements IMvpModel{

    public MvpModel() {
    }

    public void getNetData(final String param, final MvpCallback<String> callback){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                switch (param){
                    case "normal":
                        callback.onSuccess("调用"+param+"成功了");
                        break;

                    case "failure":
                        callback.onFaliure("调用"+param+"失败了");
                        break;

                    case "error":
                        callback.onError("调用"+param+"错误了");
                        break;
                }
                callback.onComplete();
            }
        }, 2000);
    }
}
