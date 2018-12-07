package com.yui.study.algorithms.base.util;

import java.lang.reflect.Method;

/**
 * 数据工具类
 *
 * @author XuZhuohao
 * @date 2018/12/7
 */
public class DataUtil {
    /**
     * 创建int数组
     * @param length 数组长度
     * @param rangeL 数组左边界(最小)
     * @param rangeR 数组有边界(最大)
     * @return int数组
     */
    public static Integer[]  createIntegerArray(int length, int rangeL, int rangeR){
        if (rangeL > rangeR){
            return null;
        }
        Integer[] arr = new Integer[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

    /**
     * 生成一个近乎有序的数组
     * 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数
     * swapTimes定义了数组的无序程度:
     * swapTimes == 0 时, 数组完全有序
     * swapTimes 越大, 数组越趋向于无序
     * @param n  数组大小
     * @param swapTimes 数组无序程度
     * */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes){
        Integer[] arr = new Integer[n];
        // 生成顺序数组
        for( int i = 0 ; i < n ; i ++ ) {
            arr[i] = i;
        }
        // 随机交换数据
        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }


    public static void testSortUseTime(String className, String sortMethodName, Comparable[] arr){

        try {
            Class sortClass = Class.forName(className);
            Method sortMethod = sortClass.getMethod(sortMethodName, new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(sortClass, params);
            long endTime = System.currentTimeMillis();
            assert isSorted( arr );
            if (!isSorted(arr)){
                throw new RuntimeException(sortClass.getSimpleName() + "." + sortMethodName + "排序结果错误！！");
            }
            System.out.println( sortClass.getSimpleName() + "." + sortMethodName + " : " + (endTime-startTime) + "ms" );
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 校验一个数组是否是顺序的
     * @param arr 数组
     * @return 如果是顺序的返回 true, 否则返回 false
     */
    public static boolean isSorted(Comparable[] arr){
        for (int i=0; i < arr.length - 1; i++){
            if (0 < arr[i].compareTo(arr[i + 1])){
                return false;
            }
        }
        return true;
    }
}

