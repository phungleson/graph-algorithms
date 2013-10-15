package son.graph.models;

import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.GraphBuilder;
import son.graph.models.interfaces.Node;

public class SimpleGraphBuilder implements GraphBuilder {

	public SimpleGraphBuilder() {
		graph = new SimpleGraph();
	}

	private final Graph graph;

	@Override
	public void addEdge(String name, String nextName, int weight) {
		Node node = getOrCreateNode(name);
		Node nextNode = getOrCreateNode(nextName);

		node.getEdges().add(new SimpleEdge(node, nextNode, weight));
	}

	private Node getOrCreateNode(String name) {
		Node node = graph.getNodes().get(name);

		if (node == null) {
			node = new SimpleNode(name);
			graph.getNodes().put(name, node);
		}

		return node;
	}
}
