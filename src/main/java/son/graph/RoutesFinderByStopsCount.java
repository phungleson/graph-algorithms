package son.graph;

import java.util.List;

import son.graph.algorithms.RoutesContraint;
import son.graph.algorithms.RoutesFinder;
import son.graph.models.interfaces.Node;

/**
 * {@link RoutesFinder} with the number of stops between begin node and end node
 * is exactly the same with stops count.
 * 
 * @author son
 */
public class RoutesFinderByStopsCount extends RoutesFinderByConstraint {

	public RoutesFinderByStopsCount(RoutesFinder routesFinder) {
		super(routesFinder);
	}

	public void calculate(String beginName, String endName, int stopsCount) {
		calculate(beginName, endName, new Constraints(stopsCount));
	}

	public static class Constraints implements RoutesContraint {
		public Constraints(int stopsCount) {
			this.stopsCount = stopsCount;
		}

		private final int stopsCount;

		@Override
		public boolean canStop(List<Node> currentRoute) {
			return currentRoute.size() == stopsCount + 1;
		}

		@Override
		public boolean canMoveNext(List<Node> currentRoute) {
			return currentRoute.size() < stopsCount + 1;
		}
	}
}
