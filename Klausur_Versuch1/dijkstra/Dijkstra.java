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
		for (int i = 0; i < anzahlKnoten; i++) {
			if(!listeKanten.contains(g.getEdges(i))){
				listeKanten = g.getEdges(i);
			}
		}
		
		VertexHeap heap = new VertexHeap(anzahlKnoten);
		
		for (WeightedEdge weightedEdge : listeKanten) {
			heap.insert(weightedEdge);
		}
		
		vorgaengerKnoten[von] = -1;
		kosten[von] = 0;
		
		
		
		
		
		
		
		
		return returnList; // <-- Liefern Sie hier ihr Ergebnis retour
		
	}
	
	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		
		ArrayList<Integer> way = new ArrayList<Integer>(); 
		
		// TODO: Implementierung dar ausgabe
		
		return way;
	}
	

}
