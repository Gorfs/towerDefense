package gui.gameUI;

import java.awt.BorderLayout;

import javax.swing.*;

import model.TowerAdvanced;
import model.TowerBasic;
import model.TowerExpert;
import model.TowerMaster;
import model.TowerUltimate;

public class addTowerPopUp extends JPopupMenu{

    private static JLabel title = new JLabel("Add Tower");
    private static JPanel towersPanel = new JPanel();
    private static JPanel towerPanel = new JPanel();

    public addTowerPopUp(){
        super("Add Tower");
        this.setLayout(new BorderLayout());

        title.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 30));
        
        this.setBackground(gui.menu.MainMenu.backgroundColor);
        
        this.add(title, BorderLayout.NORTH);

        towersPanel.setLayout(new BoxLayout(towersPanel, BoxLayout.Y_AXIS));
        towersPanel.setBackground(gui.menu.MainMenu.backgroundColor);
        // towersPanel.add(new towerAddPanel(new TowerBasic(null)));
        // towersPanel.add(new towerAddPanel(new TowerAdvanced(null)));
        // towersPanel.add(new towerAddPanel(new TowerExpert(null)));
        // towersPanel.add(new towerAddPanel(new TowerMaster(null)));
        // towersPanel.add(new towerAddPanel(new TowerUltimate(null)));
        update();


        this.add(towersPanel, BorderLayout.CENTER);
    }
    public void update(){
        towersPanel.removeAll();
        towersPanel.add(new towerAddPanel(new TowerBasic(null)));
        towersPanel.add(new towerAddPanel(new TowerAdvanced(null)));
        towersPanel.add(new towerAddPanel(new TowerExpert(null)));
        towersPanel.add(new towerAddPanel(new TowerMaster(null)));
        towersPanel.add(new towerAddPanel(new TowerUltimate(null)));
        towersPanel.revalidate();
        towersPanel.repaint();

    }
    
}
