package A08_GraphZusammenhängend;

import java.util.ArrayDeque;
import java.util.List;

import basisAlgorithmen.Graph;
import basisAlgorithmen.WeightedEdge;

public class ConnectedComponents {
	
	private Graph graph;
	private boolean[] besuchteKnotenListe;
	
	/**
	 * Retourniert die Anzahl der zusammenhängenden Komponenten eines Graphen
	 * @param g zu prüfender Graph
	 * @return Anzahl der Komponenten
	 */
	public int getNumberOfComponents(Graph g) {
		
		int returnCounter = 0;
		graph = g;
		int anzahlKnoten = graph.numVertices();
		besuchteKnotenListe = new boolean[anzahlKnoten];
		
		for (int i = 0; i < anzahlKnoten; i++) {
			if(besuchteKnotenListe[i] == false){
				returnCounter++;
							
				ArrayDeque<Integer> stack = new ArrayDeque<>();
				stack.push(i);
							
				while(stack.isEmpty() != true){
					Integer actualVertec = stack.pop();
					besuchteKnotenListe[actualVertec] = true;
					List<WeightedEdge> gefundeneEdges = graph.getEdges(actualVertec);
					
					for (WeightedEdge weightedEdge : gefundeneEdges) {
						if(besuchteKnotenListe[weightedEdge.to_vertex] == false){
							stack.push(weightedEdge.to_vertex);
						}
					}
					
				}
			}
			
		}
			
		return returnCounter;
	}

}
