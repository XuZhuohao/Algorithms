package com.yui.study.algorithms.base.sort;

/**
 * 排序接口
 *
 * @author XuZhuohao
 * @date 2021/3/11
 */
public interface ISort {
    /**
     *
     * @param data
     * @param <T>
     */
    <T extends Comparable<? super T>> void sort(T[] data);

    default void sort2(Integer[] data){
        System.out.println("undefined");
    }
}
