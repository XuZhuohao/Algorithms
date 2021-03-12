package com.yui.study.algorithms.base.util;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * @author XuZhuohao
 * @date 2021/3/11
 */
public class StdDrawUtil {
    private static final double width = 3;
    private static final double x = 3;
    private static final double y = 3;

    static {
        StdDraw.setXscale(1, 100);
        StdDraw.setYscale(1, 20);
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(Color.red);
    }
    public static <T extends Number> void drawHistogram(T[] data){
        StdDraw.clear();
        double tempX = StdDrawUtil.x;
        for (T datum : data) {
            StdDraw.rectangle(tempX, StdDrawUtil.y, StdDrawUtil.width, datum.doubleValue());
            tempX += StdDrawUtil.width + 5;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
