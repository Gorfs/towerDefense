package gui.gameUI;

import javax.swing.*;

import model.Towers;


public class towerAddPanel extends JPanel {


    Towers tower;

    public towerAddPanel(Towers tower) {
        super();
        this.tower = tower;
        JLabel name = new JLabel(tower.getName());
        // TODO setup 
        JLabel stats = new JLabel("DPS: " + tower.getAttack(1) / 4 + " Range: " + tower.getRange(1) + " Cost: " + tower.getPrice());
        name.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 20));
        stats.setFont(new java.awt.Font("Serif", java.awt.Font.PLAIN, 15));
        name.setForeground(java.awt.Color.white);
        stats.setForeground(java.awt.Color.white);
        this.setBackground(gui.menu.MainMenu.backgroundColor);
        this.add(name);
        this.add(Box.createRigidArea(new java.awt.Dimension(10, 0)));
        this.add(stats);
    }
    public String getName(){
        return this.tower.getName();
    }

    
}
