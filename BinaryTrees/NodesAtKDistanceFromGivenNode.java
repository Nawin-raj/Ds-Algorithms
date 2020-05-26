package Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import Amazon.BST.Node;
//watch backtoback swe video

public class NodesAtKDistanceFromGivenNode {
	public static void main(String[] args) {
		BST b = new BST();
		b.insertdata(7);
		b.insertdata(0);
		b.insertdata(3);
		b.insertdata(-1);
		b.insertdata(6);
		b.insertdata(8);
		b.insertdata(10);
		int k = 2;
		printnodes(b.root, b.root, k);

	}

	public static void printnodes(Node target, Node root, int k) {
		List<Integer> result = new LinkedList();
		HashMap<Node, Node> map = new HashMap();
		builddparent(root, root, map);
		int level = 0;
		Queue<Node> q = new LinkedList();
		q.offer(target);
		Set<Node> visited = new HashSet();
		visited.add(target);
		while (!q.isEmpty()) {
			int size = q.size();
			if (level == k)
				System.out.println(q + "hi");
			for (int i = 0; i < size; i++) {
				target = q.poll();
				if (target.left != null && !visited.contains(target.left)) {
					q.offer(target.left);
					visited.add(target.left);
				}
				if (target.right != null && !visited.contains(target.right)) {
					q.offer(target.right);
					visited.add(target.right);
				}
				Node parentnode = map.get(target);
				if (!visited.contains(parentnode))
					q.offer(parentnode);
					visited.add(parentnode);
				
			}
			level++;
		}
		

	}

	/**
	 * This method stores the parents of every node in bst using hashmap.
	 *
	 */
	public static void builddparent(Node parent, Node child, HashMap<Node, Node> map) {
		if (child == null)
			return;
		map.put(child, parent);
		builddparent(child, child.left, map);
		builddparent(child, child.right, map);
	}

}
