package graph_with_parts2;

public class DemoGraph {

	public static void main(String[] args) {

		PartFinder pf = new PartFinder();
		
		ArrayGraph g = new ArrayGraph(7, false);

		// Insel 1
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		// Insel 2
		g.addEdge(4, 5);
		
		// Insel 3 
		// besteht nur aus Knoten 6 --> keine Verbindungen
		
		int count = pf.calcPartCount(g);
		System.out.println(count);

	}

}
