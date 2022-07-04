package com.cuongtm.dataconverter.service;

public interface StringConverterService {
    String toString(Object source);

    byte[] toByteArray(String source);
}
