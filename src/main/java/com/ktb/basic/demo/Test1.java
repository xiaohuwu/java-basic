package com.ktb.basic.demo;

import java.util.Scanner;

/**
 * Created by dell on 2018-10-22.
 * do while example
 *感觉应该用循环 但是不知道具体循环次数 用while 或者 do while
 */
public class Test1 {
    public static void main(String[] args) {
        //how much money you need pay
        System.out.println("how much money you need pay");
        Scanner scanner = new Scanner(System.in);
        double need = scanner.nextDouble();
        System.out.println("how much money you every pay");
        double everypay = scanner.nextDouble();
        double balnce = 0;
        int year = 0;
        String input = "";
        do{
            balnce+=everypay;
            balnce+= balnce*(3D/100);
            year++;
            System.out.println(year+"余额为:"+balnce+"\r\n"+"需要退出么?");
            input = scanner.next();
        }while (!"Y".equals(input));
    }
}
