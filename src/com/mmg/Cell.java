package com.mmg;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cell {
    // true if it has a bomb, false if it doesn't
    private boolean hasBomb = false;

    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;

    private BufferedImage cellImage;
    private Color background;
    private Color text;
    private int x;
    private int y;

    public Cell(boolean hasBomb, int x, int y){
        this.hasBomb = true; //set to random
        this.x = x;
        this.y = y;
        cellImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        drawImage();
    }

    private void drawImage(){
        Graphics2D g = (Graphics2D) cellImage.getGraphics();
        if(hasBomb == true){
            background = new Color(0xe9e9e9);
            text = new Color(0x000000);
        }else{
            background = new Color(0xe6daab);
            text = new Color(0x000000);
        }
    }
}
