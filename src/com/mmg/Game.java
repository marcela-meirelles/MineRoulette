package com.mmg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Game extends JPanel implements KeyListener, Runnable{
    // Variables
    Player player1;
    Player player2;
    private float bet_player1;
    private float bet_player2;
    private float bet_total;
    private int turn;
    private GameBoard board;

    public static final int WIDTH = 400;
    public static final int HEIGHT = 630;
    private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private long startTime;
    private long elapsed;
    private boolean set;

    // Constructor
    public Game(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
    }

    // Methods
    public synchronized void start(){
        if(running) return;
        running = true;
        game = new Thread(this, "game");
        game.start();
    }

    public synchronized void stop(){
        if(!running) return;
        running = false;
        System.exit(0);
    }

    private void update(){

    }

    private void render(){
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,WIDTH, HEIGHT);
        // render board
        g.dispose();

        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.drawImage(image,0,0,null);
        g2d.dispose();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void run() {

        int fps = 0, updates = 0;
        long fpsTimer = System.currentTimeMillis();
        double nsPerUpdate = 1000000000.0/60;

        // last update time in nanoseconds
        double then = System.nanoTime();
        double unprocessed = 0;

        while(running){

            boolean shouldRender = false;
            double now = System.nanoTime();
            unprocessed += (now - then)/nsPerUpdate;
            then = now;

            // update queue
            while(unprocessed >= 1){
                updates++;
                update();
                unprocessed--;
                shouldRender = true;
            }

            // render
            if(shouldRender){
                fps++;
                render();
                shouldRender = false;
            } else {
                try{
                    Thread.sleep(1);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }


        // FPS Timer
        if(System.currentTimeMillis() - fpsTimer > 1000){
            System.out.printf("%d fps %d updates", fps, updates);
            System.out.println();
            fps = 0;
            updates = 0;
            fpsTimer += 1000;
        }
    }
}
