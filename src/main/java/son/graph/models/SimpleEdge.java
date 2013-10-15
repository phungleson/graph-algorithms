package son.graph.models;

import son.graph.models.interfaces.Edge;
import son.graph.models.interfaces.Node;

public class SimpleEdge implements Edge {
	public SimpleEdge(Node node, Node nextNode, int weight) {
		this.node = node;
		this.nextNode = nextNode;
		this.weight = weight;
	}

	private final Node node;

	@Override
	public Node getNode() {
		return node;
	}

	private final Node nextNode;

	@Override
	public Node getNextNode() {
		return nextNode;
	}

	private final int weight;

	@Override
	public int getWeight() {
		return weight;
	}
}
