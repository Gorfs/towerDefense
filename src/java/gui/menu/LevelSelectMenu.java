package gui.menu;

import javax.swing.*;
import java.awt.color.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;

public class LevelSelectMenu extends JPanel implements ActionListener  {
    private static JLabel title = new JLabel("Select a level:", SwingConstants.CENTER);
    private static JPanel menuPanel = new JPanel();
    public LevelSelectMenu() {
        super();
        this.setLayout(new BorderLayout());
        this.setBackground(MainMenu.backgroundColor);

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBackground(MainMenu.backgroundColor);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 30))); // padding between top and levels

        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(title.getFont().deriveFont(30.0f));
        title.setForeground(Color.white);


        this.add(title, BorderLayout.NORTH);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        for (LevelPanel levelPanel : createLevelPanels(TermLevelNums())) {
            menuPanel.add(levelPanel);
            levelPanel.playBtn.addActionListener(this);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        this.add(menuPanel, BorderLayout.CENTER);
    }

    public ArrayList<LevelPanel> createLevelPanels(int numLevels) {
        ArrayList<LevelPanel> levelPanels = new ArrayList<>();
        for (int i = 0; i < numLevels; i++) {
            levelPanels.add(new LevelPanel(i));
        }
        return levelPanels;
    }

    public void actionPerformed(ActionEvent e) {
        // TODO set the action to start the level in the main game panel.
        System.out.println("Action performed" + e.getSource());
    }

    public static int TermLevelNums(){
        // this is the menu that is called when we want to choose a level.
        int counter = 0;
        final File folder = new File("src/resources/map");
        for(final File fileEntry: folder.listFiles()){
            counter++;
        }
        System.out.println("\n\n Votre Choix: ");
        return counter;
    }   
}
