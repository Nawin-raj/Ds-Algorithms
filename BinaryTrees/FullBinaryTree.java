package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

public class FullBinary {

	public static void main(String[] args) {
		BST b = new BST();
		b.insertdata(6);
		b.insertdata(4);
		b.insertdata(7);
		b.insertdata(3);
		b.insertdata(5);
		
		System.out.print(checkfull(b.root));

	}

	private static boolean checkfull(Node root) {
		if (root == null)
			return true;
		boolean flag = true;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			if (flag == false)
				return false;
			// System.exit(0);
			root = q.poll();
			if (root.left != null && root.right != null) {
				q.offer(root.left);
				q.offer(root.right);
			} else if (root.left == null && root.right == null) {
				flag = true;
			} else {
				flag = false;
			}

		}
		return true;
	}

}
