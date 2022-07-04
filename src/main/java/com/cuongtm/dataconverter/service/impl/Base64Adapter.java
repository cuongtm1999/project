package com.cuongtm.dataconverter.service.impl;

import com.cuongtm.dataconverter.service.Base64ConverterService;
import com.cuongtm.dataconverter.service.StringConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class Base64Adapter implements Base64ConverterService {
    private StringConverterService stringConverterService;

    public Base64Adapter(StringConverterService stringConverterService){
        this.stringConverterService = stringConverterService;
    }

    @Override
    public String toBase64(byte[] bytes) {
        if(bytes==null || bytes.length==0) {
            return null;
        }

        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public String toBase64(String source) {
        String str = this.stringConverterService.toString(source);
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
