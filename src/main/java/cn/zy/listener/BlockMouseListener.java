package cn.zy.listener;

import cn.zy.entity.Block;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * create by park.huang@zkteco.com 2020-01-12 17:12
 **/
public class BlockMouseListener implements MouseListener {
    private List<Block> blockList;

    public BlockMouseListener(List<Block> blockList) {
        this.blockList = blockList;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Block block = (Block) e.getSource();
        block.printCoordinate();
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
