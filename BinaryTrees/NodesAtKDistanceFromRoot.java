package Amazon;

import java.util.LinkedList;
import java.util.Queue;

import Amazon.BST.Node;

//All edge cases are not covered
public class NodesAtKDistanceFromRoot {
	public static void main(String[] args) {
		BST b = new BST();
		b.insertdata(7);
		b.insertdata(0);
		b.insertdata(3);
		b.insertdata(6);
		b.insertdata(1);
		b.insertdata(8);
		b.insertdata(9);
		b.insertdata(10);
		b.insertdata(11);
		int k = 1;
		//printnodes(b.root, k);
		printnodesusinglevelorder(b.root, k);

	}

	private static void printnodesusinglevelorder(Node root, int k) {
		int count = 0;
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			if (count == k) {
				System.out.println(q);
				break;
			}
			int size = q.size();
			for (int i = 0; i < size; i++) {
				root = q.poll();
				if (root.left != null) {
					q.offer(root.left);
				}
				if (root.right != null) {
					q.offer(root.right);
				}
			}
			count++;

			
		}
	}

	/**
	 * In this keep on decrementing the value of k. bcoz we kno the no. of nodes
	 * which are at level 1 So, if we want nodes at level 3 use recursion and
	 * depth of 3.
	 *
	 */
	private static void printnodes(Node root, int k) {
		// This case is used when the k is more than height of tree
		if (root == null && k == 0) {
			return;
		}

		if (root == null)
			return;
		if (k == 0)
			System.out.print(root.data + "	");

		printnodes(root.left, k - 1);
		printnodes(root.right, k - 1);

	}

}
