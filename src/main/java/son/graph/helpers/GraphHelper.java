package son.graph.helpers;

import java.util.ArrayList;
import java.util.List;

import son.graph.models.interfaces.Edge;
import son.graph.models.interfaces.Graph;
import son.graph.models.interfaces.Node;

public class GraphHelper {
	public static List<String> getNames(List<Node> nodes) {
		List<String> names = new ArrayList<>();
		for (Node node : nodes) {
			names.add(node.getName());
		}
		return names;
	}

	public static List<Node> getNodes(Graph graph, String... names) {
		List<Node> nodes = new ArrayList<>();

		for (String name : names) {
			nodes.add(graph.getNodes().get(name));
		}
		return nodes;
	}

	public static List<Node> getNextNodes(Node node) {
		List<Node> nextNodes = new ArrayList<>();
		for (Edge edge : node.getEdges()) {
			nextNodes.add(edge.getNextNode());
		}
		return nextNodes;
	}
}
