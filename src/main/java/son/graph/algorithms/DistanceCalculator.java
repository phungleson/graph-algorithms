package son.graph.algorithms;

import java.util.List;

import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

public abstract class DistanceCalculator extends GraphAlgorithm {
	public DistanceCalculator(Graph graph) {
		super(graph);
	}

	public abstract int calculate(List<Node> nodes);
}
