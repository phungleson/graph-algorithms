package son.graph;

import java.util.List;

import son.graph.algorithms.Routes;
import son.graph.exceptions.RouteNotFoundException;
import son.graph.models.interfaces.Edge;
import son.graph.models.interfaces.Node;

/**
 * Calculate distance of a route connecting multiple nodes
 * 
 * @author son
 */
public class SimpleRoutes extends Routes {

	public SimpleRoutes() {
		super(null);
	}

	@Override
	public int distance(List<Node> nodes) {
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
