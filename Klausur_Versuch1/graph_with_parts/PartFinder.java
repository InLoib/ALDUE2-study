package graph_with_parts;

import java.util.ArrayDeque;
import java.util.List;

public class PartFinder {
	
	
	public int calcPartCount(ArrayGraph g) {
		
		boolean[] visited = new boolean[g.numVertices()];
		
		// Hier sollte Ihr Code stehen
		
		// Denken Sie daran, dass Sie jederzeit Hilfsmethoden
		// machen können.
		
		
		int knotenAnzahl = g.numVertices();

		int returnValue = 0;
		
		for (int i = 0; i < knotenAnzahl; i++) {
			if(visited[i] == false){
				returnValue++;
			}
			
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			stack.push(i);
			
			while(stack.isEmpty() == false){
				int actualerKnoten = stack.pop();
				visited[actualerKnoten] = true;
				
				List<WeightedEdge> listederKantenVomActualKnoten = g.getEdges(actualerKnoten);
				
				for (WeightedEdge weightedEdge : listederKantenVomActualKnoten) {
					if(visited[weightedEdge.vertex] == false){
						stack.push(weightedEdge.vertex);
					}
				}
				
				
				
			}
			
			
		}
		
		
		
		return returnValue; // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren!

	}
	

}
