package son.graph

import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper

describe RoutesFinderByStopsMax {
	var RoutesFinder algorithm;
	var RoutesFinderByStopsMax subject;

	before {
		algorithm = new RoutesFinderBFS(TestHelper.graph);
	}
	describe "#findRoutes" {
		context "given BFS, C to C" {
			fact {
				subject = new RoutesFinderByStopsMax(algorithm)
				var routes = subject.findRoutes("C", "C", 3)
				routes should be 2
				routes.forEach[ println(GraphHelper.getNodeNames(it)) ]
			}
		}
	}
}
