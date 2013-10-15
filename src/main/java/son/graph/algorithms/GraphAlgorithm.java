package son.graph.algorithms;

import son.graph.models.interfaces.Graph;

public abstract class GraphAlgorithm {
	public GraphAlgorithm(Graph graph) {
		this.graph = graph;
	}

	private final Graph graph;

	public Graph getGraph() {
		return graph;
	}
}
