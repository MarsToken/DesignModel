package com.example.designmodel.testutils;

import android.os.FileObserver;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * des
 *
 * @author WangMaoBo
 * @constructor 创建此类对象的主构造函数
 * @since 2024/6/18
 */
public class FileObserverTest {
    private static final String TAG = "Test";
    private static FileObserver fileObserver;
    private static boolean isFirst = true;

    public static void observer(String rootPath) {
        Log.e(TAG, rootPath);
        fileObserver = new FileObserver(rootPath, FileObserver.ALL_EVENTS) {
            @Override
            public void onEvent(int event, @Nullable String path) {
                switch (event) {
                    case CREATE:
                        Log.e(TAG + "CREATE", path);
                        break;
                    case DELETE:
                        Log.e(TAG + "DELETE", path);
                        break;
                    case DELETE_SELF:
                        Log.e(TAG + "DELETE_SELF", path);
                        break;
                    case MODIFY:
                        Log.e(TAG + "MODIFY", path);
                        File file = new File(rootPath + "/" + path);
                        if (file.exists()) {
                            try {
                                FileReader fileReader = new FileReader(file);
                                BufferedReader bufferedReader = new BufferedReader(fileReader);
                                String line = bufferedReader.readLine();
                                System.out.println("line is " + line);
                                String[] arr = line.split(":");
                                if (arr.length == 2 && null != arr[1]) { // && isFirst
                                    System.out.println("name is " + line.split(":")[1]);
                                    isFirst = false;
                                    fileObserver.stopWatching();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case MOVED_FROM:
                        Log.e(TAG + "MOVED_FROM", path);
                        break;
                    case MOVED_TO:
                        Log.e(TAG + "MOVED_TO", path);
                        break;
                    case ATTRIB:
                        Log.e(ATTRIB + "CREATE", path);
                        break;
                }
            }
        };
        fileObserver.startWatching();
    }
}
