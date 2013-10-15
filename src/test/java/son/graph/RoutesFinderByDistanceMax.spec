package son.graph

import son.graph.algorithms.Routes
import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper
import son.graph.models.interfaces.Graph

describe RoutesFinderByDistanceMax {
	var Graph graph;
	var RoutesFinder algorithm; 
	var Routes routesCalculator;
	var RoutesFinderByDistanceMax subject;

	before {
		graph = TestHelper.graph
		routesCalculator = new SimpleRoutes()
		algorithm = new RoutesFinderBFS(graph);
	}

	describe "#calculate" {
		context "given BFS, C to C" {
			fact {
				subject = new RoutesFinderByDistanceMax(algorithm);
				var routes = subject.findRoutes("C", "C", routesCalculator, 30)
				routes.size should be 7
				routes.forEach[ println(GraphHelper.getNodeNames(it)) ]
			}
		}		
	}
}
