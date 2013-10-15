package son.graph;

import java.util.List;

import son.graph.algorithms.RoutesContraint;
import son.graph.algorithms.RoutesFinder;
import son.graph.models.interfaces.Node;

public class RoutesFinderByStopsMax extends RoutesFinderByConstraint {

	public RoutesFinderByStopsMax(RoutesFinder routesFinder) {
		super(routesFinder);
	}

	public void calculate(String beginName, String endName, int stopsMax) {
		calculate(beginName, endName, new Constraint(stopsMax));
	}

	public static class Constraint implements RoutesContraint {
		public Constraint(int stopsMax) {
			this.stopsMax = stopsMax;
		}

		private final int stopsMax;

		@Override
		public boolean canStop(List<Node> currentRoute) {
			return currentRoute.size() < stopsMax + 2;
		}

		@Override
		public boolean canMoveNext(List<Node> currentRoute) {
			return currentRoute.size() < stopsMax + 2;
		}

	}
}