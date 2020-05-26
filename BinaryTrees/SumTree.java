package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

//not	like	childernsumproperty	it	is	different
public class SumTree {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(10);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(1);
		b1.root.left.right = new Node(11);
		b1.root.right.right = new Node(3);

		System.out.print(isumtree(b1.root));
		System.out.print(issumtreerecursive(b1.root));

	}

	public static int issumtreerecursive(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return root.data;
		}

		if (root.data == issumtreerecursive(root.left) + issumtreerecursive(root.right)) {
			return 2 * root.data;
		} else {
			return Integer.MIN_VALUE;
			
		}

	}

	public static boolean isumtree(Node root) {
		boolean flag = false;
		if (root == null)
			flag = true;
		int sum = 0;
		int rootdata = root.data;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			root = q.poll();
			sum = sum + root.data;
			if (root.left != null) {
				q.offer(root.left);
			}
			if (root.right != null) {
				q.offer(root.right);
			}
		}
		int value = sum - rootdata;
		if (value == rootdata)
			flag = true;
		else
			flag = false;
		return flag;
	}
}
