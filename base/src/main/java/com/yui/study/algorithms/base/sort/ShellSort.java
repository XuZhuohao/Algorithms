package com.yui.study.algorithms.base.sort;

import com.yui.study.algorithms.base.util.DataUtil;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author XuZhuohao
 * @date 2021/3/12
 */
public class ShellSort implements ISort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] data) {
        for (int step = data.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < data.length; i++) {
                for (int j = i - step; j >= 0 && data[j].compareTo(data[j + step]) > 0; j -= step) {
                    DataUtil.swap(data, j, j + step);
                }
            }
        }
    }



    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{3, 2, 9, 7, 8, 6, 1, 5, 0, 4};
        ISort iSort = new ShellSort();
        iSort.sort(arrays);
        System.out.println(Arrays.toString(arrays));

    }
}
