package gui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Window;

public class Game extends Canvas implements Runnable {
    public final static int WIDTH = 400;
    public final static  int HEIGHT = 400;

    public boolean running = false;
    private Thread gameThread; // the Thread where the entire game is running.

    private GamePanel gamePanel;
    private GameWindow gameWindow;

    private MainMenu menu;


    // !! -> some code came from https://github.com/AzizZayed/Simple-Pong I used his code to learn how swing works.


    public Game() {
        canvasSetup();

        // TODO make game window

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
        while(running) {
            update();
            render();
        }
    }
}
