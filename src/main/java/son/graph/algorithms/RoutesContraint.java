package son.graph.algorithms;

import java.util.List;

import son.graph.models.interfaces.Node;

public interface RoutesContraint {
	public boolean canStop(List<Node> currentRoute);

	public boolean canMoveNext(List<Node> currentRoute);
}
