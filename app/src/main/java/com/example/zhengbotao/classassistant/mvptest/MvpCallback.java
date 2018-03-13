package com.example.zhengbotao.classassistant.mvptest;

/**
 * Created by zhengbotao on 18-3-9.
 * onSuccess()方法需要根据请求数据类型的不同设置为不同类型的参数，
 * 为避免当有新的数据类型都需要新建Callback，这个 引入泛型 的概念
 */

public interface MvpCallback<T> {

    /**
     * 数据请求成功
     * @param data  请求到的数据
     */
    void onSuccess(T data);

    /**
     * 使用网络API接口请求方式时，虽然已经请求成功但是由于{@code msg}的原因无法正常返回数据。
     * @param msg
     */
    void onFaliure(T msg);

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网、缺少权限，内存泄露等原因导致无法连接到请求数据源。
     * 如状态码为400，404，403，500等时调用此方法
     * @param e
     */
    void onError(T e);

    /**
     *
     */
    void onComplete();

}
