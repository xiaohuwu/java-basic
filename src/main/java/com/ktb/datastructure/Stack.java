package com.ktb.datastructure;

import com.sun.org.apache.xpath.internal.SourceTree;
import java.util.Arrays;
/**
 * Created by dell on 2018-10-11.
 */
public class Stack<T> {
    public T[] array;
    // 控制访问的索引
    private int size = 0;
    private Stack(){
        array = (T[])new Object[16];
    }

    public void push(T t){
        //扩容
        if(size == array.length){
            array = Arrays.copyOf(array,array.length*2 );
        }
        array[size++] = t;
    }

    public T pop() throws Exception{

        if(size==0){
            throw new Exception("ddd");
        }
        --size;
        T result = array[size];
        array[size] = null;
        return result ;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(Arrays.toString(stack.array));
        try {
            Integer pop = stack.pop();
            System.out.println("[pop]:"+pop);
            System.out.println(Arrays.toString(stack.array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
