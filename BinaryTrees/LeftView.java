package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

/**
 * This code is Working fine in this we are travesing tree in levelorder and
 * printing the first element of current level.
 *
 */
public class LeftView {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		leftsideview(b1.root);

	}

	public static void leftsideview(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				root = queue.poll();
				if (i == 1) {
					System.out.print(root.data + " ");
				}

				if (root.left != null) {
					queue.add(root.left);
				}

				if (root.right != null) {
					queue.add(root.right);
				}
			}
		}
	}

}
