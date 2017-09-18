package graph_with_parts2;

import java.util.ArrayDeque;
import java.util.List;

public class PartFinder {
	
	public int calcPartCount(ArrayGraph g) {
		
		boolean[] visited = new boolean[g.numVertices()];
		
		// Hier sollte Ihr Code stehen
		
		// Denken Sie daran, dass Sie jederzeit Hilfsmethoden
		// machen können.
		
		int returnValue = 0;
		
		for (int i = 0; i < g.numVertices(); i++) {
			if(visited[i] == false){
				returnValue++;
			}
			
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			stack.push(i);
			
			int actualVertex;
			
			while(stack.isEmpty() != true){
				actualVertex = stack.pop();
				visited[actualVertex] = true;
				
				List<WeightedEdge> kantenDesKnoten = g.getEdges(actualVertex);
				
				for (WeightedEdge jedeKante : kantenDesKnoten) {
					if(visited[jedeKante.vertex] == false){
						stack.push(jedeKante.vertex);
					}			
					
				}			
				
			}
			

			
			
		}
		
		
		
		return returnValue; // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren!

	}
	

}
