/*
 * @author Donatien Criaud
 * 
 */
package simergy.userinterface.guicomponents;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

// TODO: Auto-generated Javadoc
/**
 * The Class TabBackground.
 */
public class TabBackground extends JTabbedPane{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7606273163764299972L;
	
	/** The bg. */
	private BufferedImage bg;

    /**
     * Instantiates a new tab background.
     */
    public TabBackground() {
        try {
            bg = ImageIO.read(new File("img/indexSimErgy.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(TabBackground.class.getName()).log(Level.SEVERE, null, ex);
        }

        JPanel tabPanel = new JPanel(new GridBagLayout()) {

			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 300);
            }
        };
        this.add(tabPanel);
        this.add("SimErgy", tabPanel);
    }
}