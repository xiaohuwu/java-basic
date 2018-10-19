package com.ktb.basic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2018-10-19.
 */

public class HasStatic {
    private static int x = 100;

    public static void main(String[] args)
    {
        Integer n1 = new Integer(47);
        int n2 = 47;
        System.out.print(n1 == n2);
        System.out.print(",");
        System.out.println(n1 != n2);
    }
}
