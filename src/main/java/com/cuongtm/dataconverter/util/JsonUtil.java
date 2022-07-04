package com.cuongtm.dataconverter.util;

import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;

public class JsonUtil {
    public static Object toOject(String json, Class clazz){
        if(json==null){
            return null;
        }

        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

    public static String toJson(Object o){
        if(o==null){
            return null;
        }

        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
