package bst;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import bst.BST.Node;

public class ZigZagOrSpiralTravesral {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		zigzagusingtwostack(b1.root);
		// zigzagusingdeque(b1.root);

	}

	/**
	 * In this we are using deque Refer tushroy video supports element insertion
	 * and removal at both ends.
	 */
	public static void zigzagusingdeque(Node root) {
		Deque<Node> q = new LinkedList<>();
		q.offer(null);
		q.offerFirst(root);
		// if only delimiter(in this case null) is left in queue then break
		while (q.size() > 1) {
			root = q.peekFirst();
			while (root != null) {
				root = q.pollFirst();
				System.out.print(root.data + " ");
				if (root.left != null) {
					q.offerLast(root.left);
				}
				if (root.right != null) {
					q.offerLast(root.right);
				}
				root = q.peekFirst();
			}
			root = q.peekLast();
			while (root != null) {
				System.out.print(root.data + " ");
				root = q.pollLast();
				if (root.right != null) {
					q.offerFirst(root.right);
				}
				if (root.left != null) {
					q.offerFirst(root.left);
				}
				root = q.peekLast();
			}
		}

	}

	/**
	 * In this we are using to stacks Refer tushroy video
	 */
	public static void zigzagusingtwostack(Node root) {
		if (root == null)
			return;
		Stack<Node> s1 = new Stack();
		Stack<Node> s2 = new Stack();
		s1.push(root);
		while (!s1.isEmpty() && s2.isEmpty()) {
			while (!s1.isEmpty()) {
				root = s1.pop();
				System.out.print(root.data);
				if (root.right != null)
					s2.push(root.right);
				if (root.left != null)
					s2.push(root.left);
			}
			while (!s2.isEmpty()) {
				root = s2.pop();
				System.out.print(root.data);
				if (root.left != null)
					s1.push(root.left);
				if (root.right != null)
					s1.push(root.right);

			}

		}
	}

}
