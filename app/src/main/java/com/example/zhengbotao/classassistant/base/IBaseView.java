package com.example.zhengbotao.classassistant.base;

import android.content.Context;

/**
 * Created by zhengbotao on 18-3-10.
 * BaseView中定义通用的Activity UI逻辑，比如显示/隐藏进度条，弹出Toast等
 */

public interface IBaseView {

    /**
     * 显示正在加载View
     */
    void showLoading();

    /**
     *关闭正在加载View
     */
    void hideLoading();

    /**
     *显示提示
     */
    void showToast(String msg);


    /**
     *获取上下文
     */
    Context getContext();
}
