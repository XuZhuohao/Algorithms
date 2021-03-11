package com.yui.study.algorithms.base.sort;

import com.yui.study.algorithms.base.util.DataUtil;
import com.yui.study.algorithms.base.util.StdDrawUtil;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author XuZhuohao
 * @date 2021/3/11
 */
public class InsertionSort implements ISort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
                DataUtil.swap(data, j, j - 1);
            }
        }
    }

    @Override
    public void sort(Integer[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; j--) {
                DataUtil.swap(data, j, j - 1);
                StdDrawUtil.drawHistogram(data);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Integer[] arrays = new Integer[]{3, 2, 9, 7, 8, 6, 1, 5, 0, 4};
        ISort iSort = new InsertionSort();
        iSort.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
