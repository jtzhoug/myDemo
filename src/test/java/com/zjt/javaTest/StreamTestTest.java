package com.zjt.javaTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author zhou.jingtao
 * @date created in 09:56 2018/11/16
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class StreamTestTest {
    @Test
    public void filterStudent() throws Exception {
    }

    @Test
    public void mapFilterTest(){
        Map<String,String> maps = new HashMap();
        maps.put("a","");
        maps.put("b","1");
        maps.put("aaa","22");
        maps.put("as","");

        Map<String,String> collect = maps
                .entrySet()
                .stream()
                .filter(map -> map.getValue() == "")
                .collect(Collectors.toMap(p -> p.getKey(),p -> p.getValue()));


        String collects = maps.entrySet()
                .stream()
                .filter(map -> map.getValue() == "")
                .map(map -> map.getValue())
                .collect(Collectors.joining());
        System.out.println(maps);
        System.out.println(collect);
        System.out.println(collects);
    }

}