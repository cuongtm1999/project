package com.cuongtm.dataconverter.service.impl;

import com.cuongtm.dataconverter.service.Base64ConverterService;
import com.cuongtm.dataconverter.util.Base64Util;
import org.springframework.stereotype.Service;

@Service
public class Base64ConverterServiceImpl implements Base64ConverterService {
    @Override
    public String toBase64(byte[] bytes) {
       return Base64Util.encode(bytes);
    }

    @Override
    public String toBase64(String source) {
        return Base64Util.encode(source);
    }
}
