package com.cuongtm.dataconverter.service.impl;

import com.cuongtm.dataconverter.service.HexConverterService;
import com.cuongtm.dataconverter.service.StringConverterService;
import com.cuongtm.dataconverter.util.HexUtil;
import org.springframework.stereotype.Service;

@Service
public class HexConverterServiceImpl implements HexConverterService {
    private StringConverterService stringConverterService;

    public HexConverterServiceImpl(StringConverterService stringConverterService){
        this.stringConverterService = stringConverterService;
    }

    @Override
    public String toHex(String source) {
        byte []bytes = this.stringConverterService.toByteArray(source);
        return HexUtil.toHexString(bytes);
    }
}
