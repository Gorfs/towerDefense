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
import model.tower.TowerAdvanced;
import model.tower.TowerBasic;
import model.tower.TowerExpert;
import model.tower.TowerMaster;
import model.tower.TowerUltimate;
import model.tower.Towers;

public class AddTowerPopUp extends JPopupMenu {

    private static final JLabel title = new JLabel("Add Tower");
    private static final JPanel towersPanel = new JPanel();

    public TowerAddPanel basicTowerPanel = new TowerAddPanel(new TowerBasic(null));
    public TowerAddPanel advancedTowerPanel = new TowerAddPanel(new TowerAdvanced(null));
    public TowerAddPanel expertTowerPanel = new TowerAddPanel(new TowerExpert(null));
    public TowerAddPanel masterTowerPanel = new TowerAddPanel(new TowerMaster(null));
    public TowerAddPanel ultimateTowerPanel = new TowerAddPanel(new TowerUltimate(null));

    ArrayList<TowerAddPanel> towers = new ArrayList<>();

    private int cellX = 0;
    private int cellY = 0;


    /** 
     * @param x pos x
     * @param y pos y
     */
    public void setCell(int x, int y) {
        cellX = x;
        cellY = y;
    }

    public AddTowerPopUp() {
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
        for (TowerAddPanel tower : towers) {
            tower.update();
            tower.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (tower.enabled) {
                        Debug.out(tower.getName() + " clicked");
                        addTower(tower);
                        Game.updateGUI();
                        close();
                    } // close the popup after adding a model.tower
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    Debug.out("Mouse entered" + tower.getName());
                    if (tower.enabled) {
                        tower.setBackground(gui.menu.MainMenu.buttonBackgroundColor);
                    } else {
                        tower.setBackground(java.awt.Color.red.darker());
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    Debug.out("Mouse exited" + tower.getName());
                    tower.setBackground(gui.menu.MainMenu.backgroundColor); // default it if the update function fails.
                    tower.update();

                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Debug.out("Mouse Released" + tower.getName());

                }

                @Override
                public void mousePressed(MouseEvent e) {
                    Debug.out("Mouse pressed" + tower.getName());

                }
            });
            towersPanel.add(tower);
        }
        towersPanel.revalidate();
        towersPanel.repaint();

    }

    /**
     * @param tower new tower
     */
    public void addTower(TowerAddPanel tower) {
        Towers gameTower = tower.tower;
        gameTower.setPos(new IntCoordinates(cellX, cellY));
        GameState.addTower(gameTower, cellX, cellY);
    }

    public void close() {
        this.setVisible(false);
    }

}
