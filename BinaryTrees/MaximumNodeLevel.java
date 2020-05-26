package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;
//working in Eclipse not in GFG
public class MaximumNodeLevel {

	public static void main(String[] args) {
		BST b = new BST();
		b.root = new Node(5);
        b.root.left = new Node(2); 
        b.root.right = new Node(6); 
        b.root.left.left = new Node(1); 
        b.root.left.right = new Node(4); 
        b.root.left.right.left = new Node(3); 
        b.root.left.right.right = new Node(30); 
        b.root.right.right = new Node(8); 
        b.root.right.right.right = new Node(9); 
        b.root.right.right.left = new Node(7);
		

		System.out.print(getmaxnodelevel(b.root));

	}

	public static int getmaxnodelevel(Node root) {
		int curent_level = 0;
		int max_node_level = 0;
		int max_node = 0;
		if (root == null)
			return -1;
		Queue<Node> q = new LinkedList();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();

			if (size > max_node) {
				max_node = size;
				max_node_level = curent_level;
			}
			for (int i = 0; i < size; i++) {
				root = q.poll();
				if (root.left != null) {
					q.offer(root.left);
				}
				if (root.right != null) {
					q.offer(root.right);
				}
			}
			curent_level++;
			size = 0;
		}

		return max_node_level;
	}
}
