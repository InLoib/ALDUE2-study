package dijkstra;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static List<Integer> dijkstra(Graph g, int von, int nach) {

		//TODO: Hier sollte Ihre Implementierung sein

		
		List<Integer> returnList = new ArrayList<>();
		
		int anzahlKnoten = g.numVertices();
		int[] vorgaengerKnoten = new int[anzahlKnoten];
		int[] kosten = new int[anzahlKnoten];
		
		for (int i = 0; i < anzahlKnoten; i++) {
			vorgaengerKnoten[i] = -1;
			kosten[i] = 999999;
		}
		
		
		List<WeightedEdge> listeKanten = new ArrayList<>();
		ArrayDeque<WeightedEdge> queue = new ArrayDeque<>();
		for (int i = 0; i < anzahlKnoten; i++) {
			listeKanten = g.getEdges(i);
		}
		for (WeightedEdge weightedEdge : listeKanten) {
			
			if(queue.contains(weightedEdge) != true){
				queue.add(weightedEdge);
			}	
		}
		
		VertexHeap heap = new VertexHeap(anzahlKnoten);
		for (int i = 0; i < queue.size(); i++) {
			heap.insert(queue.poll());
		}
		
		while(heap.isEmpty() != false){
			
		}
		
		
		
		
		
		return returnList; // <-- Liefern Sie hier ihr Ergebnis retour
		
	}
	
	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		
		ArrayList<Integer> way = new ArrayList<Integer>(); 
		
		// TODO: Implementierung dar ausgabe
		
		return way;
	}
	

}
