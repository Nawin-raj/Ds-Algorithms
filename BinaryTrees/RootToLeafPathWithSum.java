package bst;

import java.util.Stack;

import bst.BST.Node;

public class RootToLeafPathWithSum {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		Stack<Integer> s = new Stack();
		int sum = 0;
		int k = 7;
		// usinginorder(b1.root, s, sum, k);
		System.out.print(checkroottoleafexists(b1.root, k));

	}

	// check this
	public static boolean checkroottoleafexists(Node root, int k) {
		if (root == null)
			return k == 0;
		return checkroottoleafexists(root.left, k - root.data) || checkroottoleafexists(root.right, k - root.data);

	}

	public static void usinginorder(Node root, Stack s, int sum, int k) {
		if (root == null)
			return;

		s.push(root.data);
		sum = sum + (Integer) s.peek();
		// add this code if u want to check a path with given sum exists or not
		if (sum == k)
			System.out.println(sum);
		if (root.left == null && root.right == null) {
			System.out.println(s);
			System.out.println(sum);
		} else {
			usinginorder(root.left, s, sum, k);
			usinginorder(root.right, s, sum, k);
		}
		sum = sum - (Integer) s.peek();
		s.pop();

	}
}
