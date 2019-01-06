package com.zjt.javaTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhou.jingtao
 * @date created in 21:15 2018/12/9
 * @Description:
 */
public class RomanToInt {

    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        Integer result = 0;
        for (int i=0 ;i<s.length();i++){

            String a = String.valueOf(s.charAt(i));
            if (s.length()-1 == i){
                result += map.get(a);
            } else if (map.get(a) < map.get(String.valueOf(s.charAt(i+1)))){
                result += map.get(String.valueOf(s.charAt(i+1))) - map.get(a);
                i+=1;
            } else {
                result += map.get(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
}
