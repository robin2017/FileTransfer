import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Robin
 * @date 2016年4月24日 下午6:59:51
 * @version 1.0
 */
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	
	public static void main(String[] args){
		UndirectedGraphNode u0=new UndirectedGraphNode(0);
		UndirectedGraphNode u1=new UndirectedGraphNode(1);
		UndirectedGraphNode u2=new UndirectedGraphNode(2);
		u0.neighbors.add(u1);
		u0.neighbors.add(u2);
		u1.neighbors.add(u0);
		u1.neighbors.add(u2);
		u2.neighbors.add(u0);
		u2.neighbors.add(u1);
		u2.neighbors.add(u2);
		UndirectedGraphNode result=cloneGraph(u0);
	}
	
	private static HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {// 51zan
		return clone(node);
	}

	private static UndirectedGraphNode clone(UndirectedGraphNode node) {
		if (node == null)
			return null;

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(clone.label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			clone.neighbors.add(clone(neighbor));
		}
		return clone;
	}
}
