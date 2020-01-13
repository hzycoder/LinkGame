package cn.zy.frame;

import cn.zy.entity.Block;
import cn.zy.listener.BlockMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * create by park.huang@zkteco.com 2020-01-12 14:30
 **/
public class MainFrame extends JFrame {

    /**
     * the width of game frame
     */
    public static final int GAME_FRAME_WIN_WIDTH = 1000;
    /**
     * the height of game frame
     */
    public static final int GAME_FRAME_WIN_HEIGHT = 800;

    public static final int BLOCK_PANEL_WIDTH = 700;
    public static final int BLOCK_PANEL_HEIGHT = 400;
    public static final int BLOCK_PANEL_X = 50;
    public static final int BLOCK_PANEL_Y = 150;


    /**
     * selected blocks during game
     */
    private LinkedList<Block> selectBlocks = new LinkedList<>();


    public static final int BLOCK_LENGTH = 40;

    public static ConcurrentLinkedQueue<Block> blockQueue = new ConcurrentLinkedQueue<>();


    public static final LinkedList<Color> COLORS = new LinkedList<>();
    static {
        COLORS.add(Color.ORANGE);
        COLORS.add(Color.BLUE);
        COLORS.add(Color.BLACK);
        COLORS.add(Color.red);
        COLORS.add(Color.cyan);
        COLORS.add(Color.pink);
        COLORS.add(Color.YELLOW);
    }

    JPanel contentPanel = new JPanel();

    JPanel leftPanel = new JPanel();
    JPanel blockPanel = new JPanel();

    JPanel rightPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public void start() {
        this.setSize(GAME_FRAME_WIN_WIDTH, GAME_FRAME_WIN_HEIGHT);
        this.setTitle("Link Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(contentPanel);

        contentPanel.setLayout(null);

        leftPanel.setBounds(0, 0, 800, 600);
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        leftPanel.setLayout(null);
        contentPanel.add(leftPanel);

        blockPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        blockPanel.setBounds(BLOCK_PANEL_X, BLOCK_PANEL_Y, BLOCK_PANEL_WIDTH, BLOCK_PANEL_HEIGHT);
        blockPanel.setLayout(null);

        leftPanel.add(blockPanel);

        rightPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        rightPanel.setBounds(rightPanel.getWidth(), 0, contentPanel.getWidth() - leftPanel.getWidth(), leftPanel.getHeight());
        contentPanel.add(rightPanel);

        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        bottomPanel.setBounds(0, 600, contentPanel.getWidth(), contentPanel.getHeight()-leftPanel.getHeight());
        contentPanel.add(bottomPanel);
        generateBlockList();
        new Thread(() -> {
            init();
        }).start();
    }

    private void init() {
        List<Block> blockList = new ArrayList<>();
        int count = 0;
        int xValue = 0;
        int yValue = 0;
        int xBorder = getRoundBlockLength(blockPanel.getWidth(), BLOCK_LENGTH);
        int yBorder = getRoundBlockLength(blockPanel.getHeight(), BLOCK_LENGTH);
        for (int x = 0; x < xBorder; x += BLOCK_LENGTH) {
            for (int y = 0; y < yBorder; y += BLOCK_LENGTH) {
                Block block = blockQueue.poll();
                block.setxValue(xValue);
                block.setyValue(yValue);
                block.setBounds(x, y, BLOCK_LENGTH, BLOCK_LENGTH);
                count += 1;
                blockPanel.add(block);
                blockList.add(block);
                this.repaint();
                yValue++;
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            xValue++;
            yValue = 0;
        }
        for (Block block : blockList) {
            block.addMouseListener(new BlockMouseListener(blockList, selectBlocks));
        }
    }

    public ConcurrentLinkedQueue<Block> generateBlockList() {
        LinkedList<Block> blockList = new LinkedList<>();
        int blockCount = countBlocks();
        int typeSize = COLORS.size();
        for (int i = 0; i < blockCount; i++) {
            int random = (int) (typeSize * Math.random());
            Color color = COLORS.get(random);
            blockList.add(new Block(color));
            blockList.add(new Block(color));
            i++;
        }
        Collections.shuffle(blockList);
        for (Block block : blockList) {
            blockQueue.add(block);
        }
        return blockQueue;
    }

    public int countBlocks() {
        return (blockPanel.getWidth() / BLOCK_LENGTH) * (blockPanel.getHeight()/BLOCK_LENGTH);
    }

    public static int getRoundBlockLength(int number, int length) {
        if (number % length == 0) {
            return number;
        } else {
            return (number - (number % length));
        }
    }
}
