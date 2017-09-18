package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static List<Integer> dijkstra(Graph g, int von, int nach) {

		//TODO: Hier sollte Ihre Implementierung sein


		int[] vorgaenger = new int[g.numVertices()];
		int[] distanz = new int[g.numVertices()];
		
		for (int i = 0; i < g.numVertices(); i++) {
			vorgaenger[i] = -1;
			distanz[i] = 9999;
		}
		
		distanz[von] = 0;
		
		VertexHeap heap = new VertexHeap(g.numVertices());
		for (int i = 0; i < g.numVertices(); i++) {
			heap.insert(new WeightedEdge(i, distanz[i]));
		}
		
		while(heap.isEmpty() != true){
			WeightedEdge actuell = heap.remove();
			
			List<WeightedEdge> KantenDesActuell = g.getEdges(actuell.vertex);
			
			for (WeightedEdge perKante : KantenDesActuell) {
				if(heap.contains(perKante)){
					
					int dist = distanz[actuell.vertex] + perKante.weight;
					
					if(dist < distanz[perKante.vertex]){
						distanz[perKante.vertex] = dist;
						vorgaenger[perKante.vertex] = actuell.vertex;
						
						heap.setPriority(perKante.vertex, dist);
					}					
				}				
			}	
		}
		
		List<Integer> way = predToWay(vorgaenger, von, nach);
		
		return way; // <-- Liefern Sie hier ihr Ergebnis retour
	}
	
	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		
		ArrayList<Integer> way = new ArrayList<Integer>(); 
		
		// TODO: Implementierung dar ausgabe
		
		int current = to;
		way.add(to);
		
		while(current != from){
			way.add(0, pred[current]);
			current = pred[current];
		}	
		return way;
	}
}
