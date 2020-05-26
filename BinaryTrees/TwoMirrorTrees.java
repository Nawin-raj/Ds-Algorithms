package bst;

import bst.BST.Node;

public class TwoMirrorTrees {

	public static void main(String[] args) {
		BST b = new BST();
		b.root = new Node(1);
		b.root.left = new Node(3);
		b.root.right = new Node(2);
		b.root.right.left = new Node(5);
		b.root.right.right = new Node(4);

		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);

		System.out.print(aremirror(b.root, b1.root));

	}

	public static boolean aremirror(Node a, Node b) {

		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;

		return a.data == b.data && aremirror(a.left, b.right) && aremirror(a.right, b.left);

	}

}
