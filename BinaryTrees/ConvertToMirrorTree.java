package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

/**
 * Inorder traversal of tree 621435 After conerting into mirror tree the inorder
 * traversal is 534126
 *
 */
public class ConvertToMirrorTree {

	public static void main(String[] args) {
		BST b = new BST();
		b.root = new Node(1);
		b.root.left = new Node(2);
		b.root.right = new Node(3);
		b.root.left.left = new Node(6);
		b.root.right.left = new Node(4);
		b.root.right.right = new Node(5);
		
		b.inorder(b.root);
		mirrortree(b.root);
		System.out.println();
		b.inorder(b.root);

		b.inorder(b.root);
		System.out.println();
		mirrortreerecursive(b.root);
		b.inorder(b.root);

	}

	public static void mirrortreerecursive(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return;
		mirrortreerecursive(root.left);
		mirrortreerecursive(root.right);

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

	}

	public static void mirrortree(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		while (!q.isEmpty()) {
			root = q.poll();
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
			if (root.left != null) {
				q.offer(root.left);
			}
			if (root.right != null) {
				q.offer(root.right);
			}

		}
	}

}
