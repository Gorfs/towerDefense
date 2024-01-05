package gui.gameUI;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

import geometry.IntCoordinates;
import gui.Game;
import misc.Debug;

import java.util.ArrayList;

import model.GameState;
import model.TowerAdvanced;
import model.TowerBasic;
import model.TowerExpert;
import model.TowerMaster;
import model.TowerUltimate;
import model.Towers;
import config.*;

public class addTowerPopUp extends JPopupMenu {

    private static JLabel title = new JLabel("Add Tower");
    private static JPanel towersPanel = new JPanel();
    private static JPanel towerPanel = new JPanel();

    public towerAddPanel basicTowerPanel = new towerAddPanel(new TowerBasic(null));
    public towerAddPanel advancedTowerPanel = new towerAddPanel(new TowerAdvanced(null));
    public towerAddPanel expertTowerPanel = new towerAddPanel(new TowerExpert(null));
    public towerAddPanel masterTowerPanel = new towerAddPanel(new TowerMaster(null));
    public towerAddPanel ultimateTowerPanel = new towerAddPanel(new TowerUltimate(null));

    ArrayList<towerAddPanel> towers = new ArrayList<towerAddPanel>();

    private int cellX = 0;
    private int cellY = 0;
    private Slot cell;

    public void setCell(int x, int y) {
        cellX = x;
        cellY = y;
        this.cell = (Slot) GameState.getMap()[y][x];
    }

    public addTowerPopUp() {
        super("Add Tower");
        this.setLayout(new BorderLayout());
        this.setBorder(new LineBorder(gui.menu.MainMenu.buttonBackgroundColor, 20, true));

        towers.add(basicTowerPanel);
        towers.add(advancedTowerPanel);
        towers.add(expertTowerPanel);
        towers.add(masterTowerPanel);
        towers.add(ultimateTowerPanel);

        title.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 30));

        this.setBackground(gui.menu.MainMenu.buttonBackgroundColor);

        this.add(title, BorderLayout.NORTH);

        towersPanel.setLayout(new BoxLayout(towersPanel, BoxLayout.Y_AXIS));
        towersPanel.setBackground(gui.menu.MainMenu.buttonBackgroundColor);
        update();

        this.add(towersPanel, BorderLayout.CENTER);
    }

    public void update() {
        towersPanel.removeAll();
        for (towerAddPanel tower : towers) {
            tower.update();
            tower.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    if (tower.enabled) {
                        Debug.out(tower.getName() + " clicked");
                        addTower(e, tower);
                        Game.updateGUI();
                        close();
                    } // close the popup after adding a tower
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out("Mouse entered" + tower.getName());
                    if (tower.enabled) {
                        tower.setBackground(gui.menu.MainMenu.buttonBackgroundColor);
                    } else {
                        tower.setBackground(java.awt.Color.red.darker());
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // TODO Auto-generated method stub
                    Debug.out("Mouse exited" + tower.getName());
                    tower.setBackground(gui.menu.MainMenu.backgroundColor); // default it if the update function fails.
                    tower.update();

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

    public void removeTower(MouseEvent e) {
        GameState.removeTower(cellX, cellY);
    }

    public void addTower(MouseEvent e, towerAddPanel tower) {
        Towers gameTower = tower.tower;
        gameTower.setPos(new IntCoordinates(cellX, cellY));
        GameState.addTower(gameTower, cellX, cellY);
    }

    public void close() {
        this.setVisible(false);
    }

}
