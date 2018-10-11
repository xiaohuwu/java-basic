package com.ktb.datastructure;

import java.util.Arrays;

/**
 * Created by dell on 2018-10-11.
 */
public class Queue<T> {
    public T[] array;
    // 控制访问的索引
    private int size = 0;

    private Queue(){
        array = (T[])new Object[16];
    }

    public void push(T t){
        //扩容
        if(size == array.length){
            array = Arrays.copyOf(array,array.length*2 );
        }
        array[size++] = t;
    }

    public T shift() throws Exception{
        if(size==0){
            throw new Exception("ddd");
        }
        T result = array[0];
        T[] temp = (T[])new Object[array.length];
        System.arraycopy(array,1,temp,0,array.length-1);
        array = temp;
        return result ;
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push("张三");
        queue.push("王五");
        queue.push("李四");
        System.out.println(Arrays.toString(queue.array));
        try {
            Object shift = queue.shift();
            System.out.println("[shift]:"+shift);
            System.out.println(Arrays.toString(queue.array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
