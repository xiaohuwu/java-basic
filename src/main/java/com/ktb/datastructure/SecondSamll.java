package com.ktb.datastructure;

/**
 * Created by dell on 2018-10-11.
 */
//Find the smallest and second smallest elements in an array
public class SecondSamll {
    private static int[] array = {12, 13, 1, 10, 34, 1};

    public static void main(String[] args) {
        int samll = Integer.MAX_VALUE;
        int second_samll = Integer.MAX_VALUE;
        for (int k = 0; k < array.length; k++) {
            if (array[k] < samll) {
                samll = array[k];
            }
        }
        System.out.println("[samll]:" + samll);
        for (int k = 0; k < array.length; k++) {
            if (  array[k] != samll && array[k] < second_samll ) {
                second_samll = array[k];
            }
        }
        System.out.println("[second_samll]:" + second_samll);
    }

    // 官方给的最优解
    static void print2Smallest(int arr[])
    {
        int first, second, arr_size = arr.length;

        /* There should be atleast two elements */
        if (arr_size < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (int i = 0; i < arr_size ; i ++)
        {
            /* If current element is smaller than first
              then update both first and second */
            if (arr[i] < first){
                second = first;
                first = arr[i];
            } else if(arr[i] < second && arr[i] != first){
                second = arr[i];
            }
        }
        if (second == Integer.MAX_VALUE){
            System.out.println("There is no second" +
                    "smallest element");
        } else{
            System.out.println("The smallest element is " +
                    first + " and second Smallest" +
                    " element is " + second);
        }

    }
}
