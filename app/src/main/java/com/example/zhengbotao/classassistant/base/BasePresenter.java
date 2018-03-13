package com.example.zhengbotao.classassistant.base;

/**
 * Created by zhengbotao on 18-3-10.
 * Presenter中可共用的代码就是对View引用的方法了
 * 由于我们已经定义好了BaseView，所以我们希望Presenter中持有的View都是BaseView的子类，这里同样需要泛型来约束
 */

public class BasePresenter<V extends IBaseView> {

    /**
     * 绑定的View
     */
    private V mvpView;

    /**
     * 若MvpView由Presenter的构造函数传进来，在进行异步求情的过程中，若View被销毁，
     * Presenter收到后台反馈并调用View接口处理UI逻辑时，由于Activity已经被销毁，就会引发空指针异常。
     * 想要避免这种情况的发生就需要每次调用View前都知道宿主Activity的生命状态。
     *
     * 之前是在Presenter的构造方法中得到View接口的引用，现在我们需要修改Presenter引用View接口的方式让View接口与宿主Activity共存亡：
     * 即在View的生命周期函数中随时进行View的绑定（onCreate）与销毁（onDestroy）
     * @param mvpView
     */
    public void attachView(V mvpView){
        this.mvpView = mvpView;
    }

    public void detachView(){
        this.mvpView = null;
    }

    public boolean isViewAttached(){
        return mvpView != null;
    }

    public V getView(){
        return mvpView;
    }
}
