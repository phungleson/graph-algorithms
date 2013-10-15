package son.graph;

import java.util.List;

import son.graph.algorithms.RoutesContraint;
import son.graph.algorithms.RoutesFinder;
import son.graph.models.interfaces.Node;

public abstract class RoutesFinderByConstraint extends RoutesFinder {
	public RoutesFinderByConstraint(RoutesFinder routesFinder) {
		super(routesFinder.getGraph());
		this.routesFinder = routesFinder;
	}

	private final RoutesFinder routesFinder;

	@Override
	public void calculate(String beginName, String endName, RoutesContraint routesContraints) {
		routesFinder.calculate(beginName, endName, routesContraints);
	}

	@Override
	public List<List<Node>> getRoutes() {
		return routesFinder.getRoutes();
	}
}
