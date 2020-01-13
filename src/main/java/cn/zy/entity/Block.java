package cn.zy.entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.UUID;

/**
 * create by park.huang@zkteco.com 2020-01-12 15:12
 **/
public class Block extends JButton {
    private int xValue;
    private int yValue;
    private int type;
    private String uuid;

    public Block() {
    }

    public Block(Color color) {
        this.setBackground(color);
        this.setType(color.getRGB());
        this.uuid = UUID.randomUUID().toString();
        this.setBorder(null);
    }

    public Block(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.setText("(" + xValue + "," + yValue + ")");
        this.setFont(new Font("Serif", Font.PLAIN, 10));
    }

    public void select() {
        this.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
    }

    public void clearSelected() {
        this.setBorder(null);
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
