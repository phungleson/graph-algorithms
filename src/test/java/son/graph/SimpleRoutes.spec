package son.graph

import son.graph.algorithms.Routes
import son.graph.exceptions.RouteNotFoundException
import son.graph.models.interfaces.Graph
import son.graph.helpers.GraphHelper

describe SimpleRoutes {
	var Graph graph
	var Routes subject

	before {
		graph = TestHelper.graph
		subject = new SimpleRoutes()
	}

	describe "#distance" {
		fact "route A-B-C" {
			subject.distance(
				GraphHelper.getNodes(graph, "A", "B", "C")
			) should be 9
		}

		fact "route A-D" {
			subject.distance(
				GraphHelper.getNodes(graph, "A", "D")
			) should be 5
		}

		fact "route A-D-C" {
			subject.distance(
				GraphHelper.getNodes(graph, "A", "D", "C")
			) should be 13
		}

		fact "route A-E-B-C-D" {
			subject.distance(
				GraphHelper.getNodes(graph, "A", "E", "B", "C", "D")
			) should be 22
		}

		fact "route A-E-D" {
			subject.distance(GraphHelper.getNodes(graph, "A", "E", "D")) throws RouteNotFoundException
		}
	}
}