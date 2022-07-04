package com.cuongtm.dataconverter.util;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;

public class ByteArrayUtil {
    public static byte[] toBytes(String originalInput){
        if(originalInput==null){
            return new byte[0];
        }

        // string to byte[]
        byte[] bytes = originalInput.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

    public static String toString(byte[] bytes){
        if(bytes==null){
            return null;
        }

        // byte[] to string
        String s = new String(bytes, StandardCharsets.UTF_8);
        return s;
    }

    public static byte[] toBytes(ArrayList<Integer> list){
        byte[] result = new byte[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).byteValue();
        }
        return result;
    }
}
