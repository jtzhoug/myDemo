package com.zjt.javaTest;

/**
 * @author zhou.jingtao
 * @date created in 23:33 2018/11/29
 * @Description:
 */
public class ReverseInteger {

    public int reverse(int x) {
        int ret = 0;
        int a;
        while (x != 0){
            a = x %10;
            if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE){
                return 0;
            }
            ret = ret * 10 +a;

            x /= 10;
        }

        return ret;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int reverse = reverseInteger.reverse(-89879);
        System.out.println(reverse);
    }
}
