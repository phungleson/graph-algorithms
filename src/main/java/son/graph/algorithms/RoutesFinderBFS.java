package son.graph.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import son.graph.helpers.GraphHelper;
import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

/**
 * Breadth-first-search algorithm
 * (http://en.wikipedia.org/wiki/Breadth-first_search) implementation to find
 * routes from begin node to end node in the graph.
 * 
 * @author son
 */
public class RoutesFinderBFS extends RoutesFinder {
	public RoutesFinderBFS(Graph graph) {
		super(graph);
	}

	@Override
	public List<List<Node>> findRoutes(String beginName, String endName,
			RoutesConstraint routesContraints) {
		Node beginNode = getGraph().getNodes().get(beginName);
		Node endNode = getGraph().getNodes().get(endName);

		List<List<Node>> routes = new ArrayList<>();

		LinkedList<Node> currentRoute = new LinkedList<>();
		currentRoute.add(beginNode);

		bfs(routes, currentRoute, endNode, routesContraints);

		return routes;
	}

	private void bfs(List<List<Node>> routes, LinkedList<Node> currentRoute, Node endNode,
			RoutesConstraint routesContraints) {
		Node currentNode = currentRoute.getLast();

		List<Node> nextNodes = GraphHelper.getNextNodes(currentNode);

		for (Node nextNode : nextNodes) {
			if (endNode.equals(nextNode)) {
				currentRoute.add(nextNode);
				if (routesContraints.canStop(currentRoute)) {
					routes.add(new ArrayList<>(currentRoute));
				}
				currentRoute.removeLast();
				break;
			}
		}

		for (Node nextNode : nextNodes) {
			currentRoute.addLast(nextNode);

			if (routesContraints.canMoveNext(currentRoute)) {
				bfs(routes, currentRoute, endNode, routesContraints);
			}

			currentRoute.removeLast();
		}
	}

}
