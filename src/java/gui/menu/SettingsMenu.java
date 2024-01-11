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
    private static Color backgroundColor = MainMenu.backgroundColor;
    private static Color buttonBackgroundColor = MainMenu.buttonBackgroundColor;

    private static int BUTTON_WIDTH = 100;
    private static int BUTTON_HEIGHT = 30;

    private JPanel menuPanel = new JPanel();
    private JLabel title = new JLabel("Settings:", SwingConstants.CENTER);
    private JPanel settingsPanel = new JPanel();
    private JPanel debugPanel = new JPanel();
    private JButton debugBtn = new JButton(String.valueOf(Debug.isDebugging()));
    private JLabel debugLabel = new JLabel("Debug mode: ");
    private JButton backBtn = new JButton("Back");

    public SettingsMenu() {
        super();
        this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        this.setLayout(new BorderLayout());
        this.setBackground(backgroundColor);
        Color backgroundColor = new Color(90, 101, 117);

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(backgroundColor);
        menuPanel.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        // menuPanel.setBorder(BorderFactory.createLineBorder(Color.red)); // Add border

        title.setAlignmentX(CENTER_ALIGNMENT);
        // title.setBorder(BorderFactory.createLineBorder(Color.black));
        title.setForeground(Color.white);
        title.setFont(title.getFont().deriveFont(30.0f));

        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.setBackground(backgroundColor);

        debugPanel.setLayout(new BoxLayout(debugPanel, BoxLayout.X_AXIS));
        debugPanel.setBackground(backgroundColor);
        // debugPanel.setBorder(BorderFactory.createLineBorder(Color.black)); // Add
        // border

        debugLabel.setForeground(Color.white);
        debugPanel.add(debugLabel);
        debugBtn.setBackground(Debug.isDebugging() ? Color.green : Color.red);
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
        // MenuPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        this.add(menuPanel, BorderLayout.CENTER);
        // MenuPanel.add(Box.createRigidArea(new Dimension(0, 50)));

    }

    /**
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == debugBtn) {
            Debug.out("Switching debug mode : " + String.valueOf(Debug.isDebugging()));
            Debug.toggleDebugging();
            debugBtn.setBackground(Debug.isDebugging() ? Color.green : Color.red);
            debugBtn.setText(String.valueOf(Debug.isDebugging()));
        } else if (e.getSource() == backBtn) {
            Game.changePanel("main");
        }
    }

}
