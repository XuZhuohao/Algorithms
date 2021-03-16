package com.yui.study.algorithms.base.sort;

import com.yui.study.algorithms.base.util.DataUtil;

import java.util.Arrays;

/**
 * @author XuZhuohao
 * @date 2021/3/15
 */
public class MergeSort implements ISort {
    @Override
    public <T extends Comparable<? super T>> void sort(T[] data) {
        recursiveSort(data, 0, data.length);
    }

    private <T extends Comparable<? super T>> void recursiveSort(T[] data, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex <= 1) {
            return;
        }
        int middleIndex = (rightIndex + leftIndex) / 2;
        recursiveSort(data, leftIndex, middleIndex);
        recursiveSort(data, middleIndex, rightIndex);
        merge(data, leftIndex, middleIndex, rightIndex);
    }


    private <T extends Comparable<? super T>> void merge(T[] data, int leftIndex, int middleIndex, int rightIndex) {
        T[] tmpArray = (T[]) new Comparable[rightIndex - leftIndex];
        int middleTemp = middleIndex;
        int end = 0;
        int leftIndexTemp = leftIndex;
        for (; leftIndexTemp < middleIndex && middleTemp < rightIndex; end++) {
            if (data[leftIndexTemp].compareTo(data[middleTemp]) < 0) {
                tmpArray[end] = data[leftIndexTemp];
                leftIndexTemp++;
            } else {
                tmpArray[end] = data[middleTemp];
                middleTemp++;
            }
        }
        while (leftIndexTemp < middleIndex) {
            tmpArray[end++] = data[leftIndexTemp++];
        }
        while (middleTemp < rightIndex) {
            tmpArray[end++] = data[middleTemp++];
        }
        System.arraycopy(tmpArray, 0, data, leftIndex, rightIndex - leftIndex);
    }

    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{3, 2, 9, 7, 8, 6, 1, 5, 0, 4};
        ISort iSort = new MergeSort();
        iSort.sort(arrays);
        System.out.println(Arrays.toString(arrays));

    }
}
