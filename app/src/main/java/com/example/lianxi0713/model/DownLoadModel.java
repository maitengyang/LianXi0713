package com.example.lianxi0713.model;

import android.content.Context;

import com.example.lianxi0713.DownLoadFile;
import com.example.lianxi0713.base.mvp.IBaseModel;
import com.example.lianxi0713.contract.DownLoadContract;
import com.example.lianxi0713.net.DownloadCallback;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:11:21
 *@Description:作用:
 * */public class DownLoadModel implements DownLoadContract.IDownModel, IBaseModel {
     private DownLoadFile downLoadFile;


    @Override
    public void download(Context mContext, String loadurl, String filepath, final DownloadCallback downloadCallback) {
        downLoadFile=new DownLoadFile(mContext,loadurl,filepath,3);
        downLoadFile.downLoad();
        downLoadFile.setOnDownLoadListener(new DownLoadFile.DownLoadListener() {
            @Override
            public void getProgress(int progress) {
                if (downloadCallback!=null){
                    downloadCallback.progress(progress);
                }
            }

            @Override
            public void onComplete() {
                if (downloadCallback!=null){
                    downloadCallback.onfinish();
                }
            }

            @Override
            public void onFailure() {
                if (downloadCallback!=null){
                    downloadCallback.onerror();
                }
            }
        });
    }

    @Override
    public void pause() {
        downLoadFile.onPause();
    }

    @Override
    public void cancel() {
        downLoadFile.cancel();
    }

    @Override
    public void start() {
        downLoadFile.onStart();
    }
}
