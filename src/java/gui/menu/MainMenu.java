package gui.menu;

import javax.swing.*;

import gui.Game;

import java.awt.Dimension;

import java.awt.Color;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import misc.Debug;

public class MainMenu extends JPanel implements ActionListener {
    public static boolean running = false;
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;

    public static Color backgroundColor = new Color(90, 101, 117);
    public static Color buttonBackgroundColor = new Color(120, 131, 157);

    private JButton playBtn = new JButton("Play");
    private JButton settingsBtn = new JButton("Settings");
    private JButton exitBtn = new JButton("Exit");
    private ArrayList<JButton> buttons = new ArrayList<>();

    private JPanel buttonsPanel = new JPanel();
    // private JPanel artPanel = new JPanel(); // will probably be just an empty
    // spacer Panel as the art can become the
    // background of the mainMenu

    public MainMenu() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        this.setBackground(backgroundColor);

        buttons.add(playBtn);
        buttons.add(settingsBtn);
        buttons.add(exitBtn);

        for (JButton button : buttons) {
            button.addActionListener(this);
            button.setBackground(buttonBackgroundColor);
            button.setForeground(Color.white);
            button.setFocusPainted(false);
            button.setAlignmentX(CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        }
        buttonsPanel.setMaximumSize(new Dimension(BUTTON_WIDTH, Game.HEIGHT));
        buttonsPanel.setBackground(backgroundColor);
        // Add borders to panels
        // artPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        // this.setBorder(BorderFactory.createLineBorder(Color.blue));
        // buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.green));

        // this.setAlignmentX(CENTER_ALIGNMENT);
        // this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        // artPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Game.HEIGHT / 2));
        // buttonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Game.HEIGHT /
        // 2));

        buttonsPanel.add(Box.createRigidArea(new Dimension(0, Game.HEIGHT / 2)));
        buttonsPanel.add(playBtn);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        buttonsPanel.add(settingsBtn);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        buttonsPanel.add(exitBtn);

        // adding both the panels to the main panel.
        // this.add(artPanel);
        this.add(Box.createRigidArea(new Dimension(Game.WIDTH / 2 - BUTTON_WIDTH / 2, 0)));
        this.add(buttonsPanel);
    }

    public  void actionPerformed(ActionEvent e) {
        if (e.getSource() == playBtn) {
            Debug.out("LevelSelect button pressed");
            Game.changePanel("level");
        } else if (e.getSource() == settingsBtn) {
            Debug.out("Settings button pressed");
            Game.changePanel("settings");
        } else if (e.getSource() == exitBtn) {
            Debug.out("Exit button pressed");
            System.exit(0);
        }
    }

}
