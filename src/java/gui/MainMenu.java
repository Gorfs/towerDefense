package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.Rectangle;
import java.awt.Font;




public class MainMenu extends MouseAdapter {

    public boolean active;
    private Rectangle levelSelectBtn;
    private Rectangle settingsBtn;
    private Rectangle exitBtn; 

    private boolean lHighlighted = false;
    private boolean sHighlighted = false;
    private boolean eHighlighted = false;

    private Font font;



    public MainMenu(Game game) {
        // the panel that contains the whole menu.
        JPanel menu = new JPanel();



        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS)); // Set the layout to a vertical box layout

    }
    
    
}
