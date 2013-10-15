package son.graph

import son.graph.algorithms.RoutesFinder
import son.graph.algorithms.RoutesFinderBFS
import son.graph.helpers.GraphHelper
import son.graph.models.interfaces.Graph
import son.graph.algorithms.DistanceCalculator

describe RoutesFinderByShortestDistance {
	var Graph graph;
	var RoutesFinder algorithm;
	var DistanceCalculator distanceCalculator; 
	var RoutesFinderByShortestDistance subject;

	before {
		graph = TestHelper.graph
		distanceCalculator = new SimpleDistanceCalculator();
		algorithm = new RoutesFinderBFS(graph);
		subject = new RoutesFinderByShortestDistance(algorithm);
	}
	describe "#calculate" {
		context "given BFS, A to C" {
			fact {
				subject.calculate("A", "C", distanceCalculator);

				subject.shortestRoute should not be null
				distanceCalculator.calculate(subject.shortestRoute) should be 9
				println(GraphHelper.getNodeNames(subject.shortestRoute))
			}
		}
		
		context "given BFS, B to B" {
			fact {
				subject.calculate("B", "B", distanceCalculator);

				subject.shortestRoute should not be null
				distanceCalculator.calculate(subject.shortestRoute) should be 9
				println(GraphHelper.getNodeNames(subject.shortestRoute))
			}
		}
	}
}
