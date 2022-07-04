package com.cuongtm.dataconverter.service.impl;

import com.cuongtm.dataconverter.service.StringConverterService;
import com.cuongtm.dataconverter.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class StringConverterServiceImpl implements StringConverterService {
    @Override
    public String toString(Object source) {
        return StringUtil.toString(source);
    }

    @Override
    public byte[] toByteArray(String source) {
        return StringUtil.toBytes(source);
    }
}
