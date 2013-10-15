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
	describe "#calculate" {
		context "given BFS, C to C" {
			fact {
				subject = new RoutesFinderByStopsMax(algorithm)
				subject.calculate("C", "C", 3)
				subject.routes.size should be 2
				subject.routes.forEach[ println(GraphHelper.getNodeNames(it)) ]
			}
		}		
	}
}
