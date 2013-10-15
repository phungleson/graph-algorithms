package son.graph;

import java.util.List;

import son.graph.algorithms.DistanceCalculator;
import son.graph.algorithms.RoutesContraint;
import son.graph.algorithms.RoutesFinder;
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

	public void calculate(String beginName, String endName, DistanceCalculator distanceCalculator) {
		calculate(beginName, endName, new Constraint(distanceCalculator, getGraph()
			.getNodes()
			.size()));

		if (getRoutes().size() > 0) {
			shortestRoute = getRoutes().get(getRoutes().size() - 1);
		}
	}

	private List<Node> shortestRoute;

	public List<Node> getShortestRoute() {
		return shortestRoute;
	}

	public static class Constraint implements RoutesContraint {
		public Constraint(DistanceCalculator distanceCalculator, int nodesCount) {
			this.distanceCalculator = distanceCalculator;
			this.nodesCount = nodesCount;
		}

		private final DistanceCalculator distanceCalculator;

		private int shortestDistance = Integer.MAX_VALUE;

		private final int nodesCount;

		@Override
		public boolean canStop(List<Node> currentRoute) {
			int currentDistance = distanceCalculator.calculate(currentRoute);
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
			return distanceCalculator.calculate(currentRoute) < shortestDistance &&
					currentRoute.size() <= nodesCount;
		}
	}
}
