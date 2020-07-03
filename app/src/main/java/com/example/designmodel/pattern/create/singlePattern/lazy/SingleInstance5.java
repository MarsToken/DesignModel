package com.example.designmodel.pattern.create.singlePattern.lazy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2020/3/10.
 */
public class SingleInstance5 {
    private static Map<String, Object> objMap = new HashMap<>();

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}
