package com.zjt.utils;

/**
 * @author zhou.jingtao
 * @date created in 14:46 2018/11/22
 * @Description:
 */
public class ArrayUtils {
    public static String ArraytoString(Object[][] arr) {

        if (arr == null)
            return "null";

        int iMax = arr.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append("[");
        for (int i = 0; i <= iMax; i++) {
            if (arr[i].length == 0) {
                b.append("[]");
                continue;
            }else if (arr[i] == null) {
                b.append("[null]");
                continue;
            }
            b.append("[");
            for (int j = 0; j < arr[i].length; j++) {
                b.append("" + arr[i][j]);
                if (j == arr[i].length - 1) {
                    b.append("]");
                    continue;
                }
                b.append(",");
            }
        }
        b.append("]");
        return b.toString();
    }
}
