package com.cuongtm.dataconverter.util;

import java.util.Base64;

public class Base64Util {

    public static String encode(byte[] bytes){
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        return encodedString;
    }

    public static String encode(String originalInput){
        if(originalInput==null){
            return null;
        }

        byte []bytes = StringUtil.toBytes(originalInput);
        return encode(bytes);
    }

    public static byte[] decode(String encodedString){
        if(encodedString==null){
            return new byte[0];
        }

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return decodedBytes;
    }
}
