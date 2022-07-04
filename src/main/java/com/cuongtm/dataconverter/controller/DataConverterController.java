package com.cuongtm.dataconverter.controller;

import com.cuongtm.dataconverter.service.impl.Base64Adapter;
import com.cuongtm.dataconverter.service.impl.HexConverterServiceImpl;
import com.cuongtm.dataconverter.service.HexConverterService;
import com.cuongtm.dataconverter.service.StringConverterService;
import com.cuongtm.dataconverter.service.dto.DataInputDTO;
import com.cuongtm.dataconverter.util.Base64Util;
import com.cuongtm.dataconverter.util.ByteArrayUtil;
import com.cuongtm.dataconverter.util.HexUtil;
import com.cuongtm.dataconverter.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/data-converter")
public class DataConverterController {
    @Autowired
    private StringConverterService stringConverterService;

    private HexConverterService hexConverterService;

    private Base64Adapter base64Adapter;

    @PostMapping("/convert")
    public ResponseEntity<Object> convert(@RequestBody DataInputDTO input) throws BadRequestException {
        if(input.getSource()==null){
            throw new BadRequestException("#001 Kiểu dữ liệu cần chuyển đổi bắt buộc phải chọn","Kiểu dữ liệu được chuyển đổi bắt buộc phải chọn");
        }

        if(input.getTargetType()==null){
            throw new BadRequestException("#002 Kiểu dữ liệu sau khi chuyển đổi bắt buộc phải chọn", "Kiểu dữ liệu muốn chuyển đổi bắt buộc phải chọn");
        }

        if(input.getSourceType()==input.getTargetType()){
            return ResponseEntity.ok(input.getSource());
        }

        //SOURCE
        String sourceStr;
        if(input.getSource()==null){
            sourceStr = null;
        }else{

            switch(input.getSourceType()){
                case string: {
                    sourceStr = input.getSource().toString();
                    break;
                }

                case byte_array: {
                    ArrayList byteList = (ArrayList) input.getSource();
                    byte bytes[] = ByteArrayUtil.toBytes(byteList);
                    sourceStr = ByteArrayUtil.toString(bytes);
                    break;
                }

                case base64:
                case image:{
                    byte bytes[] = Base64Util.decode(input.getSource().toString());
                    sourceStr = ByteArrayUtil.toString(bytes);
                    break;
                }

                case hex: {
                    sourceStr = HexUtil.fromHexString(input.getSource().toString());
                    break;
                }

                default: {
                    sourceStr = input.getSource().toString();
                    break;
                }
            }
        }

        //TARGET
        String target = null;

        switch(input.getTargetType()){
            case string: {
                target = sourceStr;
                break;
            }

            case byte_array: {
                byte bytes[] = stringConverterService.toByteArray(sourceStr);
                target = JsonUtil.toJson(bytes);
                break;
            }

            case image:
            case base64: {
                base64Adapter = new Base64Adapter(this.stringConverterService);
                target = base64Adapter.toBase64(sourceStr);
                break;
            }

            case hex: {
                hexConverterService = new HexConverterServiceImpl(this.stringConverterService);
                target = hexConverterService.toHex(sourceStr);
                break;
            }

            default: {
                target = null;
                break;
            }
        }

        return ResponseEntity.ok(target);
    }
}
