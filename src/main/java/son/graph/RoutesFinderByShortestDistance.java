package son.graph;

import java.util.List;

import son.graph.algorithms.Routes;
import son.graph.algorithms.RoutesFinder;
import son.graph.algorithms.RoutesConstraint;
import son.graph.models.interfaces.Node;

/**
 * {@link RoutesFinder} with the shortest distance between begin node and end
 * node.
 * 
 * @author son
 */
public class RoutesFinderByShortestDistance extends RoutesFinderByConstraint {

	public RoutesFinderByShortestDistance(RoutesFinder routesFinder) {
		super(routesFinder);
	}

	public List<Node> find(String beginName, String endName, Routes distanceCalculator) {
		List<List<Node>> routes = findRoutes(beginName, endName, new Constraint(
																				distanceCalculator,
																				getGraph()
																					.getNodes()
																					.size()));

		if (routes.size() > 0) {
			return routes.get(routes.size() - 1);
		}
		return null;
	}

	public static class Constraint implements RoutesConstraint {
		public Constraint(Routes distanceCalculator, int nodesCount) {
			this.distanceCalculator = distanceCalculator;
			this.nodesCount = nodesCount;
		}

		private final Routes distanceCalculator;

		private int shortestDistance = Integer.MAX_VALUE;

		private final int nodesCount;

		@Override
		public boolean canStop(List<Node> currentRoute) {
			int currentDistance = distanceCalculator.distance(currentRoute);
			if (shortestDistance > currentDistance) {
				shortestDistance = currentDistance;
				return true;
			}
			return false;
		}

		/**
		 * The number of nodes in a route cannot be bigger than nodes count of
		 * the graph. This is to prevent cyclic graph.
		 */
		@Override
		public boolean canMoveNext(List<Node> currentRoute) {
			return distanceCalculator.distance(currentRoute) < shortestDistance &&
					currentRoute.size() <= nodesCount;
		}
	}
}
