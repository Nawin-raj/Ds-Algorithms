package bst;

import bst.BST.Node;

public class MirrorBinary {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		//tree.root.right.right = new Node(3);
		System.out.println(issymmetric(tree.root));

	}

	public static boolean issymmetric(Node root) {
		return root == null || check(root.left, root.right);

	}

	public static boolean check(Node left, Node right) {
		if (left == null && right == null)
			return true;
		if (left != null && right != null && left.data == right.data) {
			return check(left.left, right.right) && check(left.right, right.left);
		}
		return false;
	}

}
