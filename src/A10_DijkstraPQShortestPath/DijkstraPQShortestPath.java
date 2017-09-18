package A10_DijkstraPQShortestPath;
import java.util.ArrayList;
import java.util.List;

public class DijkstraPQShortestPath extends FindWay {
	private int[] dist;

	public DijkstraPQShortestPath(Graph graph) {
		super(graph);
	}
	
	/**
	 * Startentfernung initialisieren
	 * @param from Startknoten
	 */
	protected void initPathSearch() {
		int numv = graph.numVertices();
		dist = new int[numv];
		for (int i=0; i < numv; i++) {
			dist[i] = 9999;		// Summen im Graph d�rfen nie mehr ergeben
		}
	}
	
	/**
	 * Berechnet *alle* k�rzesten Wege ausgehend vom Startknoten
	 * Setzt dist[]- und pred[]-Arrays, kein R�ckgabewert
	 * @param from Startknoten
	 */
	protected boolean calculatePath(int from, int to) {
		VertexHeap heap = new VertexHeap(graph.numVertices());	//heap definieren
		
		for (int i = 0; i < graph.numVertices(); i++) {
			heap.insert(new Vertex(i, dist[i]));		//heap bef�llen mit dem was laut initPath steht
		}
		
		pred[from] = -1;				//muss vom ersten Knoten gleich mal gemacht werden
		dist[from] = 0;					//muss vom ersten Knoten gleich mal gemacht werden
		
		heap.setCost(from, dist[from]);		//muss vauch im Heap stehen f�r Berechnung
		
		while(heap.isEmpty() == false){
			Vertex actualVertex = heap.remove();
			
			if(actualVertex.vertex == to){
				return true;
			}
			
			List<WeightedEdge> gefundeneEdges = new ArrayList<>();	
			gefundeneEdges = graph.getEdges(actualVertex.vertex);	//anliegende Kanten aufrufen

			for (WeightedEdge weightedEdge : gefundeneEdges) {		//f�r jede Kante zu pr�fen
				int actualCostSum = actualVertex.cost + weightedEdge.weight;	//ob ihre Kosten nen g�nstigeren Weg liefern
				
				if(actualCostSum < dist[weightedEdge.to_vertex]){		//wenn ja, werte in den Array & im Heap �berschreiben

					pred[weightedEdge.to_vertex] = actualVertex.vertex;
					dist[weightedEdge.to_vertex] = actualCostSum;

					heap.setCost(weightedEdge.to_vertex, actualCostSum);	//muss im Heap auch stehen f�r die Berechnung!
				}				
			}
		}
		
		
		return false;
	}
}
