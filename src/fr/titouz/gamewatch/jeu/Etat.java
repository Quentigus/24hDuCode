/*Copyright ANDRU Bastien, CARRE, Ga�l DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
 * (25/01/2014)
 * This file is part of Titz & Watch.
 * 
 * Titz & Watch is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Titz & Watch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Titz & Watch.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package fr.titouz.gamewatch.jeu;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * Cette classe repr�sente un �tat d'une s�quence. 
 */
public class Etat implements Iterable<Transition> {
	private List<Transition> transitions;
	private boolean actif;
	
	/**
	 * Cr�e un �tat sans transition et d�sactiv�.
	 */
	public Etat() {
		this(false);
	}
	
	/**
	 * Cr�e un �tat.
	 * 
	 * @param active bool�en indiquant si l'�tat doit �tre actif par d�faut.
	 */
	public Etat(boolean active) {
		transitions = new LinkedList<Transition>();
		actif = active;
	}
	
	/**
	 * Ajoute une nouvelle transition � l'�tat.
	 * 
	 * @param t la nouvelle transition.
	 */
	public void add(Transition t) {
		transitions.add(t);
	}
	
	/**
	 * Supprime une transition de l'�tat.
	 * 
	 * @param t la transition � supprimer.
	 */
	public void remove(Transition t) {
		transitions.remove(t);
	}
	
	/**
	 * Supprime une transition de l'�tat.
	 * 
	 * @param index l'index de la transition � supprimer.
	 */
	public void remove(int index) {
		transitions.remove(index);
	}
	
	/**
	 * Insert une nouvelle transition dans l'�tat.
	 * 
	 * @param t la nouvelle transition.
	 * @param index la place � laquelle ins�r� la transition
	 */
	public void add(int index, Transition t) {
		transitions.add(index, t);
	}
	
	/**
	 * Intervertit deux transitions.
	 * 
	 * @param index1 la place de la premi�re transition.
	 * @param index2 la place de la transition avec laquelle �changer.
	 */
	public void intervertir(int index1, int index2) {
		if(index1 != index2) {
			Transition t1 = transitions.get(index1);
			Transition t2 = transitions.get(index2);
			transitions.remove(t1);
			transitions.remove(t2);
			if(index1 < index2) {
				transitions.add(index1, t2);
				transitions.add(index2, t1);
			}
		}
	}

	@Override
	public Iterator<Transition> iterator() {
		return transitions.iterator();
	}
	
	/**
	 * Obtenir une transition de l'�tat.
	 * 
	 * @param index la place de la transition.
	 * @return
	 */
	public Transition get(int index) {
		return transitions.get(index);
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
}
