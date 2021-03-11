package com.yui.study.algorithms.base.sort;

import com.yui.study.algorithms.base.util.DataUtil;
import com.yui.study.algorithms.base.util.StdDrawUtil;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

/**
 * @author XuZhuohao
 * @date 2021/3/11
 */
public class SelectionSort implements ISort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] data) {
        for (int i = 0; i < data.length; i++) {
            // -1 < 0 = 1 >
            for (int j = i + 1; j < data.length; j++) {
                if (data[i].compareTo(data[j]) > 0) {
                    DataUtil.swap(data, i, j);
                }
            }
        }
    }

    @Override
    public void sort(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            // -1 < 0 = 1 >
            for (int j = i + 1; j < data.length; j++) {
                if (data[i].compareTo(data[j]) > 0) {
                    DataUtil.swap(data, i, j);
                    StdDrawUtil.drawHistogram(data);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{3,2,9,7,8,6,1,5,0,4};
        ISort iSort = new SelectionSort();
        iSort.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
