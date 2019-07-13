package com.example.lianxi0713.net;

/*
 *@Auther:苏格拉没有底
 *@Date: 2019/7/13
 *@Time:11:26
 *@Description:作用:
 * */public interface DownloadCallback {
     void onfinish();
     void onerror();
     void progress(int progress);
}
