package dijkstra2;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static List<Integer> dijkstra(Graph g, int von, int nach) {

		//TODO: Hier sollte Ihre Implementierung sein
		
		int mengeKnoten = g.numVertices();
		
		int[] vorgaenger = new int[mengeKnoten];
		int[] kosten = new int[mengeKnoten];
		
		for (int i = 0; i < mengeKnoten; i++) {
			vorgaenger[i] = -1;
			kosten[i] = 9999;
		}
		
		kosten[von] = 0;
		
		VertexHeap heap = new VertexHeap(mengeKnoten);
		
		for (int i = 0; i < mengeKnoten; i++) {
			heap.insert(new WeightedEdge(i, kosten[i]));
		}
		
		WeightedEdge actuelleKante;
		
		while(heap.isEmpty() != true){
			actuelleKante = heap.remove();
			
			List<WeightedEdge> listeKantenZu = g.getEdges(actuelleKante.vertex);
			for (WeightedEdge jedeKanteZu : listeKantenZu) {
				if(heap.contains(jedeKanteZu)){
					
					int kostenVergl = kosten[actuelleKante.vertex] + jedeKanteZu.weight + g.getCosts(actuelleKante.vertex);
					
					if(kostenVergl < kosten[jedeKanteZu.vertex]){
						kosten[jedeKanteZu.vertex] = kostenVergl;
						vorgaenger[jedeKanteZu.vertex] = actuelleKante.vertex;
						heap.setPriority(jedeKanteZu.vertex, kostenVergl);
					}
					
				}
				
			}	
			
		}
		
		List<Integer> returnList = predToWay(vorgaenger, von, nach);
		
		return returnList; // <-- Liefern Sie hier ihr Ergebnis retour
		
	}
	
	private static ArrayList<Integer> predToWay(int[] pred, int from, int to) {
		
		ArrayList<Integer> way = new ArrayList<Integer>(); 
		
		// TODO: Implementierung dar ausgabe
		
		int actuell = to;
		
		way.add(actuell);
		
		while(actuell != from){
			way.add(0, pred[actuell]);
			actuell = pred[actuell];
		}
		
		
		return way;
	}
	

}
