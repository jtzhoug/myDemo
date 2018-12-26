package com.zjt.javaTest;

/**
 * @Auther: zhou.jingtao
 * @Date: 2018-12-25 17:16
 * @Description:最长公共前缀
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        if (strs.length == 0){
            return "";
        }
        for (int i = 0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (String str : strs){
                if (str.length() == i || c != str.charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
            index++;
        }
        return strs[0].substring(0,index);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] str = {"flower","flow","flight"};
        String[] str2 = {"dog","racecar","car"};
        String[] str3 = {"aaa","a"};
        String strs = longestCommonPrefix.longestCommonPrefix(str3);
        System.out.println(strs);


    }
}
