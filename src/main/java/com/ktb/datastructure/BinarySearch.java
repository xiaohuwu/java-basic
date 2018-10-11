package com.ktb.datastructure;

/**
 * Created by dell on 2018-10-11.
 */
public class BinarySearch {
    private static Integer[] array = {1,5,7,9,12,34,67,78,80};

    public static void main(String[] args) {
         int low = 0;
        int high =  array.length-1;
        int i = binarySearch(array, 34, low, high);
        System.out.println("[postion]:"+i);
    }

   public  static <T extends Comparable<T>>  int binarySearch(T[] array ,T t,int low,int high ){
        if(low <= high){
            int middle = low + ((high -low) >> 1);
            T t1 = array[middle];
            if(t.compareTo(t1)<0){
                high =  middle-1;
                return binarySearch(array,t,low,high);
            }else if(t.compareTo(t1)>0) {
                low =  middle+1;
                return  binarySearch(array,t,low,high);
            }else{
                return middle;
            }
        }
       return -1;
   }
}
