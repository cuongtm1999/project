package com.cuongtm.dataconverter.service.dto;

public class DataInputDTO {
    private DataTypeEnum sourceType = null;
    private Object source;

    private DataTypeEnum targetType = null;

    public DataInputDTO() {
    }

    public DataInputDTO(DataTypeEnum sourceType, String source, DataTypeEnum targetType) {
        this.sourceType = sourceType;
        this.source = source;
        this.targetType = targetType;
    }

    public DataTypeEnum getSourceType() {
        return sourceType;
    }

    public void setSourceType(DataTypeEnum sourceType) {
        this.sourceType = sourceType;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public DataTypeEnum getTargetType() {
        return targetType;
    }

    public void setTargetType(DataTypeEnum targetType) {
        this.targetType = targetType;
    }
}
