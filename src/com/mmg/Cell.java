package com.mmg;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Cell {
    // true if it has a bomb, false if it doesn't
    private boolean hasBomb     = false;
    private boolean isClicked   = false;

    public static final int WIDTH = 80;
    public static final int HEIGHT = 80;

    private BufferedImage cellImage;
    private Color background;
    private Color text;
    private int x;
    private int y;

    public Cell(boolean hasBomb, int x, int y, boolean isClicked){
        this.hasBomb = hasBomb;
        this.isClicked = isClicked;
        this.x = x;
        this.y = y;
       // cellImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //drawImage();
    }

    public Cell(boolean hasBomb, boolean isClicked){
        this.hasBomb = hasBomb;
        this.isClicked = isClicked;

        //drawCell();
        //cellImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        //drawImage();
    }

    @Override
    public String toString() {
        if(hasBomb) {
            return "x";
        }else{
            return "o";
        }
    }

    private void drawCell() {
        background = new Color(0xe9e9e9);
        text = new Color(0x0000000);

        Graphics g = cellImage.createGraphics();
        g.create(40,40,40,40);
    }

    private void drawImage(){
        Graphics2D g = (Graphics2D) cellImage.getGraphics();
        //g.create(40,40,40,40);
        if(hasBomb){
            background = new Color(0xe9e9e9);
            text = new Color(0x000000);
        }else{
            background = new Color(0xe6daab);
            text = new Color(0x000000);
        }
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public boolean isHasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public BufferedImage getCellImage() {
        return cellImage;
    }

    public void setCellImage(BufferedImage cellImage) {
        this.cellImage = cellImage;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getText() {
        return text;
    }

    public void setText(Color text) {
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
