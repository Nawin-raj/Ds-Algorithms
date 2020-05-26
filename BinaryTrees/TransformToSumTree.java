package bst;

import bst.BST.Node;

//it	is	better	if	u	check	once	GFG
public class TransformToSumTree {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.left = new Node(6);
		b1.root.right.right = new Node(7);
		System.out.println("before");
		b1.inorder(b1.root);
		System.out.println();
		transformtoSumTree(b1.root);
		System.out.println("after");
		b1.inorder(b1.root);

	}

	public static int transformtoSumTree(Node root) {
		if (root == null)
			return 0;
		int old_val = root.data;
		// if (root.left == null && root.right == null)
		// return 0;
		int l = transformtoSumTree(root.left);
		int r = transformtoSumTree(root.right);
		root.data = l + r;
		return root.data + old_val;

	}

}
