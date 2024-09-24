package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	public Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node data=" + data;
		}

	}
/*

Preorder traversal visits the node in the order: Root -> Left -> Right
Inorder traversal visits the node in the order: Left -> Root -> Right
Postorder traversal visits the node in the order: Left -> Right -> Root
*/
	public static void main(String[] args) {
		BST b = new BST();

		b.insertdata(1);
		b.insertdata(0);
		b.insertdata(2);

		/**
		 * Recursive preorder,inorder,postorder traversal
		 */
		b.preorder(b.root);
		System.out.println();
		b.inorder(b.root);
		System.out.println();
		b.postorder(b.root);
		System.out.println();

		/**
		 * Iterative preorder,inorder,postorder traversal
		 */
		b.itepreorder(b.root);
		System.out.println();
		b.iteinorder(b.root);
		System.out.println();
		b.itepostorder(b.root);
		System.out.println();
		b.levelorder(b.root);

	}

	public void itepreorder(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack();
		s.push(root);
		while (!s.isEmpty()) {
			root = s.pop();
			System.out.print(root.data);
			if (root.right != null) {
				s.push(root.right);
			}
			if (root.left != null) {
				s.push(root.left);
			}

		}

	}

	public void iteinorder(Node root) {
		if (root == null)
			return;
		Stack<Node> s = new Stack();
		while (true) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				if (s.isEmpty())
					break;
				root = s.pop();
				System.out.print(root.data);
				root = root.right;
			}
		}
	}

	// watch Tushar Roy video using one stack
	public void itepostorder(Node root) {
		Node current = root;
		Stack<Node> s = new Stack();
		while (current != null || !s.isEmpty()) {
			if (current != null) {
				s.push(current);
				current = current.left;
			} else {
				Node temp = s.peek().right;
				if (temp == null) {
					temp = s.pop();
					System.out.print(temp.data);
					while (!s.isEmpty() && temp == s.peek().right) {
						temp = s.pop();
						System.out.print(temp.data);
					}
				} else {
					current = temp;
				}
			}

		}

	}

	public void levelorder(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			root = q.poll();
			System.out.println(root.data);
			if (root.left != null) {
				q.offer(root.left);
			}
			if (root.right != null) {
				q.offer(root.right);
			}

		}
	}
	// Recursive preorder,inorder,postorder traversal

	public void preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data);
		preorder(root.left);
		preorder(root.right);

	}

	public void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}

	public void postorder(Node root) {
		if (root == null)
			return;
		preorder(root.left);
		preorder(root.right);
		System.out.print(root.data);

	}

	public void insertdata(int key) {
		root = insert(root, key);

	}

	public Node insert(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else if (key < root.data) {
			root.left = insert(root.left, key);
		} else {
			root.right = insert(root.right, key);
		}
		return root;
	}

}
