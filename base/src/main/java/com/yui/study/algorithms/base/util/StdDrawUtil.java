package com.yui.study.algorithms.base.util;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * @author XuZhuohao
 * @date 2021/3/11
 */
public class StdDrawUtil {
    public static final double width = 3;

    static {
        StdDraw.setXscale(1, 1);
        StdDraw.setYscale(1, 1);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(Color.red);
    }
    public static <T extends Number> void drawHistogram(T[] data){
        StdDraw.clear();

        StdDraw.circle(0, 0.2, 0.1);
        for (T datum : data) {
//            StdDraw.rectangle();
        }
    }
}
