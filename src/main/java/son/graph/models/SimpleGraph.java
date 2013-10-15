package son.graph.models;

import java.util.HashMap;
import java.util.Map;

import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

public class SimpleGraph implements Graph {
	public SimpleGraph() {
		nodes = new HashMap<>();
	}

	private final Map<String, Node> nodes;

	@Override
	public Map<String, Node> getNodes() {
		return nodes;
	}
}
