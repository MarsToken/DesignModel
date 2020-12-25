package com.example.designmodel.leakcanary.singleTon;

/**
 * Created by tellerWang on 2020/12/25.
 */
public class DownloadManager {
    private static DownloadManager instance;
    private Task task ;

    public static DownloadManager getInstance(){
        if (instance == null) {
            instance = new DownloadManager();
        }
        return instance;
    }
    public Task newTask(){
        this.task = new Task();
        return task;
    }
}
