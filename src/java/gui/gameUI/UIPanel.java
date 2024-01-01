package gui.gameUI;

import javax.swing.*;

import model.GameState;

import java.awt.*;


public class UIPanel extends JPanel {
    int lives;
    int money;

    public UIPanel() {
        super();
        this.lives = GameState.getLives();
        this.money = GameState.getMoney();
        JLabel livesLabel = new JLabel("Lives: " + this.lives);
        livesLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        livesLabel.setForeground(Color.white);
        this.add(livesLabel);
        JLabel moneyLabel = new JLabel("Money: " + GameState.getMoney());
        moneyLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        moneyLabel.setForeground(Color.white);
        this.add(moneyLabel);
        this.setBackground(gui.menu.MainMenu.backgroundColor);
    }
    public void update(){
        this.lives = GameState.getLives();
        this.money = GameState.getMoney();
    }
    
}
