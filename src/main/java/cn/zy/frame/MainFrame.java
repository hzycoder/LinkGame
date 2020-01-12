package cn.zy.frame;

import cn.zy.entity.Block;
import cn.zy.listener.BlockMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * create by park.huang@zkteco.com 2020-01-12 14:30
 **/
public class MainFrame extends JFrame {

    /**
     * the width of game frame
     */
    public static final int GAME_FRAME_WIN_WIDTH = 800;
    /**
     * the height of game frame
     */
    public static final int GAME_FRAME_WIN_HEIGHT = 600;

    public static final int BLOCK_LENGTH = 80;

    JPanel leftPanel = new JPanel();
    JPanel blockPanel = new JPanel();

    public void start() {
        this.setLayout(null);
        this.setSize(GAME_FRAME_WIN_WIDTH, GAME_FRAME_WIN_HEIGHT);
        this.setTitle("Link Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        leftPanel.setBounds(0, 0, 600, 600);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        panel.setBackground(Color.white);
        this.add(leftPanel);

        blockPanel.setBorder(50,100);


        init();
    }

    private void init() {
        List<Block> blockList = new ArrayList<>();
        int count = 0;
        int xValue = 0;
        int yValue = 0;
        for (int x = 50; x <= 500; x += BLOCK_LENGTH) {
            for (int y = 100; y <= 400; y += BLOCK_LENGTH) {
                Block block = new Block(xValue, yValue);
                block.setBackground(Color.darkGray);
                block.setForeground(Color.white);
                block.setBounds(x, y, BLOCK_LENGTH, BLOCK_LENGTH);
                count += 1;
                leftPanel.add(block);
                blockList.add(block);
                System.out.println("add");
                yValue++;
            }
            xValue++;
        }
        for (Block block : blockList) {
            block.addMouseListener(new BlockMouseListener(blockList));
        }
        System.out.println(count);
        this.repaint();
    }
}
