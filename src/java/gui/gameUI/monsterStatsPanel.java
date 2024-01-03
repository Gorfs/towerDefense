package gui.gameUI;

import javax.swing.*;

public class monsterStatsPanel extends JPanel {

    private static int health;
    private static JLabel healthBar = new JLabel("Health: " + health);



    public monsterStatsPanel( int health) {
        super();
        healthBar.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 10));
        healthBar.setForeground(java.awt.Color.white);
        healthBar.setBackground(gui.menu.MainMenu.backgroundColor.darker());
        // healthBar.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        healthBar.setText("Health: " + health); 
        this.setBackground(gui.menu.MainMenu.backgroundColor.darker());
        this.add(healthBar);
    }

        
}
