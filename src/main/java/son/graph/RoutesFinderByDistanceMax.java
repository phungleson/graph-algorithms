package son.graph;

import java.util.List;

import son.graph.algorithms.DistanceCalculator;
import son.graph.algorithms.RoutesContraint;
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

	public void calculate(String beginName, String endName, DistanceCalculator distanceCalculator,
			int distanceMax) {
		calculate(beginName, endName, new Constraint(distanceCalculator, distanceMax));
	}

	public static class Constraint implements RoutesContraint {
		public Constraint(DistanceCalculator distanceCalculator, int distanceMax) {
			this.distanceCalculator = distanceCalculator;
			this.distanceMax = distanceMax;
		}

		private final DistanceCalculator distanceCalculator;

		private final int distanceMax;

		@Override
		public boolean canStop(List<Node> currentRoute) {
			return distanceCalculator.calculate(currentRoute) < distanceMax;
		}

		@Override
		public boolean canMoveNext(List<Node> currentRoute) {
			return distanceCalculator.calculate(currentRoute) < distanceMax;
		}
	}
}
