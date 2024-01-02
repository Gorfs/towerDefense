package gui.gameUI;

import javax.swing.*;

import misc.Debug;
import model.GameState;
import model.Towers;

public class towerAddPanel extends JPanel {

    public JLabel name = new JLabel();
    public JLabel stats = new JLabel();

    public Towers tower;
    public boolean enabled = false;

    public towerAddPanel(Towers tower) {
        super();
        this.tower = tower;
        enabled = false;
        // TODO setup
        name.setText(tower.getName());
        stats.setText("DPS: " + tower.getAttack(1) / 4 + " Range: " + tower.getRange(1) + " Cost: " + tower.getPrice());
        name.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 20));
        stats.setFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 15));
        name.setForeground(java.awt.Color.white);
        stats.setForeground(java.awt.Color.white);
        this.setBackground(gui.menu.MainMenu.backgroundColor);
        this.add(name);
        this.add(Box.createRigidArea(new java.awt.Dimension(10, 0)));
        this.add(stats);
    }

    public String getName() {
        return this.tower.getName();
    }

    public void update() {
        Debug.out(GameState.getMoney() + " " + tower.getPrice());
        if (GameState.getMoney() < tower.getPrice()) {
            this.setBackground(java.awt.Color.red);
            enabled = false;
        } else {
            this.setBackground(gui.menu.MainMenu.backgroundColor);
            enabled = true;
        }
    }

}
