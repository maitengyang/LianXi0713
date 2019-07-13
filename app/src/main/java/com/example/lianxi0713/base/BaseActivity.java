package com.example.lianxi0713.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.lianxi0713.base.mvp.BasePresenter;
import com.example.lianxi0713.base.mvp.IBaseModel;
import com.example.lianxi0713.base.mvp.IBaseView;
import com.gyf.barlibrary.ImmersionBar;

import static com.blankj.utilcode.util.CrashUtils.init;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:9:03
 *@Description:作用:
 * */public abstract class BaseActivity<M extends IBaseModel,P extends BasePresenter> extends AppCompatActivity implements IBaseView {
     public M model;
     public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        initview();
        init();
    }
private void init(){
//沉浸式
    ImmersionBar.with(this).transparentBar().statusBarDarkFont(true).init();//透明效果
    presenter= (P) initpresenter();
    if (presenter!=null){
        model= (M) presenter.getModel();
        if (model!=null){
            presenter.onAttch(model,this);
        }
    }
    initData();
}

    protected abstract void initData();

    protected abstract int initlayout();

    protected abstract void initview();


}
