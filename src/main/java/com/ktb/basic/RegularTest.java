package com.ktb.basic;

/**
 * Created by dell on 2018-10-18.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \t \d 等正則表达式 需要对其转译
 */
public class RegularTest {

    public static void main(String[] args) {

        // String s = "abcd\s123"; this is error
        String str = "A21B22C33D44e";
        //根据 正则 生成 Pattern对象
        Pattern pattern = Pattern.compile("\\d+");
        //传入要比较的String 生成Mather对象
        Matcher matcher = pattern.matcher(str);
        
        System.out.println(matcher.matches());

    }

}
