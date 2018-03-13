package com.example.zhengbotao.classassistant.mvptest.Presenter;

import com.example.zhengbotao.classassistant.base.BasePresenter;
import com.example.zhengbotao.classassistant.mvptest.MvpCallback;
import com.example.zhengbotao.classassistant.mvptest.model.MvpModel;
import com.example.zhengbotao.classassistant.mvptest.view.IMvpView;

/**
 * Created by zhengbotao on 18-3-9.
 */

public class MvpPresenter extends BasePresenter<IMvpView>{

    private MvpModel mvpModel;

    // 该构造需要做两件事，持有View以及Model，优化后View在attach函数中获取，View则在这里new
    public MvpPresenter() {
        mvpModel = new MvpModel();
    }

    public void getData(String param){

        if (!isViewAttached()){
            //如果没有View引用就不加载数据
            return;
        }

        getView().showLoading();

        mvpModel.getNetData(param, new MvpCallback<String>() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()){
                    getView().showData(data);
                }
            }

            @Override
            public void onFaliure(String msg) {
                if (isViewAttached()){
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError(String e) {
                if (isViewAttached()){
                    getView().showToast(e);
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()){
                    getView().hideLoading();
                }
            }
        });
    }

}
