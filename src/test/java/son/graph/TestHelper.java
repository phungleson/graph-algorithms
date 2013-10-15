package son.graph;

import son.graph.models.SimpleGraphBuilder;
import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.GraphBuilder;

public class TestHelper {
	public static Graph getGraph() {

		GraphBuilder graphBuilder = new SimpleGraphBuilder();
		graphBuilder.addEdge("A", "B", 5);
		graphBuilder.addEdge("B", "C", 4);
		graphBuilder.addEdge("C", "D", 8);
		graphBuilder.addEdge("D", "C", 8);
		graphBuilder.addEdge("D", "E", 6);
		graphBuilder.addEdge("A", "D", 5);
		graphBuilder.addEdge("C", "E", 2);
		graphBuilder.addEdge("E", "B", 3);
		graphBuilder.addEdge("A", "E", 7);

		return graphBuilder.getGraph();
	}
}
