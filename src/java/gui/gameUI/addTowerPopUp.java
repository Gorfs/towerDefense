package gui.gameUI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import misc.Debug;

import java.util.ArrayList;

import model.TowerAdvanced;
import model.TowerBasic;
import model.TowerExpert;
import model.TowerMaster;
import model.TowerUltimate;
import model.Towers;

public class addTowerPopUp extends JPopupMenu{

    private static JLabel title = new JLabel("Add Tower");
    private static JPanel towersPanel = new JPanel();
    private static JPanel towerPanel = new JPanel();

    towerAddPanel basicTowerPanel = new towerAddPanel(new TowerBasic(null));
    towerAddPanel advancedTowerPanel = new towerAddPanel(new TowerAdvanced(null));
    towerAddPanel expertTowerPanel = new towerAddPanel(new TowerExpert(null));
    towerAddPanel masterTowerPanel = new towerAddPanel(new TowerMaster(null));
    towerAddPanel ultimateTowerPanel = new towerAddPanel(new TowerUltimate(null));

    ArrayList<towerAddPanel> towers = new ArrayList<towerAddPanel>();


    public addTowerPopUp(){
        super("Add Tower");
        this.setLayout(new BorderLayout());

        towers.add(basicTowerPanel);
        towers.add(advancedTowerPanel);
        towers.add(expertTowerPanel);
        towers.add(masterTowerPanel);
        towers.add(ultimateTowerPanel);

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
        // towerAddPanel basicTowerPanel = new towerAddPanel(new TowerBasic(null));
        // towerAddPanel advancedTowerPanel = new towerAddPanel(new TowerAdvanced(null));
        // towerAddPanel expertTowerPanel = new towerAddPanel(new TowerExpert(null));
        // towerAddPanel masterTowerPanel = new towerAddPanel(new TowerMaster(null));
        // towerAddPanel ultimateTowerPanel = new towerAddPanel(new TowerUltimate(null));


        for(towerAddPanel tower: towers){
            tower.addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out(tower.getName() + " clicked");
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out("Mouse entered" + tower.getName());
                    tower.setBackground(gui.menu.MainMenu.buttonBackgroundColor);
                    
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out("Mouse exited" + tower.getName());
                    tower.setBackground(gui.menu.MainMenu.backgroundColor);
                    
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out("Mouse Released" + tower.getName());
                    
                }
                @Override
                public void mousePressed(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out("Mouse pressed" + tower.getName());
                    
                }
            });
            towersPanel.add(tower);
        }

        // towersPanel.add((new towerAddPanel(new TowerBasic(null))));
        // towersPanel.add(new towerAddPanel(new TowerAdvanced(null)));
        // towersPanel.add(new towerAddPanel(new TowerExpert(null)));
        // towersPanel.add(new towerAddPanel(new TowerMaster(null)));
        // towersPanel.add(new towerAddPanel(new TowerUltimate(null)));
        towersPanel.revalidate();
        towersPanel.repaint();

    }

  
    
}
