package son.graph.algorithms;

import java.util.List;

import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

public abstract class Routes extends GraphAlgorithm {
	public Routes(Graph graph) {
		super(graph);
	}

	public abstract int distance(List<Node> nodes);
}
