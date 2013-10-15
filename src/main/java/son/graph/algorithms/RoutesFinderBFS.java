package son.graph.algorithms;

import java.util.LinkedList;
import java.util.List;

import son.graph.helpers.GraphHelper;
import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

public class RoutesFinderBFS extends RoutesFinder {
	public RoutesFinderBFS(Graph graph) {
		super(graph);
	}

	@Override
	public void calculate(String beginName, String endName, RoutesContraint routesContraints) {
		Node beginNode = getGraph().getNodes().get(beginName);
		Node endNode = getGraph().getNodes().get(endName);

		LinkedList<Node> currentRoute = new LinkedList<>();
		currentRoute.add(beginNode);

		calculate(currentRoute, endNode, routesContraints);
	}

	private void calculate(LinkedList<Node> currentRoute, Node endNode,
			RoutesContraint routesContraints) {
		Node currentNode = currentRoute.getLast();

		List<Node> nextNodes = GraphHelper.getNextNodes(currentNode);

		for (Node nextNode : nextNodes) {
			if (endNode.equals(nextNode)) {
				currentRoute.add(nextNode);
				if (routesContraints.canStop(currentRoute)) {
					addRoute(currentRoute);
				}
				// printPath(currentRoute);
				currentRoute.removeLast();
				break;
			}
		}

		for (Node nextNode : nextNodes) {
			currentRoute.addLast(nextNode);

			if (routesContraints.canMoveNext(currentRoute)) {
				calculate(currentRoute, endNode, routesContraints);
			}

			currentRoute.removeLast();
		}
	}

}
