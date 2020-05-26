package bst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

public class CheckLeafNodesAreAtSameLevel {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		//b1.root.right.right = new Node(6);
		System.out.print(check(b1.root));

	}

	public static boolean check(Node root) {
		if (root == null)
			return true;
		HashSet<Integer> s = new HashSet();
		Queue<Node> q = new LinkedList();
		q.offer(root);
		int level = 0;
		while (!q.isEmpty()) {
			level++;
			int size = q.size();
			while (size > 0) {
				root = q.poll();
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
				if (root.left == null && root.right == null) {
					s.add(level);
				}
				size--;
			}
			if (s.size() > 1) {
				return false;
			}
		}
		return true;

	}

}
