package son.graph.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

/**
 * {@link RoutesFinder} contains algorithm to search though a graph from a begin
 * node to a end node.
 * 
 * The condition of the search is defined in {@link RoutesContraint} passed in
 * {@link #calculate(String, String, RoutesContraint)}
 * 
 * @author son
 */
public abstract class RoutesFinder extends GraphAlgorithm {
	public RoutesFinder(Graph graph) {
		super(graph);
		this.routes = new ArrayList<>();
	}

	private final List<List<Node>> routes;

	public List<List<Node>> getRoutes() {
		return routes;
	}

	protected void addRoute(LinkedList<Node> currentRoute) {
		routes.add(new ArrayList<>(currentRoute));
	}

	public abstract void calculate(String beginName, String endName,
			RoutesContraint routesContraints);
}
