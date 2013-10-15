package son.graph;

import java.util.List;

import son.graph.algorithms.DistanceCalculator;
import son.graph.exceptions.RouteNotFoundException;
import son.graph.models.interfaces.Edge;
import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

public class SimpleDistanceCalculator extends DistanceCalculator {

	public SimpleDistanceCalculator(Graph graph) {
		super(graph);
	}

	@Override
	public int calculate(List<Node> nodes) {
		int distance = 0;

		for (int i = 0; i < nodes.size() - 1; i++) {
			Node node = nodes.get(i);
			Node nextNode = nodes.get(i + 1);

			boolean routeFound = false;
			for (Edge edge : node.getEdges()) {
				if (edge.getNextNode().equals(nextNode)) {
					routeFound = true;
					distance += edge.getWeight();
					break;
				}
			}

			if (!routeFound) {
				throw new RouteNotFoundException();
			}
		}

		return distance;
	}
}
