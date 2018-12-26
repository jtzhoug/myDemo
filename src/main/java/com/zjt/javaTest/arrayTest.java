package com.zjt.javaTest;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhou.jingtao
 * @date created in 22:23 2018/11/21
 * @Description:
 */
public class arrayTest {

    public static void main(String[] args) {
        //     String str = "[[],[21,30],[51,60],[]]";
        //     Pattern p1 =Pattern.compile("(\\d{1,},\\d{1,})");
        //     Matcher m1 = p1.matcher(str);
        //     while (m1.find()){
        //         String s = m1.group(1);
        //         System.out.println(s);
        //     }
        //
        // }
        //
        // List<String> list = new ArrayList<>();
        // list.add("a");
        // list.add("b");
        // list.add("c");
        // System.out.println(list);
        // String[] s = new String[list.size()];
        // String s1 = s[1];
        // System.out.println(s1);
        // System.out.println(list.toArray(s)[0]);
        // int[][] a = {{1,2},{2,2}};
        // System.out.println(Arrays.toString(a));
        // char[] data = {'a', 'b', 'c'};
        // String str = new String(data);
        // System.out.println(str);


            String s = "[[],[3,4],[5,6],[7,8]]";
            List<String> list = new ArrayList();
            list.add("11");
            list.add("ss");

            List<String> list1 = new ArrayList();
            list1.add("sssdsds");
        System.out.println(list1);
        System.out.println(list);

        List list2 = new ArrayList();
        list2.addAll(list);
        list2.addAll(list1);
        System.out.println(list2);
             String sss = "[[],[\"11\",\"20\"],[\"21\",\"25\"],[\"41\",\"46\"],[]]";
            String[] s1 = sss.replaceAll("],", "]#").split("#");
            String[][] arr = new String[s1.length][];
            for (int i = 0; i < arr.length; i++) {
                String[] s2 = s1[i].split(",");
                arr[i] = new String[s2.length];
                for (int j = 0; j < s2.length; j++) {
                    arr[i][j] = s2[j].replaceAll("\\[|\\]", "");
                }
            }
            for (String[] i : arr) {
                System.out.println(Arrays.toString(i));
            }
            if (StringUtils.isEmpty((arr[0][0])) ){
                System.out.println("null");
            }
             System.out.println(arr[1][1]);
            String ss = arr[1][1].replace("\"","");
            Integer a = Integer.valueOf(ss);
            // Integer a01 = Integer.valueOf(arr[0][0]);
            // Integer a02 = Integer.valueOf(arr[0][1]);

        System.out.println(a);
        // String aaa = "11";
        String abc = (arr[1][0]);
        // System.out.println(Integer.valueOf(Integer.valueOf(abc)));
        // System.out.println("1111");
        // System.out.println(a01 + "ss" + a02);
    }
}
