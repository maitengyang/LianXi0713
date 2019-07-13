package com.example.lianxi0713.contract;

import android.content.Context;

import com.example.lianxi0713.base.mvp.BasePresenter;
import com.example.lianxi0713.model.DownLoadModel;
import com.example.lianxi0713.net.DownloadCallback;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:11:02
 *@Description:作用:
 * */public interface DownLoadContract {
     abstract class DownloadPresenter extends BasePresenter<IDownModel,IDownView>{
         public abstract void download(Context mcontext,String loadurl,String filepath);
         public abstract void pause();
         public abstract void cancel();
         public abstract void start();

         @Override
         public IDownModel getModel() {
             return new DownLoadModel();
         }
     }
     public interface IDownModel{
         void download(Context mContext, String loadurl, String filepath, DownloadCallback downloadCallback);
         void pause();
         void cancel();
         void start();
     }
     public interface IDownView{
         void finish();//下载完成
         void error();//下载完成
         void progress(int progress);//进度条
     }
}
