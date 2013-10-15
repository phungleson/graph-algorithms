package son.graph.models;

import java.util.ArrayList;
import java.util.List;

import son.graph.models.interfaces.Edge;
import son.graph.models.interfaces.Node;

public class SimpleNode implements Node {
	public SimpleNode(String name) {
		this.name = name;
		this.edges = new ArrayList<>();
	}

	private final String name;

	@Override
	public String getName() {
		return name;
	}

	private final List<Edge> edges;

	@Override
	public List<Edge> getEdges() {
		return edges;
	}
}
