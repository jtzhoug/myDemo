package com.zjt.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zjt.model.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhou.jingtao
 * @date created in 15:12 2018/10/26
 * @Description: Json转换工具类
 */
public class FastJsonUtil {


    private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
            SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
    };

    /**
     * java对象转json字符串
     */
    public static Object JavaBeanToJson(Object object){
        return JSON.toJSONString(object);
    }

    /**
     * map转为Json
     */
    public static Object MapToJson(Map map){
        return JSONObject.toJSONString(map);
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("zzz");
        student.setMobile("1233");
        Map map = new HashMap();
        map.put("name","222");
        map.put("age","12");
        System.out.println(MapToJson(map));
    }


 }
