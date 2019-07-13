package com.example.lianxi0713.base.mvp;

import java.lang.ref.WeakReference;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:10:34
 *@Description:作用:
 * */public abstract class BasePresenter<M,V> {
     public  M model;
     public  V view;
     private WeakReference<V> weakReference;
    public abstract M getModel();
    public void onAttch(M model,V view){
        this.model=model;
        weakReference=new WeakReference<>(view);
        this.view=weakReference.get();
    }
    public void onDeattch(){
        if (weakReference!=null){
            weakReference.clear();//清空对象
            weakReference=null;
            this.view=null;
        }
    }
}
