package fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OpaciteListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("Opacit� : " + ((JSpinner)e.getSource()).getValue());
	}

}
