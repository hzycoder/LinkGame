package cn.zy.entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * create by park.huang@zkteco.com 2020-01-12 15:12
 **/
public class Block extends JButton {
    int xValue;
    int yValue;

    public Block() {
    }

    public Block(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.setText("(" + xValue + "," + yValue + ")");
        this.setFont(new Font("Serif", Font.PLAIN, 10));
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public void printCoordinate() {
        System.out.println("x:" + xValue + "  y:" + yValue);
    }
}
