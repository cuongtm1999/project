package com.cuongtm.dataconverter.service;

public interface Base64ConverterService {
    String toBase64(byte[] bytes);

    String toBase64(String source);
}
