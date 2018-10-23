package com.ktb.basic.exception;
/**
 * Created by dell on 2018-10-22.
 */

class MyException extends Exception{

    public MyException(String msg){
        super(msg);
    }
}

public class DefaultException {
    public static void main(String[] args) {
        try {
            /**
             * throw exception 要么捕获 要么显示声明
             * throw RuntimeException 就没必要了 交个调用者处理
             */
            throw new MyException("exception");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
