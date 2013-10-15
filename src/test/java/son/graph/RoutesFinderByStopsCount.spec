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
	describe "#calculate" {
		context "given BFS, A to C" {
			fact {
				subject = new RoutesFinderByStopsCount(algorithm);
				subject.calculate("A", "C", 4)
				subject.routes.forEach[ println(GraphHelper.getNames(it)) ]
				subject.routes.size should be 3
			}
		}		
	}
}
