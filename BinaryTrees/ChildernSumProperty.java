package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

/**
 * This is iterative using queue 
 * We can solve using recursion also check	GFG(pending)
 * 
 */
public class ChildernSumProperty {

	public static void main(String[] args) {
		BST b = new BST();
		b.root = new Node(10);
		b.root.left = new Node(8);
		b.root.right = new Node(2);
		b.root.left.left = new Node(3);
		b.root.left.right = new Node(6);
		b.root.right.right = new Node(2);
		System.out.print(issumproperty(b.root));

	}

	public static int issumproperty(Node root) {
		int flag = 1;
		if (root == null)
			return 1;
		Queue<Node> q = new LinkedList();
		q.add(root);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root.left == null && root.right == null)
				flag = 1;

			int left = (root.left != null) ? root.left.data : 0;
			int right = (root.right != null) ? root.right.data : 0;

			if (root.data == left + right || root.left == null && root.right == null) {
				flag = 1;

			} else {
				flag = 0;
				break;
			}
			if (root.left != null) {
				q.offer(root.left);
			}
			if (root.right != null) {
				q.offer(root.right);
			}

		}
		return flag;
	}

}
