package dijkstra2;

import java.util.List;

public class DemoDijkstra {

	public static void main(String[] args) {
		ListGraph g = new ListGraph(10, false);
		
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 5);
		g.addEdge(1, 3, 10);
		g.addEdge(2, 3, 1);
		
		g.addEdge(3, 4, 5);
		g.addEdge(3, 5, 1);
		g.addEdge(4, 6, 1);
		g.addEdge(5, 6, 5);
		
		for(int i=0; i<g.numVertices(); i++) {
			g.setCosts(5, i);
		}
		
		g.setCosts(1, 1);
		
		
		List<Integer> way = Dijkstra.dijkstra(g, 0, 6); 
		
		System.out.println(way); 

	}

}
