package bst;

import java.util.LinkedList;
import java.util.Queue;

import bst.BST.Node;

//Recursive	code	is	pending
public class OddEvenLevelDiff {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		//System.out.print(oddevendiff(b1.root));
		System.out.print(maxlevelsum(b1.root));

	}

	public static int maxlevelsum(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		int level = 0;
		int max_sum = Integer.MIN_VALUE;

		while (!q.isEmpty()) {
			level++;
			int size = q.size();
			int sum = 0;
			while (size > 0) {
				root = q.poll();
				sum += root.data;
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
				size--;
			}
			if (sum > max_sum)
				max_sum = sum;
		}
		return max_sum;
	}

	public static int oddevendiff(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		int level = 0;
		int even_sum = 0;
		int odd_sum = 0;
		while (!q.isEmpty()) {
			level++;
			int size = q.size();
			while (size > 0) {
				root = q.poll();
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
				if (level % 2 != 0)
					odd_sum = odd_sum + root.data;
				else
					even_sum += root.data;
				size--;

			}
		}
		return odd_sum - even_sum;
	}

}
