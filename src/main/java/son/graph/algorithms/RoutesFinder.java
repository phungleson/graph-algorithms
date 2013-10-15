package son.graph.algorithms;

import java.util.List;

import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

/**
 * {@link RoutesFinder} contains algorithm to search though a graph from a
 * begin node to a end node.
 * 
 * The condition of the search is defined in {@link RoutesConstraint} passed in
 * {@link #findRoutes(String, String, RoutesConstraint)}
 * 
 * @author son
 */
public abstract class RoutesFinder extends GraphAlgorithm {
	public RoutesFinder(Graph graph) {
		super(graph);
	}

	public abstract List<List<Node>> findRoutes(String beginName, String endName,
			RoutesConstraint routesContraints);
}
