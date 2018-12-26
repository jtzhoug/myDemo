package com.zjt.javaTest;

/**
 * @author zhou.jingtao
 * @date created in 21:35 2018/12/2
 * @Description:
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int y = x;
        int ret = 0;
        int a;
        while (x != 0){
            a = x %10;
            ret = ret * 10 +a;
            x /= 10;
        }
        if (y<0 || ret!=y){
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }

    public boolean isPalindrome1(int x) {

        int xw = x %10;
        while (x < 0 || (x%10==0 && x!=0)){
            return false;
        }
        int revertNumber = 0;
        while (x>revertNumber){
            revertNumber = revertNumber*10 + x%10;
            x/=10;
        }
        return  x==revertNumber || revertNumber/10==x;
    }


        public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        Boolean reverse = isPalindrome.isPalindrome1(10);
        System.out.println(reverse);
    }
}
