package com.example.lianxi0713;

import android.content.Context;

import com.example.lianxi0713.contract.DownLoadContract;
import com.example.lianxi0713.net.DownloadCallback;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:11:34
 *@Description:作用:
 * */public class DownloadPresenter extends DownLoadContract.DownloadPresenter {
    @Override
    public void download(Context mcontext, String loadurl, String filepath) {
        model.download(mcontext, loadurl, filepath, new DownloadCallback() {
            @Override
            public void onfinish() {
                view.finish();
            }

            @Override
            public void onerror() {
                view.error();
            }

            @Override
            public void progress(int progress) {
                view.progress(progress);
            }
        });
    }

    @Override
    public void pause() {
        model.pause();
    }

    @Override
    public void cancel() {
        model.cancel();
    }

    @Override
    public void start() {
        model.start();
    }
}
