package com.ktb.datastructure;

import java.util.Arrays;

/**
 * Created by dell on 2018-10-11.
 * 参考博客 https://blog.csdn.net/Jaihk662/article/details/79604915
 */
public class Sort {
    // 冒泡排序 暴力枚举相邻的两个数，如果逆序就把它们交换
    private static <T extends Comparable> T[] bubbleSort(T[] array) {
        for (int k = array.length - 1; k >= 0; k--) {
            for (int j = 0; j < k; j++) {
                T current = array[j];
                T next = array[j + 1];
                if (current.compareTo(next) > 0) {
                    swap(array, j);
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    private static <T extends Comparable> void swap(T[] array, int j) {
        T temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
    }

    // 选择排序  每次选择后n-i个数字中最小的和当前第i位交换
    private static <T extends Comparable> T[] selectionSort(T[] array) {
        for (int k = 0; k < array.length; k++) {
            for (int j = k + 1; j < array.length; j++) {
                if (array[j].compareTo(array[k]) < 0) {
                    selectSwap(array, k, j);
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 直接插入排序：
     * 6     直接插入排序就是从待排序列中选出一个元素，插入到已经有序的元素之中，直到所有的元素都插入到有序序列中所有的元素就全部
     * 7 有序了。
     * 8     通常的做法就是将第一个元素看做是有序的元素（即待排序列的第一个元素看做是有序序列），然后我们将第二个元素和有序序列（即
     * 9 第一个元素）作比较，按正确的序列插入到序列中去。然后在将第三个元素和前面有序序列（即整个待排序列的前两个元素）作比较，将第
     * 10 三个插入到前两个元素中去，使得前三个元素有序。以此类推，直到所有的元素都有序
     *
     * @param array
     * @param <T>
     * @return
     */
    private static <T extends Comparable> T[] insertSort(T[] array) {
        for (int k = 1; k < array.length; k++) {
            for (int j = 0; j < k; j++) {
                //array[k] 被插入的元素
                if (array[k].compareTo(array[j]) < 0) {
                    selectSwap(array, k, j);
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }


    private static <T extends Comparable> void selectSwap(T[] array, int k, int j) {
        T temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] array = {78, 111, 5, 7, 80, 34, 12, 67};
        // Integer[] integers = bubbleSort(array);
        //System.out.println(Arrays.toString(integers));
        Integer[] integers = insertSort(array);
        System.out.println(Arrays.toString(integers));
    }


}
