package son.graph.models.interfaces;

public interface GraphBuilder {
	public Graph getGraph();

	public void addEdge(String name, String nextName, int weight);
}
