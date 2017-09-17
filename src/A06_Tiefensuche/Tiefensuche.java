package A06_Tiefensuche;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import A05_Breitensuche.BaseTree;
import A05_Breitensuche.Node;

public class Tiefensuche extends BaseTree<Film> {
	

	@Override
	/**
	 * Sortierkriterium im Baum: L�nge des Films
	 */
	protected int compare(Film a, Film b) {
		int returnValue =0;
		
		if(a.getL�nge() < b.getL�nge()){
			returnValue = -1;
		}
		if(a.getL�nge() > b.getL�nge()){
			returnValue = 1;
		}
		return returnValue;
	}

	/**
	 * Retourniert die Titelliste der Film-Knoten des Teilbaums in symmetrischer Folge (engl. in-order, d.h. links-Knoten-rechts)
	 * @param node Wurzelknoten des Teilbaums
	 * @return Liste der Titel in symmetrischer Reihenfolge
	 */
	public List<String> getNodesInOrder(Node<Film> node) {
		List<String> returnList = new ArrayList<>();
		
		if(node.getLeft() != null){
			List<String> returnListLeft = getNodesInOrder(node.getLeft());
			returnList.addAll(returnListLeft);
		}
		returnList.add(node.getValue().getTitel());

		if(node.getRight() != null){
			List<String> returRight = getNodesInOrder(node.getRight());
			returnList.addAll(returRight);
		}
		
		return returnList;
	}
	
	/**
	 * Retourniert Titelliste jener Filme, deren L�nge zwischen min und max liegt, in Hauptreihenfolge (engl. pre-order, d.h. Knoten-links-rechts)
	 * @param min Minimale L�nge des Spielfilms
	 * @param max Maximale L�nge des Spielfilms
	 * @return Liste der Filmtitel in Hauptreihenfolge
	 */
	public List<String> getMinMaxPreOrder(double min, double max) {
//		List<String> returnList = new ArrayList<>();
//		ArrayDeque<Node<Film>> stack = new ArrayDeque<>();
//		stack.push(root);
//		
//		Node<Film> actualFilm = null;
//		
//		if((actualFilm = stack.pop()) != null){
//			if(actualFilm.getValue().getL�nge() < max && actualFilm.getValue().getL�nge() > min){
//				returnList.add(actualFilm.getValue().getTitel());
//			}
//			if(actualFilm.getRight() != null){
//				stack.push(actualFilm.getRight());
//			}
//			if(actualFilm.getLeft() != null){
//				stack.push(actualFilm.getLeft());
//				
//				
//			}
//		}
		
			
		
		return getMinMaxPreOrder(root, min, max);
	}
	
	public List<String> getMinMaxPreOrder(Node<Film> node, double min, double max) {
		List<String> returnList = new ArrayList<>();
		
		if(node != null){
			if(node.getValue().getL�nge() < max && node.getValue().getL�nge() > min){
			returnList.add(node.getValue().getTitel());
			}
		}
		if(node.getLeft() != null){
			List<String> returnListLeft = getMinMaxPreOrder(node.getLeft(), min, max);
			returnList.addAll(returnListLeft);
		}
		if(node.getRight() != null){
			List<String> returnListRight = getMinMaxPreOrder(node.getRight(), min, max);
			returnList.addAll(returnListRight);
		}
		
		return returnList;
	}

	
	
}
