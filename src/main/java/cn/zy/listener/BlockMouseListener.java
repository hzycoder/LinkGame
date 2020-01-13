package cn.zy.listener;

import cn.zy.entity.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

/**
 * create by park.huang@zkteco.com 2020-01-12 17:12
 **/
public class BlockMouseListener implements MouseListener {
    private List<Block> blockList;
    private LinkedList<Block> selectBlocks;

    public BlockMouseListener(List<Block> blockList, LinkedList<Block> selectBlocks) {
        this.blockList = blockList;
        this.selectBlocks = selectBlocks;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Block block = (Block) e.getSource();
        block.printCoordinate();
        System.out.println(block.getType());

        if (selectBlocks.size() != 0) {
            Block selected = selectBlocks.get(0);
            if (selected.getType() == block.getType()) {
                System.out.println("相同");
                judgeLinked(selected.getxValue(), selected.getyValue(), block.getxValue(), block.getyValue());
                // 相同
            } else {
                System.out.println("不相同");
                selected.clearSelected();
                selected.repaint();
                block.select();
                selectBlocks.add(block);
                selectBlocks.remove(selected);
            }
        } else {

            System.out.println("!=0");
            block.select();
            selectBlocks.add(block);
        }
    }

    public boolean judgeLinked(int reserveX, int reserveY, int currX, int currY) {
        // TODO
        return false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }
}
