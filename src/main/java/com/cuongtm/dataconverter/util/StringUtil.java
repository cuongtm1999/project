package com.cuongtm.dataconverter.util;

import java.nio.charset.StandardCharsets;

public class StringUtil {
    public static byte[] toBytes(String originalInput){
        if(originalInput==null){
            return new byte[0];
        }

        // string to byte[]
        byte[] bytes = originalInput.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    public static String toString(Object o){
        if(o==null){
            return null;
        }

        return o.toString();
    }
}
