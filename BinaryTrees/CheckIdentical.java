package bst;

import bst.BST.Node;

/**
 * Check if two trees are same or not
 *
 */
public class CheckIdentical {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);

		BST b2 = new BST();
		b2.root = new Node(1);
		b2.root.left = new Node(2);
		b2.root.right = new Node(3);

		System.out.print(chekidentical(b1.root, b2.root));

	}

	public static boolean chekidentical(Node a, Node b) {
		if (a == null && b == null)
			return true;
		if (a != null && b != null)
			return (a.data == b.data && chekidentical(a.left, b.left) && chekidentical(a.right, b.right));
		return false;

	}

}
