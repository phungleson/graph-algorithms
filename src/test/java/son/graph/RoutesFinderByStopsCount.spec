package son.graph

import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper

describe RoutesFinderByStopsCount {
	var RoutesFinder algorithm;
	var RoutesFinderByStopsCount subject;

	before {
		algorithm = new RoutesFinderBFS(TestHelper.graph);
	}

	describe "#findRoutes" {
		context "given BFS, A to C" {
			fact {
				subject = new RoutesFinderByStopsCount(algorithm);
				var routes = subject.findRoutes("A", "C", 4)
				routes.size should be 3
				routes.forEach[ println(GraphHelper.getNodeNames(it)) ]
			}
		}
	}
}
