package gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
public class Game extends Canvas implements Runnable {
    public final static int WIDTH = 400;
    public final static  int HEIGHT = 400;

    public boolean running = false;
    private Thread gameThread; // the Thread where the entire game is running.

    private GamePanel gamePanel;
    private GameWindow gameWindow;

    private MainMenu menu;
    int frames= 0 ;


    // !! -> some code came from https://github.com/AzizZayed/Simple-Pong I used his code to learn how swing works.


    public Game() {
        canvasSetup();

        // Create game window
        gameWindow = new GameWindow(this);
        this.addMouseListener(menu);
        this.addMouseMotionListener(menu);
        this.setFocusable(true);
        initialize();
    }

    private void initialize() {
        menu = new MainMenu(this);
    }

    private void canvasSetup() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));

    }
    @Override
    public void run() {
        this.requestFocus();
        long previousTime = System.nanoTime();
        long timeToPassBetweenTicks = 1000000000 / 60; // 60 should draw a new frame 60 times per second.

        while(running) {
            long currentTime = System.nanoTime();
            if(currentTime - previousTime >= timeToPassBetweenTicks){
                // draw a new frame + update the game
                previousTime = currentTime;
                frames++;
                update(); // update the game logic
                render(); // updated the game graphics
            }
        }
        stop(); // close the window
    }

    public synchronized void start(){

        // since this impliments runnable, we can pass this as a constructor to thread and overide it's runnable command, therefore we can run the game from the thread.
        gameThread = new Thread(this);
        gameThread.start();
        running = true;

    }
    public void stop(){
        // stop the game without crashing the pc.
        try{
            gameThread.join();
            running = false;
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void render(){
        // buffer is basically a canvas we draw on, so we can't draw on the frame itself.
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        drawBackground(g);
        menu.draw(g);

        buffer.show();
    }
    private void drawBackground(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

    }

    private void update() {
        System.out.println("the game has updated, yay!");
        
    }
}
