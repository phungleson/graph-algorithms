package son.graph

import son.graph.algorithms.DistanceCalculator
import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper
import son.graph.models.interfaces.Graph

describe RoutesFinderByDistanceMax {
	var Graph graph;
	var RoutesFinder algorithm; 
	var DistanceCalculator distanceCalculator;
	var RoutesFinderByDistanceMax subject;

	before {
		graph = TestHelper.graph
		distanceCalculator = new SimpleDistanceCalculator()
		algorithm = new RoutesFinderBFS(graph);
	}
	describe "#calculate" {
		context "given BFS, C to C" {
			fact {
				subject = new RoutesFinderByDistanceMax(algorithm);
				subject.calculate("C", "C", distanceCalculator, 30)
				subject.routes.size should be 7
				subject.routes.forEach[ println(GraphHelper.getNodeNames(it)) ]
			}
		}		
	}
}
