package son.graph

import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper
import son.graph.models.interfaces.Graph
import son.graph.algorithms.Routes

describe RoutesFinderByShortestDistance {
	var Graph graph;
	var RoutesFinder algorithm;
	var Routes routes;
	var RoutesFinderByShortestDistance subject;

	before {
		graph = TestHelper.graph
		routes = new SimpleRoutes();
		algorithm = new RoutesFinderBFS(graph);
	}

	describe "#find" {
		context "given BFS, A to C" {
			fact {
				subject = new RoutesFinderByShortestDistance(algorithm);
				var route = subject.find("A", "C", routes);

				route should not be null
				routes.distance(route) should be 9
				println(GraphHelper.getNodeNames(route))
			}
		}

		context "given BFS, B to B" {
			fact {
				subject = new RoutesFinderByShortestDistance(algorithm);
				var route = subject.find("B", "B", routes);

				route should not be null
				routes.distance(route) should be 9
				println(GraphHelper.getNodeNames(route))
			}
		}
	}
}
