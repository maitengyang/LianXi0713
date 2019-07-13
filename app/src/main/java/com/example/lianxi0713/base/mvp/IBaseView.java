package com.example.lianxi0713.base.mvp;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:10:42
 *@Description:作用:
 * */public interface IBaseView {
     BasePresenter initpresenter();
     void showLoading();//显示加载框
     void hintLoading();//隐藏加载框
    void onFail(String msg);//请求失败
}
