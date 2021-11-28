package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //настройки экрана
    final int OriginalTileSize = 32; // 16x16 tile // 16
    final int Scale =  2; // 12 //3 - по умолчанию

   public final int tilesize = OriginalTileSize * Scale; //48x48 tile
   public final int maxScreenCol = 16; // 16
    public final int maxScreenRow = 12; // 12
    public final int screenWidth = tilesize * maxScreenCol; // 768 pixels
    public final int screenHeight = tilesize *maxScreenRow; //576 pixels

    //WORLD SETTINGS

    public  final int maxWorldCol = 50;
    public  final int maxWorldRow = 50;
    public  final int worldWidth = tilesize * maxWorldCol;
    public  final int worldHeight = tilesize * maxWorldRow;

    //FPS
    int FPS = 60;

    TileManager tileM  =new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
   public Player player = new Player(this,keyH);

    // set players default position
   // int playerX = 100;
   // int playerY = 100;
    //int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    /*public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            long currentTime = System.nanoTime();
            System.out.println("Current Time:" + currentTime);



            // update information auch as character positions
            update();
            //Draw the screen with the updated information
            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }*/

    public void run() {

        double drawIntetval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawIntetval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public  void update(){

player.update();



    }







    public  void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        tileM.draw(g2);

        player.draw(g2);

        g2.dispose();
    }
}
