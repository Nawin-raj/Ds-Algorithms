package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

public class ReverseLevelOrder {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		reverselevelorder(b1.root);
		levelorder(b1.root);
	}

	public static void levelorder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> list = new ArrayList();
		q.offer(root);
		while (!q.isEmpty()) {
			int k = q.size();
			for (int i = 0; i < k; i++) {
				root = q.poll();
				System.out.print(root.data + " ");
				if (root.left != null) {
					q.offer(root.left);
				}
				if (root.right != null) {
					q.offer(root.right);
				}
			}
			System.out.print("$" + " ");

		}

	}

	public static void reverselevelorder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		ArrayList<Node> list = new ArrayList();
		q.offer(root);
		while (!q.isEmpty()) {
			root = q.poll();
			// System.out.println(root.data);
			if (root.right != null) {
				q.offer(root.right);
			}
			if (root.left != null) {
				q.offer(root.left);
			}
			list.add(root);

		}
		for (int i = list.size() - 1; i >= 0; i--)
			System.out.print(list.get(i).data + " ");
	}

}
