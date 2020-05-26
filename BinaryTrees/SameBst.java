package bst;

import bst.BST.Node;

public class SameBst {

	public static void main(String[] args) {
		BST b1 = new BST();
		BST b2 = new BST();
		b1.insertdata(1);
		b1.insertdata(0);
		b1.insertdata(2);

		b2.insertdata(1);
		b2.insertdata(-1);
		b2.insertdata(2);

		boolean flag = sametree(b1.root, b2.root);
		System.out.println(flag);
	}

	public static boolean sametree(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.data == root2.data && 
				sametree(root1.left, root2.left) &&
				sametree(root1.right, root2.right);

	}

}
