package A05_Breitensuche;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Breitensuche2 extends BaseTree<Integer> {

	@Override
	protected int compare(Integer a, Integer b) {
		return a.compareTo(b);
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zur�ck
	 * @param start Startknoten f�r Teilbaum
	 * @return Liste der Knoten in Breitenfolge
	 */
	public List<Integer> getBreadthFirstOrder(Node<Integer> start) {
		
		ArrayDeque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		queue.add(start);
		
		Node<Integer>node;
		
		// den letzten Eintrag der Queue abfragen und davon entfernen,
		// solange durchgehen, bis der Queue leer ist
		while((node=queue.poll()) !=null)
		{
			{
				// wenn links ein Element existiert, dieses der Queue hinzuf�gen
				Node<Integer> left = node.getLeft();
				if(left != null)
					queue.add(left);
			}
			
			{
				// wenn rechts ein Element existiert, dieses der Queue hinzuf�gen
				Node<Integer> right = node.getRight();
				if(right != null)
					queue.add(right);
			}
			
			// den aktuellen Eintrag in die Ergebnisliste einf�gen
			result.add(node.getValue());
		}
		
		return result;
	}

	/**
	 * Liefert Knoten des Baums ausgehend von Start in Reihenfolge der Breitensuche zur�ck,
	 * allerdings nur jene Knoten, die in der angegebenen Ebene liegen (Start hat Ebene=1)
	 * @param start Startknoten f�r Teilbaum
	 * @param level Nur Knoten dieser Ebene ausgeben
	 * @return Liste aller Knoten
	 */
	public List<Integer> getBreadthFirstOrderForLevel(Node<Integer> start, int level) {

		ArrayDeque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		queue.add(start);
		
//		Node<Integer>node;
//		double counter =0.0;
//		
//		while()
//		
//		int foo = (int)(Math.log(counter)/Math.log(2.0)+1.0);
		
		
		
		
		
		
		
		
		
//		// der ben�tigte Level ist der aktuelle Startlevel + level
//		int neededLevel = start.getCurrentLevel() + level - 1;
//		
//		// den letzten Eintrag der Queue abfragen und davon entfernen,
//		// solange durchgehen, bis der Queue leer ist
//		while((node=queue.poll()) !=null)
//		{
//			if(node.getCurrentLevel() < neededLevel)
//			{
//				// wenn links ein Element existiert, dieses der Queue hinzuf�gen
//				Node<Integer> left = node.getLeft();
//				if(left != null)
//					queue.add(left);
//			}
//			
//			if(node.getCurrentLevel() < neededLevel)
//			{
//				// wenn rechts ein Element existiert, dieses der Queue hinzuf�gen
//				Node<Integer> right = node.getRight();
//				if(right != null)
//					queue.add(right);
//			}
//			
//			// den aktuellen Eintrag in die Ergebnisliste einf�gen, wenn der Level gleich dem ben�tigten Level ist
//			if(neededLevel == node.getCurrentLevel())
//				result.add(node.getValue());
//		}
		
		return result;
	}

}