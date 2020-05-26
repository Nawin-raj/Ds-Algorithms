package bst;

import bst.BST.Node;

public class RemoveHalfNodes {

	public static void main(String[] args) {
		BST b = new BST();
		b.root = new Node(10);
		b.root.left = new Node(11);
		b.root.right = new Node(9);
		b.root.left.left = new Node(7);
		Node k = RemoveHalfNodes(b.root);
	}

	static Node RemoveHalfNodes(Node node) {
		if (node == null)
			return null;

		node.left = RemoveHalfNodes(node.left);
		node.right = RemoveHalfNodes(node.right);

		if (node.left == null && node.right == null)
			return node;

		/*
		 * if current nodes is a half node with left child NULL left, then it's
		 * right child is returned and replaces it in the given tree
		 */
		if (node.left == null) {
			Node new_root = node.right;
			return new_root;
		}

		/*
		 * if current nodes is a half node with right child NULL right, then
		 * it's right child is returned and replaces it in the given tree
		 */
		if (node.right == null) {
			Node new_root = node.left;
			return new_root;
		}

		return node;
	}

}
