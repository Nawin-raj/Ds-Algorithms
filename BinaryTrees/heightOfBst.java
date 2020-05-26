package bst;

import bst.BST.Node;

public class Heightofbst {
	static int ans = 0;

	public static void main(String[] args) {
		Heightofbst hb = new Heightofbst();
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		int height = heightofbst(b1.root);
		System.out.println(height);

		int size = sizeofbst(b1.root);
		System.out.println(size);

	}

	// sizeofbst means total no. of nodes in tree
	public static int sizeofbst(Node root) {
		if (root == null)
			return 0;
		int left = sizeofbst(root.left);
		int right = sizeofbst(root.right);
		return left + right + 1;
	}

	// heightofbst means longest path from root to leaf tree
	public static int heightofbst(Node root) {
		if (root == null)
			return 0;
		int left = heightofbst(root.left);
		int right = heightofbst(root.right);
		return 1 + Math.max(left, right); // if u want min place math.min
	}

}
