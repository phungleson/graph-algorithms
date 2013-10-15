package son.graph;

import java.util.List;

import son.graph.algorithms.Routes;
import son.graph.algorithms.RoutesConstraint;
import son.graph.algorithms.RoutesFinder;
import son.graph.models.interfaces.Node;

/**
 * {@link RoutesFinder} with distance between begin node and end node no more
 * than distance max.
 * 
 * @author son
 */
public class RoutesFinderByDistanceMax extends RoutesFinderByConstraint {
	public RoutesFinderByDistanceMax(RoutesFinder routesFinder) {
		super(routesFinder);
	}

	public List<List<Node>> findRoutes(String beginName, String endName, Routes distanceCalculator,
			int distanceMax) {
		return findRoutes(beginName, endName, new Constraint(distanceCalculator, distanceMax));
	}

	public static class Constraint implements RoutesConstraint {
		public Constraint(Routes distanceCalculator, int distanceMax) {
			this.distanceCalculator = distanceCalculator;
			this.distanceMax = distanceMax;
		}

		private final Routes distanceCalculator;

		private final int distanceMax;

		@Override
		public boolean canStop(List<Node> currentRoute) {
			return distanceCalculator.distance(currentRoute) < distanceMax;
		}

		@Override
		public boolean canMoveNext(List<Node> currentRoute) {
			return distanceCalculator.distance(currentRoute) < distanceMax;
		}
	}
}
