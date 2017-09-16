package A05_Breitensuche;

import java.util.ArrayList;
import java.util.List;

public class Breitensuche extends BaseTree<Integer> {
	
	private List<Integer> returnList = new ArrayList<>();

	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück
	 * @param start Startknoten für Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {
	
		returnList.add(start.getValue());
		if(start.getLeft() != null){
			getBreadthFirstOrder(start);			
		}
		if(start.getRight() != null){
			getBreadthFirstOrder(start);
		}	

		return returnList;
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zurück,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten für Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		return null;
	}

}
