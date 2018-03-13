package com.example.zhengbotao.classassistant.mvptest.model;

import com.example.zhengbotao.classassistant.mvptest.MvpCallback;

/**
 * Created by zhengbotao on 18-3-13.
 */

public interface IMvpModel {

    void getNetData(final String param,final MvpCallback<String> callback);
}
