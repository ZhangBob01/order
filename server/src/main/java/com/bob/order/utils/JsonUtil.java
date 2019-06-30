package com.bob.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Auther: toudaizhi
 * @Date: 2019-06-01 17:58
 * @Description:
 */
public class JsonUtil {

    private  static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转Json
     * @param object
     * @return
     */
    public static String toJson(Object object){

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转对象
     * @param json
     * @param classType
     * @return
     */
    public static Object jsonFormObject(String json, Class classType){
        try {
            return objectMapper.readValue(json, classType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json转对象
     * @param json
     * @param typeReference
     * @return
     */
    public static Object jsonFormObject(String json, TypeReference typeReference){
        try {
            return objectMapper.readValue(json,typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
