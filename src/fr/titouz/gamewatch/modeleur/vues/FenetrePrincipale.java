package fr.titouz.gamewatch.modeleur.vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelConfigurationFond;
import fr.titouz.gamewatch.modeleur.vues.composants.PositionnementSprite;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;

	private LinkedHashMap<JPanel, String> mapEtapes;

	private JPanel panelPrincipal;

	private int indexEtape = -1;

	private JButton boutSuivant;

	public FenetrePrincipale() {
		try {

			this.mapEtapes = new LinkedHashMap<>();

			mapEtapes.put(new DecoupeurSprites(), "1");
			mapEtapes.put(new PanelConfigurationFond(), "2.1");
			mapEtapes.put(new DecoupeurFond(), "2.2");
			mapEtapes.put(new PositionnementSprite(), "3");
			mapEtapes.put(new PositionnementSprite(), "4");
			mapEtapes.put(new PositionnementSprite(), "5");
			mapEtapes.put(new JPanel(), "6");
			mapEtapes.put(new JPanel(), "7");


			mapEtapes.put(new JPanel(), "test1");
			mapEtapes.put(new JPanel(), "test2");

			this.setSize(new Dimension(1200, 800));
			this.setMinimumSize(new Dimension(1000, 600));
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

			this.setLayout(new BorderLayout());
			JLabel topLabel = new JLabel("Assistant création de jeu Titz & Watch");
			topLabel.setIcon(ImagesHelper.getIcon("ressources/wizard-icon.png"));
			topLabel.setHorizontalAlignment(JLabel.CENTER);

			this.add(topLabel, BorderLayout.NORTH);

			JList listeGauche = new JList(new Vector<String>(mapEtapes.values()));

			this.add(listeGauche, BorderLayout.WEST);
			panelPrincipal = new JPanel(new BorderLayout());

			this.add(panelPrincipal, BorderLayout.CENTER);

			JPanel panelBas = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			boutSuivant = new JButton("Suivant");

			panelBas.add(boutSuivant);

			boutSuivant.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					appuiSuivant();
				}
			});

			this.add(panelBas, BorderLayout.SOUTH);


			this.setVisible(true);
			this.revalidate();
		} catch (MalformedURLException ex) {
			Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void appuiSuivant() {
		indexEtape++;
		this.panelPrincipal.removeAll();
		this.panelPrincipal.add(new LinkedList<JPanel>(mapEtapes.keySet()).get(indexEtape), BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}
