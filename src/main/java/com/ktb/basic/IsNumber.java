package com.ktb.basic;

/**
 * Created by dell on 2018-10-18.
 */
public class IsNumber {
    public static void main(String[] args) {
        String test = "019234567";
        boolean result =  isNumber(test);
        boolean other =  isNumberOther(test);
        System.out.println(result);
        System.out.println(other);
    }

    private static boolean isNumberOther(String test) {
        return test.matches("\\d+");
    }

    private static boolean isNumber(String test) {
        if(test==null){
            return false;
        }
        char[] chars = test.toCharArray();
        for(int k=0;k< chars.length;k++){
            if(chars[k]<'0'||chars[k]>'9'){
               return false;
            }
        }
        return true;
    }
}
