package graph_with_parts1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PartFinder {
	
	public int calcPartCount(ArrayGraph g) {
		
		boolean[] visited = new boolean[g.numVertices()];
		
		// Hier sollte Ihr Code stehen
		
		// Denken Sie daran, dass Sie jederzeit Hilfsmethoden
		// machen können.
		
		
		int returnValue =0;
		
		
		for (int i = 0; i < g.numVertices(); i++) {
			if(visited[i] == false){
				returnValue++;
			}
			
			ArrayDeque<Integer> stack = new ArrayDeque<>();
			stack.push(i);
			
			int actual;
			
			while(stack.isEmpty() != true){
				actual = stack.pop();
				visited[actual] = true;
							
				List<WeightedEdge> listActualEdges = g.getEdges(actual);
				for (WeightedEdge perEdge : listActualEdges) {
					if(visited[perEdge.vertex] == false){
						stack.push(perEdge.vertex);
					}		
				}
				
				
			}
	
		}
		
		
		
		
		return returnValue; // <-- Vergessen Sie nicht, Ihr Ergebnis zu retournieren!

	}
	

}
