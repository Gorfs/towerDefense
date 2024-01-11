package gui.menu;

import javax.swing.*;

import gui.Game;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import misc.Debug;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingsMenu extends JPanel implements ActionListener {
    private static final Color backgroundColor = MainMenu.backgroundColor;
    private static final Color buttonBackgroundColor = MainMenu.buttonBackgroundColor;

    private final JButton debugBtn = new JButton(String.valueOf(Debug.isDebugging()));
    private final JButton backBtn = new JButton("Back");

    public SettingsMenu() {
        super();
        this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.setLayout(new BorderLayout());
        this.setBackground(backgroundColor);
        Color backgroundColor = new Color(90, 101, 117);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(backgroundColor);
        menuPanel.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));

        JLabel title = new JLabel("Settings:", SwingConstants.CENTER);
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setForeground(Color.white);
        title.setFont(title.getFont().deriveFont(30.0f));

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.setBackground(backgroundColor);

        JPanel debugPanel = new JPanel();
        debugPanel.setLayout(new BoxLayout(debugPanel, BoxLayout.X_AXIS));
        debugPanel.setBackground(backgroundColor);

        JLabel debugLabel = new JLabel("Debug mode: ");
        debugLabel.setForeground(Color.white);
        debugPanel.add(debugLabel);
        debugBtn.setBackground(Debug.isDebugging() ? Color.green : Color.red);
        int BUTTON_WIDTH = 100;
        int BUTTON_HEIGHT = 30;
        debugBtn.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        debugBtn.addActionListener(this);
        debugPanel.add(debugBtn);
        
        backBtn.setBackground(buttonBackgroundColor);
        backBtn.setForeground(Color.white);
        backBtn.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        backBtn.setAlignmentX(CENTER_ALIGNMENT);

        backBtn.addActionListener(this);

        menuPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        menuPanel.add(debugPanel);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        menuPanel.add(backBtn);

        this.add(title, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
    }
    
    /** 
     * @param e action listener
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == debugBtn) {
            Debug.out("Switching debug mode : " + Debug.isDebugging());
            Debug.toggleDebugging();
            debugBtn.setBackground(Debug.isDebugging() ? Color.green : Color.red);
            debugBtn.setText(String.valueOf(Debug.isDebugging()));
        }
        else if (e.getSource() == backBtn) {
            Game.changePanel("main");
        }
    }

}
