package com.example.lianxi0713;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lianxi0713.base.BaseActivity;
import com.example.lianxi0713.base.mvp.BasePresenter;
import com.example.lianxi0713.contract.DownLoadContract;
import com.example.lianxi0713.model.DownLoadModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<DownLoadModel, DownloadPresenter> implements DownLoadContract.IDownView {

    @BindView(R.id.progress)
    ProgressBar progresss;
    @BindView(R.id.progressTv)
    TextView progressTv;
    @BindView(R.id.download)
    Button download;
    @BindView(R.id.pause)
    Button pause;
    @BindView(R.id.start)
    Button start;
    private String loadUrl = "http://gdown.baidu.com/data/wisegame/d2fbbc8e64990454/wangyiyunyinle_87.apk";
    private String filePath = Environment.getExternalStorageDirectory() + "/" + "网易云音乐.apk";


    @Override
    protected void initData() {

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initview() {

    }

    @Override
    protected void onDestroy() {
        presenter.cancel();
        super.onDestroy();
    }

    @Override
    public BasePresenter initpresenter() {
        return new DownloadPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hintLoading() {

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void error() {
        Toast.makeText(this, "下载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void progress(int progress) {
        progressTv.setText("当前下载进度："+progress+"%");
        progresss.setProgress(progress);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.download, R.id.pause, R.id.start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.download:
                presenter.download(this,loadUrl,filePath);
                break;
            case R.id.pause:
                presenter.pause();
                break;
            case R.id.start:
                presenter.start();
                break;

        }
    }
}
