package son.graph

import son.graph.algorithms.DistanceCalculator
import son.graph.exceptions.RouteNotFoundException
import son.graph.models.interfaces.Graph
import son.graph.helpers.GraphHelper

describe SimpleDistanceCalculator {
	var Graph graph
	var DistanceCalculator subject

	before {
		graph = TestHelper.graph
		subject = new SimpleDistanceCalculator(graph)
	}

	describe "#calculate" {
		fact "route A-B-C" {
			subject.calculate(
				GraphHelper.getNodes(graph, "A", "B", "C")
			) should be 9
		}
		
		fact "route A-D" {
			subject.calculate(
				GraphHelper.getNodes(graph, "A", "D")
			) should be 5
		}
		
		fact "route A-D-C" {
			subject.calculate(
				GraphHelper.getNodes(graph, "A", "D", "C")
			) should be 13
		}
		
		fact "route A-E-B-C-D" {
			subject.calculate(
				GraphHelper.getNodes(graph, "A", "E", "B", "C", "D")
			) should be 22			
		}
		
		fact "route A-E-D" {
			subject.calculate(GraphHelper.getNodes(graph, "A", "E", "D")) throws RouteNotFoundException 			
		}
	}
}