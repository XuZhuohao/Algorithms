package com.yui.study.algorithms.base.sort;

import com.alibaba.fastjson.JSON;
import com.yui.study.algorithms.base.sort.dto.Human;

/**
 * 选择排序
 *
 * @author XuZhuohao
 * @date 2018/12/5
 */
public class SelectionSort {
    public static Comparable[] sort(Comparable[] datas){
        for (int i = 0; i < datas.length; i++) {
            int largerIndex = i;
            Comparable temp;
            for (int j = i; j < datas.length; j++){
                if (datas[largerIndex].compareTo(datas[j]) == -1){
                    largerIndex = j;
                }
            }
            temp = datas[i];
            datas[i] = datas[largerIndex];
            datas[largerIndex] = temp;
        }
        return datas;
    }

    public static void main(String[] args) {
        Human[] humans = {new Human(12,"t1"), new Human(7,"t2"),
                new Human(14,"t3"),new Human(3,"t4"),
                new Human(12,"t5")};
        System.out.println(JSON.toJSONString(humans));
        System.out.println(JSON.toJSONString(SelectionSort.sort(humans)));
    }
}
