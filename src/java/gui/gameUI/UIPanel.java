package gui.gameUI;

import javax.swing.*;

import misc.Debug;
import model.Player;

import java.awt.*;

public class UIPanel extends JPanel {
    int lives;
    int money;

    private JLabel livesLabel = new JLabel("Health: " + lives);
    private JLabel moneyLabel = new JLabel("Money: " + Player.INSTANCE.getMoney());

    public UIPanel() {
        super();
        this.lives = Player.INSTANCE.getHealth()[1];
        this.money = Player.INSTANCE.getMoney();
        livesLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        livesLabel.setForeground(Color.white);
        livesLabel.setBackground(gui.menu.MainMenu.backgroundColor.darker());
        livesLabel.setOpaque(true);
        livesLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        this.add(livesLabel);
        moneyLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        moneyLabel.setForeground(Color.white);
        moneyLabel.setBackground(gui.menu.MainMenu.backgroundColor.darker());
        moneyLabel.setOpaque(true);
        moneyLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        this.add(Box.createRigidArea(new Dimension(20, 0)));
        this.add(moneyLabel);
        this.setBackground(gui.menu.MainMenu.backgroundColor);
    }

    public void update() {
        Debug.out("UI updated");
        this.lives = Player.INSTANCE.getHealth()[1];
        livesLabel.setText("Health: " + this.lives);
        this.money = Player.INSTANCE.getMoney();
        moneyLabel.setText("Money: " + this.money);
    }

}
