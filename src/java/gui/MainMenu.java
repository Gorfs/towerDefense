package gui;

import javax.swing.*;
import java.awt.Dimension;

import java.awt.BorderLayout;
import java.awt.Color;

public class MainMenu extends JPanel {
    public static boolean running = false;

    private Color backgroundColor = new Color(90, 101, 117);
    private Color buttonBackgroundColor = new Color(100, 111, 127);

    private JButton playBtn = new JButton("Play");
    private JButton settingsBtn = new JButton("Settings");
    private JButton exitBtn = new JButton("Exit");

    private JPanel buttonsPanel = new JPanel();
    private JPanel artPanel = new JPanel(); // will probably be just an empty spacer Panel as the art can become the
                                            // background of the mainMenu

    public MainMenu() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.P_AXIS));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        this.setBackground(backgroundColor);
        playBtn.setBackground(buttonBackgroundColor);
        settingsBtn.setBackground(buttonBackgroundColor);
        exitBtn.setBackground(buttonBackgroundColor);
        
        // Add borders to panels
        artPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
        buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.green));
        

        this.setAlignmentX(CENTER_ALIGNMENT);
        this.add(artPanel, BoxLayout.);
        this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        artPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, Game.HEIGHT / 2));
        buttonsPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, Game.HEIGHT / 2));

        buttonsPanel.add(playBtn);
        buttonsPanel.add(settingsBtn);
        buttonsPanel.add(exitBtn);
        this.add(buttonsPanel);
    }

}
