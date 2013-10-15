package son.graph.algorithms;

import son.graph.models.interfaces.Graph;

/**
 * An algorithm implements on top of a graph
 * 
 * @author son
 */
public abstract class GraphAlgorithm {
	public GraphAlgorithm(Graph graph) {
		this.graph = graph;
	}

	private final Graph graph;

	public Graph getGraph() {
		return graph;
	}
}
