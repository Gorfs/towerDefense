package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.Graphics2D;




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
        active = true;
        game.start();

        int x, y, w,h;
        w = 300;
        h = 150;

        y = Game.HEIGHT / 3 - h / 2;
        x = Game.WIDTH / 2 - w / 2;;

        levelSelectBtn = new Rectangle(x, y, w, h);

        y = Game.HEIGHT * 2 / 3 - h / 2;
        settingsBtn = new Rectangle(x, y, w, h);

        y = Game.HEIGHT * 3 / 3 - h / 2; // could be just game.Height but I kept the *3/3 to make it clear rather than optimised
        exitBtn = new Rectangle(x, y, w, h);

        font = new Font("Roboto", Font.PLAIN, 50);    
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setFont(font);

        // adding the colours to the backgrounds of the buttons
        if(lHighlighted){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.BLACK);
        }
        g2d.fill(levelSelectBtn);
        if(sHighlighted){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.BLACK);
        }
        g2d.fill(settingsBtn);

        if(eHighlighted){
            g.setColor(Color.white);
        }else{
            g.setColor(Color.BLACK);
        }
        g2d.fill(exitBtn);

        // borders
        g2d.setColor(Color.white);
        g2d.draw(levelSelectBtn);
        g2d.draw(settingsBtn);
        g2d.draw(exitBtn);

		int strWidth, strHeight;

		// Play Button text
		strWidth = g.getFontMetrics(font).stringWidth("Select Level");
		strHeight = g.getFontMetrics(font).getHeight();

        g.setColor(Color.white);
        g.drawString("Select Level", (int) (levelSelectBtn.getX() + levelSelectBtn.getWidth() / 2 - strWidth / 2),
				(int) (levelSelectBtn.getY() + levelSelectBtn.getHeight() / 2 + strHeight / 4));

		strWidth = g.getFontMetrics(font).stringWidth("Settings");

        g.drawString("Settings", (int) (settingsBtn.getX() + settingsBtn.getWidth() / 2 - strWidth / 2),
        (int) (settingsBtn.getY() + settingsBtn.getHeight() / 2 + strHeight / 4));

        strWidth = g.getFontMetrics(font).stringWidth("Exit");
        g.drawString("Exit", (int) (exitBtn.getX() + exitBtn.getWidth() / 2 - strWidth / 2),
        (int) (exitBtn.getY() + exitBtn.getHeight() / 2 + strHeight / 4));

    }


    @Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();

		if (levelSelectBtn.contains(p))
			active = false; 
            // TODO` add level select menu
        else if(settingsBtn.contains(p)){
            System.out.println("Settings");
            // TODO add settings menu
            active = false;
        }else if (exitBtn.contains(p))
			System.exit(0);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		Point p = e.getPoint();

		// determine if mouse is hovering inside one of the buttons
		lHighlighted= levelSelectBtn.contains(p);
        sHighlighted= settingsBtn.contains(p);
	    eHighlighted= exitBtn.contains(p);

	


        

    
    }
}
