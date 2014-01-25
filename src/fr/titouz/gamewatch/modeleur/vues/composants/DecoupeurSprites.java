package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class DecoupeurSprites extends JPanel {

	private AfficheurImage aff;
	private PanelSlider slide;

	/**
	 * Default constructor of
	 * <code>DecoupeurSprites</code>.
	 */
	public DecoupeurSprites() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.NONE;
		//c.anchor = GridBagConstraints.NORTHWEST;
		aff = new AfficheurImage();
		aff.changeImage("ressources/Sprite1.png");
		this.add(aff, c);

		slide = new PanelSlider("Largeur du sprite", new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				MAJLargeurDecoupe();
			}
		});
		
		c.gridy = 1;
		this.add(slide, c);

		this.validate();

	}

	private void MAJLargeurDecoupe() {
		aff.setLargSprite(slide.getValue());
	}
}

class AfficheurImage extends JComponent {

	private BufferedImage image = null;

	private int largSprite = 25;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		if (image != null) {
			g2d.drawImage(image, null, 0, 0);
		}
		int offsetX = 1;
		while (offsetX + largSprite < this.getWidth()) {
			offsetX += largSprite;
			g2d.drawLine(offsetX, 0, offsetX, this.getHeight());
		}
	}

	public void changeImage(String path) {
		try {
			image = ImageIO.read(new File(path));
			System.out.println("hbjkjhgjgjhg");
			this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		} catch (IOException ex) {
			Logger.getLogger(AfficheurImage.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void setLargSprite(int largSprite) {
		this.largSprite = largSprite;
		this.repaint();
	}
}