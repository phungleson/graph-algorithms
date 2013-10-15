package son.graph

import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper
import son.graph.models.interfaces.Graph

describe RoutesFinderByDistanceMax {
	var Graph graph;
	var RoutesFinder algorithm; 
	var RoutesFinderByDistanceMax subject;

	before {
		graph = TestHelper.graph
		algorithm = new RoutesFinderBFS(graph);
	}
	describe "#calculate" {
		context "given BFS, C to C" {
			fact {
				subject = new RoutesFinderByDistanceMax(algorithm);
				subject.calculate("C", "C", new SimpleDistanceCalculator(graph), 30)
				subject.routes.forEach[ println(GraphHelper.getNames(it)) ]
				subject.routes.size should be 7
			}
		}		
	}
}
