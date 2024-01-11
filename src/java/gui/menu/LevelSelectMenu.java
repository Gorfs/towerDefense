package gui.menu;

import javax.swing.*;

import gui.Game;

import java.util.ArrayList;
import java.util.Scanner; // Added import statement for Scanner

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;

import misc.Debug;

public class LevelSelectMenu extends JPanel implements ActionListener {
    private static JLabel title = new JLabel("Select a level:", SwingConstants.CENTER);
    private static JPanel menuPanel = new JPanel();
    private static ArrayList<String> levelNames = new ArrayList<>();
    private static ArrayList<Integer> levelWaves = new ArrayList<>();
    private static ArrayList<LevelPanel> levelPanels = new ArrayList<>();

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
        TermLevelNums();
        levelPanels = createLevelPanels(levelNames.size(), levelWaves);
        for (LevelPanel levelPanel : levelPanels) {
            menuPanel.add(levelPanel);
            levelPanel.playBtn.addActionListener(this);
            menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        this.add(menuPanel, BorderLayout.CENTER);
    }

    /**
     * @param numLevels
     * @param levelWaves
     * @return ArrayList<LevelPanel>
     */
    public ArrayList<LevelPanel> createLevelPanels(int numLevels, ArrayList<Integer> levelWaves) {
        ArrayList<LevelPanel> levelPanels = new ArrayList<>();
        for (int i = 0; i < numLevels; i++) {
            levelPanels.add(new LevelPanel(i, levelWaves.get(i)));
        }
        return levelPanels;
    }

    /**
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        for (LevelPanel levelPanel : levelPanels) {
            if (e.getSource() == levelPanel.playBtn) {
                Debug.out("Play button pressed");
                Game.setlevel(levelPanel.getNum());
                Game.start();
                // try {Thread.sleep(1000);} catch (InterruptedException e1)
                // {e1.printStackTrace();}
                Game.changePanel("game");
            }
        }
        System.out.println("Action performed" + e.getSource());
    }

    public static void TermLevelNums() {
        // this is the menu that is called when we want to choose a level.
        final File folder = new File("src/resources/map");
        for (final File fileEntry : folder.listFiles()) {
            Debug.out(fileEntry.getName());
            levelNames.add(fileEntry.getName());
            File waveFile = new File("src/resources/mapInfo/" + fileEntry.getName());

            try (Scanner scanner = new Scanner(waveFile)) {
                if (!scanner.hasNextLine()) {
                    levelWaves.add(-1);
                } else {
                    while (scanner.hasNextLine()) {
                        String waveData = scanner.nextLine();
                        levelWaves.add(waveData.split(";").length);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
