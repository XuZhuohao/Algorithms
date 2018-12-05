package com.yui.study.algorithms.base.sort.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据对象
 *
 * @author XuZhuohao
 * @date 2018/12/5
 */
@Setter
@Getter
public class Human implements Comparable<Human> {
    private int age;
    private String name;
    public Human(){
        super();
    }
    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int compareTo(Human o) {
        if (this.age == o.age){
            return 0;
        }else if (this.age > o.age){
            return 1;
        }else{
            return -1;
        }
    }
}
