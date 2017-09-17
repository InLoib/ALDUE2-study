package A05_Breitensuche;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Breitensuche extends BaseTree<Integer> {

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
		ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
		queue.add(start);
		List<Integer> returnList = new ArrayList<>();
		
		Node<Integer> actualVertic = null;
		
		while((actualVertic = queue.poll()) != null){
			returnList.add(actualVertic.getValue());
			
			if(actualVertic.getLeft() !=null){
				queue.add(actualVertic.getLeft());
			}
			if(actualVertic.getRight() !=null){
				queue.add(actualVertic.getRight());
			}			
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
		ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
		queue.add(start);
		List<Integer> returnList = new ArrayList<>();
		
		Node<Integer> acutalVeritc = null;
		
		double position = 0.0;
		int actualLevel = 1;
		
		while((acutalVeritc = queue.poll()) != null){
			position++;
			
			actualLevel = (int) (Math.log(position) / Math.log(2.0)+1);
			
			if(actualLevel == level){
				returnList.add(acutalVeritc.getValue());
			}
			
			else{
				if(acutalVeritc.getLeft() != null){
					queue.add(acutalVeritc.getLeft());
			
				}
				if(acutalVeritc.getRight() != null){
					queue.add(acutalVeritc.getRight());
	
				}
			}
		}
		
		
		return returnList;
	}

}
