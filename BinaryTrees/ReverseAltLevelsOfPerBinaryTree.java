package bst;

import bst.BST.Node;

public class ReverseAltLevelsOfPerBinaryTree {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.left = new Node(6);
		b1.root.right.right = new Node(7);
		b1.root.left.left.left = new Node(11);
		b1.root.left.left.right = new Node(12);
		//b1.levelorder(b1.root);
		revesre(b1.root);
		b1.levelorder(b1.root);

	}

	public static void revesre(Node root) {
		helper(root.left, root.right, 0);
	}

	public static void helper(Node root1, Node root2, int lvl) {
		if (root1 == null || root2 == null)
			return;

		// Swap subtrees if level is even
		if (lvl % 2 == 0) {
			int t = root1.data;
			root1.data = root2.data;
			root2.data = t;
		}
		helper(root1.left, root2.right, lvl + 1);
		helper(root1.right, root2.left, lvl + 1);
	}

}
